package com.yuiko.soa.api;

import java.util.List;

import com.yuiko.soa.model.api.CitiesRequest;
import com.yuiko.soa.model.api.CitiesWithPagerDto;
import com.yuiko.soa.model.api.City;
import com.yuiko.soa.model.api.CityField;
import com.yuiko.soa.model.api.CityRequest;
import com.yuiko.soa.model.api.FilterStrategy;
import com.yuiko.soa.model.api.FilterType;
import com.yuiko.soa.model.api.Pager;
import com.yuiko.soa.service.CityService;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CityController {

    private final CityService cityService;

    public CityController(
            CityService cityService
    ) {
        this.cityService = cityService;
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/cities/{cityId}"
    )
    public ResponseEntity<Void> deleteCityById(
            @PathVariable("cityId") Long cityId
    ) {
        cityService.deleteCityById(cityId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/cities",
            produces = { "application/xml" },
            consumes = { "application/xml" }
    )
    public ResponseEntity<CitiesWithPagerDto> getCities(
            @Valid @RequestBody CitiesRequest citiesRequest
    ) {
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

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/cities/{cityId}",
            produces = { "application/xml" }
    )
    public ResponseEntity<City> getCityById(
            @PathVariable("cityId") Long cityId
    ) {
        return ResponseEntity.ok(
                cityService.getCityById(cityId)
        );
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/cities/{cityId}",
            produces = { "application/xml" },
            consumes = { "application/xml" }
    )
    public ResponseEntity<Boolean> updateCityById(
            @PathVariable("cityId") Long cityId,
            @Valid @RequestBody CityRequest cityRequest
    ) {
        return ResponseEntity.ok(cityService.updateCityById(cityId, cityRequest));
    }

    private void validateCitiesRequest(CitiesRequest citiesRequest) {
        for (FilterStrategy filterStrategy : citiesRequest.getFilterStrategies()) {
            if (filterStrategy.getFilterType() == FilterType.CONTAINS && !containsAllowedFields.contains(filterStrategy.getFilterColumn())) {
                throw new IllegalArgumentException("FilterType: CONTAINS, cant be applied to column:" + filterStrategy.getFilterColumn());
            }
        }
    }

    private final List<CityField> containsAllowedFields = List.of(CityField.NAME);
}
