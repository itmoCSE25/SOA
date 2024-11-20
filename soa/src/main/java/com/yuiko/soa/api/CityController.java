package com.yuiko.soa.api;

import java.util.List;

import com.yuiko.soa.model.CitiesRequest;
import com.yuiko.soa.model.CitiesWithPagerDto;
import com.yuiko.soa.model.City;
import com.yuiko.soa.model.CityField;
import com.yuiko.soa.model.FilterType;
import com.yuiko.soa.model.Pager;
import com.yuiko.soa.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class CityController implements CityApiDelegate {

    private final CityService cityService;

    public CityController(
            CityService cityService
    ) {
        this.cityService = cityService;
    }

    @Override
    public ResponseEntity<Void> deleteCityById(Long cityId) {
        cityService.deleteCityById(cityId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CitiesWithPagerDto> getCities(CitiesRequest citiesRequest) {
        validateCitiesRequest(citiesRequest);
        long totalPages = cityService.getCitiesCount() / citiesRequest.getPageSize();
        return ResponseEntity.ok(
                new CitiesWithPagerDto()
                        .cities(cityService.getCitiesWithParams(citiesRequest))
                        .pager(
                                new Pager()
                                        .totalPages(totalPages)
                                        .pageNum(citiesRequest.getPage())
                        )
        );
    }

    @Override
    public ResponseEntity<City> getCityById(Long cityId) {
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }

    @Override
    public ResponseEntity<Boolean> updateCityById(Long cityId, City city) {
        cityService.updateCityById(cityId, city);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    private void validateCitiesRequest(CitiesRequest citiesRequest) {
        for (var filterStrategy : citiesRequest.getFilterStrategies()) {
            if (filterStrategy.getFilterType() == FilterType.CONTAINS && !containsAllowedFields.contains(filterStrategy.getFilterColumn())) {
                throw new IllegalArgumentException("FilterType: CONTAINS, cant be applied to column: %s".formatted(filterStrategy.getFilterColumn()));
            }
        }
    }

    private final List<CityField> containsAllowedFields = List.of(CityField.NAME);
}
