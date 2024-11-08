package com.yuiko.soa.api;

import java.util.List;

import com.yuiko.soa.model.CitiesRequest;
import com.yuiko.soa.model.City;
import com.yuiko.soa.model.CityField;
import com.yuiko.soa.model.FilterStrategy;
import com.yuiko.soa.model.FilterType;
import com.yuiko.soa.model.Government;
import com.yuiko.soa.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController implements ExternalApiDelegate {

    private final CityService cityService;

    public ExternalController(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public ResponseEntity<List<City>> getCitiesWhereGovernmentLessThen(Government type) {
        return ResponseEntity.ok(cityService.getCitiesWithParams(
                new CitiesRequest()
                        .page(1)
                        .pageSize(100)
                        .filterStrategies(List.of(
                                new FilterStrategy()
                                        .filterType(FilterType.LESS)
                                        .filterColumn(CityField.GOVERNMENT)
                                        .filterValue(type.toString())
                        ))
        ));
    }

    @Override
    public ResponseEntity<City> getCityByMaxEstablishmentDate() {
        return ResponseEntity.ok(cityService.getCityByMaxEstablishmentDate());
    }

    @Override
    public ResponseEntity<City> getCityByMinId() {
        return ResponseEntity.ok(cityService.getCityByMinId());
    }
}
