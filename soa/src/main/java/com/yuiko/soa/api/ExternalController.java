package com.yuiko.soa.api;

import java.util.List;

import com.yuiko.soa.model.api.*;
import com.yuiko.soa.service.CityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController {

    private final CityService cityService;

    public ExternalController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/external/government",
            produces = { "application/xml" }
    )
    public ResponseEntity<List<City>> getCitiesWhereGovernmentLessThen(
            @NotNull @Valid @RequestParam(value = "type", required = true) Government type
    ) {
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

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/external/max/establishment-date",
            produces = { "application/xml" }
    )
    public ResponseEntity<City> getCityByMaxEstablishmentDate() {
        return ResponseEntity.ok(cityService.getCityByMaxEstablishmentDate());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/external/min/id",
            produces = { "application/xml" }
    )
    public ResponseEntity<City> getCityByMinId() {
        return ResponseEntity.ok(cityService.getCityByMinId());
    }
}
