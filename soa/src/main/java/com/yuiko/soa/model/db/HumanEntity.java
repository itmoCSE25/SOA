package com.yuiko.soa.model.db;

import java.time.OffsetDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "public", name = "human")
public record HumanEntity(
        @Id
        Long id,
        @Column
        Float height,
        @Column
        OffsetDateTime birthday,
        @Column
        Boolean is_governor,
        @Column
        Long city
) {
}
