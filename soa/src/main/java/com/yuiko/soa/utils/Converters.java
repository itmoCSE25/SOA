package com.yuiko.soa.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.yuiko.soa.model.api.*;
import com.yuiko.soa.model.db.CityEntity;
import com.yuiko.soa.model.db.CoordinatesEntity;
import com.yuiko.soa.model.db.GovernmentEnum;
import com.yuiko.soa.model.db.HumanEntity;
import jakarta.annotation.Nullable;

public class Converters {

    public static City cityEntityToDto(CityEntity cityEntity) {
        if (cityEntity == null) {
            return null;
        }
        return new City()
                .id(cityEntity.id())
                .name(cityEntity.name())
                .coordinates(coordinatesEntityToDto(cityEntity.coordinates()))
                .creationDate(cityEntity.creationDate().toString())
                .area(cityEntity.area())
                .population(cityEntity.population())
                .metersAboveSeaLevel(cityEntity.metersAboveSeaLevel())
                .establishmentDate(cityEntity.establishmentDate().toString())
                .capital(cityEntity.capital());
    }

    @Nullable
    public static Coordinates coordinatesEntityToDto(CoordinatesEntity coordinates) {
        if (coordinates == null) {
            return null;
        }
        return new Coordinates()
                .x(coordinates.x())
                .y(coordinates.y());
    }

    @Nullable
    public static Human humanEntityToDto(HumanEntity humanEntity) {
        if (humanEntity == null) {
            return null;
        }
        return new Human()
                .birthday(humanEntity.birthday())
                .height(humanEntity.height());
    }

    @Nullable
    public static CityEntity cityDtoToEntity(City city, Long cityId) {
        if (city == null) {
            return null;
        }
        if (cityId == null && city.getId() == null) {
            throw new IllegalArgumentException("Id for City is not presented");
        }
        return new CityEntity(
                Optional.ofNullable(cityId).orElse(city.getId()),
                city.getName(),
                creationDateTimeFromDto(city.getCreationDate()),
                city.getArea(),
                city.getPopulation(),
                city.getMetersAboveSeaLevel(),
                establishmentDateFromDto(city.getEstablishmentDate()),
                city.getCapital(),
                GovernmentEnum.valueOf(city.getGovernment().name()),
                Converters.coordinatesDtoToEntity(city.getCoordinates())
        );
    }

    @Nullable
    public static CityEntity cityDtoToEntity(CityRequest city, Long cityId) {
        if (city == null) {
            return null;
        }
        return new CityEntity(
                cityId,
                city.getName(),
                null,
                city.getArea(),
                city.getPopulation(),
                city.getMetersAboveSeaLevel(),
                establishmentDateFromDto(city.getEstablishmentDate()),
                city.getCapital(),
                GovernmentEnum.valueOf(city.getGovernment().name()),
                Converters.coordinatesDtoToEntity(city.getCoordinates())
        );
    }

    @Nullable
    public static CoordinatesEntity coordinatesDtoToEntity(Coordinates coordinates) {
        if (coordinates == null) {
            return null;
        }
        return new CoordinatesEntity(
                null,
                coordinates.getX(),
                coordinates.getY()
        );
    }

    private static LocalDateTime establishmentDateFromDto(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }

    private static OffsetDateTime creationDateTimeFromDto(String date) {
        return OffsetDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
