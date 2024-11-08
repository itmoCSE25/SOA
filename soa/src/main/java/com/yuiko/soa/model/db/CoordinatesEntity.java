package com.yuiko.soa.model.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "public", name = "coordinate")
public record CoordinatesEntity(
        @Id
        Long id,
        Float x,
        Integer y
) {
}
