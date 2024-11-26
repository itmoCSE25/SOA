package com.yuiko.soa.api;

import com.yuiko.soa.repository.CityRepositoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalApiController {

    private final CityRepositoryService cityRepositoryService;

    public InternalApiController(CityRepositoryService cityRepositoryService) {
        this.cityRepositoryService = cityRepositoryService;
    }

    @GetMapping("/internal/kill/{cityId}")
    public void killInhabitantsInCityWithId(@PathVariable Long cityId) {
        cityRepositoryService.killAllInhabitants(cityId);
    }

    @GetMapping("/internal/deport/{fromCityId}/{toCityId}")
    public void deportInhabitants(@PathVariable Long fromCityId, @PathVariable Long toCityId) {
        cityRepositoryService.departureInhabitants(fromCityId, toCityId);
    }
}
