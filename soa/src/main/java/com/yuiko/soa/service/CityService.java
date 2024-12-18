package com.yuiko.soa.service;

import java.util.List;
import java.util.stream.Collectors;

import com.yuiko.soa.model.api.CitiesRequest;
import com.yuiko.soa.model.api.City;
import com.yuiko.soa.model.api.CityRequest;
import com.yuiko.soa.model.db.CityEntity;
import com.yuiko.soa.model.db.HumanEntity;
import com.yuiko.soa.model.exceptions.NotFoundException;
import com.yuiko.soa.repository.CityRepository;
import com.yuiko.soa.repository.CityRepositoryService;
import com.yuiko.soa.repository.HumanRepository;
import com.yuiko.soa.utils.Converters;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final HumanRepository humanRepository;
    private final CityRepositoryService cityRepositoryService;

    public CityService(CityRepository cityRepository, HumanRepository humanRepository,
                       CityRepositoryService cityRepositoryService) {
        this.cityRepository = cityRepository;
        this.humanRepository = humanRepository;
        this.cityRepositoryService = cityRepositoryService;
    }

    public City getCityById(Long cityId) {
        CityEntity cityEntity = cityRepository.getCityEntityById(cityId);
        if (cityEntity == null) {
            throw new NotFoundException("City with such id not found");
        }
        City city = Converters.cityEntityToDto(cityEntity);
        setInhabitants(city);
        return city;
    }

    public void deleteCityById(Long cityId) {
        cityRepositoryService.deleteCityById(cityId);
    }

    public boolean updateCityById(Long cityId, CityRequest city) {
        return cityRepositoryService.updateCityEntityById(cityId, Converters.cityDtoToEntity(city, cityId));
    }

    public List<City> getCitiesWithParams(CitiesRequest citiesRequest) {
        List<City> cities = cityRepositoryService.getCitiesWithParams(citiesRequest).stream()
                .map(Converters::cityEntityToDto)
                .collect(Collectors.toUnmodifiableList());
        cities.forEach(this::setInhabitants);
        return cities;
    }

    public City getCityByMaxEstablishmentDate() {
        return Converters.cityEntityToDto(cityRepositoryService.getCityByMaxEstablishmentDate());
    }

    public City getCityByMinId() {
        return Converters.cityEntityToDto(cityRepositoryService.getCityByMinId());
    }

    public long getCitiesCount() {
        return cityRepository.count();
    }

    private void setInhabitants(City city) {
        List<HumanEntity> humanEntitiesByCityId = humanRepository.getHumanEntitiesByCity(city.getId());
        if (CollectionUtils.isNotEmpty(humanEntitiesByCityId)) {
            city.inhabitant(humanEntitiesByCityId.stream().map(Converters::humanEntityToDto)
                    .collect(Collectors.toUnmodifiableList()));
            List<HumanEntity> governors = humanEntitiesByCityId.stream().filter(HumanEntity::is_governor)
                    .collect(Collectors.toUnmodifiableList());
            if (governors.size() == 1) {
                city.governor(Converters.humanEntityToDto(governors.get(0)));
            } else {
                // TODO:: add logs
            }
        }
    }
}
