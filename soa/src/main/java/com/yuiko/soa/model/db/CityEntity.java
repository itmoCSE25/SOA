package com.yuiko.soa.model.db;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "public", name = "city")
public record CityEntity(
        @Id
        Long id,

        String name,

        OffsetDateTime creationDate,

        Float area,

        Long population,

        Double metersAboveSeaLevel,

        LocalDateTime establishmentDate,

        Boolean capital,

        GovernmentEnum government,

        CoordinatesEntity coordinates
) {
}
