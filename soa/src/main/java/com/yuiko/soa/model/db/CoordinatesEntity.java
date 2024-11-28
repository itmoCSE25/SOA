package com.yuiko.soa.model.db;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "public", name = "coordinate")
public final class CoordinatesEntity {
    @Id
    private final Long id;
    private final Float x;
    private final Integer y;

    public CoordinatesEntity(
            Long id,
            Float x,
            Integer y
    ) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Id
    public Long id() {
        return id;
    }

    public Float x() {
        return x;
    }

    public Integer y() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (CoordinatesEntity) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.x, that.x) &&
                Objects.equals(this.y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, x, y);
    }

    @Override
    public String toString() {
        return "CoordinatesEntity[" +
                "id=" + id + ", " +
                "x=" + x + ", " +
                "y=" + y + ']';
    }

}
