package com.yuiko.soa.model.db;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "public", name = "human")
public final class HumanEntity {
    @Id
    private final Long id;
    @Column
    private final Float height;
    @Column
    private final OffsetDateTime birthday;
    @Column
    private final Boolean is_governor;
    @Column
    private final Long city;

    public HumanEntity(
            Long id,
            Float height,
            OffsetDateTime birthday,
            Boolean is_governor,
            Long city
    ) {
        this.id = id;
        this.height = height;
        this.birthday = birthday;
        this.is_governor = is_governor;
        this.city = city;
    }

    @Id
    public Long id() {
        return id;
    }

    @Column
    public Float height() {
        return height;
    }

    @Column
    public OffsetDateTime birthday() {
        return birthday;
    }

    @Column
    public Boolean is_governor() {
        return is_governor;
    }

    @Column
    public Long city() {
        return city;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (HumanEntity) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.height, that.height) &&
                Objects.equals(this.birthday, that.birthday) &&
                Objects.equals(this.is_governor, that.is_governor) &&
                Objects.equals(this.city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, birthday, is_governor, city);
    }

    @Override
    public String toString() {
        return "HumanEntity[" +
                "id=" + id + ", " +
                "height=" + height + ", " +
                "birthday=" + birthday + ", " +
                "is_governor=" + is_governor + ", " +
                "city=" + city + ']';
    }

}
