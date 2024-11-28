package com.yuiko.soa.model.db;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "public", name = "city")
public final class CityEntity {
    @Id
    private final Long id;
    private final String name;
    private final OffsetDateTime creationDate;
    private final Float area;
    private final Long population;
    private final Double metersAboveSeaLevel;
    private final LocalDateTime establishmentDate;
    private final Boolean capital;
    private final GovernmentEnum government;
    private final CoordinatesEntity coordinates;

    public CityEntity(
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
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.establishmentDate = establishmentDate;
        this.capital = capital;
        this.government = government;
        this.coordinates = coordinates;
    }

    @Id
    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public OffsetDateTime creationDate() {
        return creationDate;
    }

    public Float area() {
        return area;
    }

    public Long population() {
        return population;
    }

    public Double metersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public LocalDateTime establishmentDate() {
        return establishmentDate;
    }

    public Boolean capital() {
        return capital;
    }

    public GovernmentEnum government() {
        return government;
    }

    public CoordinatesEntity coordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (CityEntity) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.creationDate, that.creationDate) &&
                Objects.equals(this.area, that.area) &&
                Objects.equals(this.population, that.population) &&
                Objects.equals(this.metersAboveSeaLevel, that.metersAboveSeaLevel) &&
                Objects.equals(this.establishmentDate, that.establishmentDate) &&
                Objects.equals(this.capital, that.capital) &&
                Objects.equals(this.government, that.government) &&
                Objects.equals(this.coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, area, population, metersAboveSeaLevel, establishmentDate, capital
                , government, coordinates);
    }

    @Override
    public String toString() {
        return "CityEntity[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "creationDate=" + creationDate + ", " +
                "area=" + area + ", " +
                "population=" + population + ", " +
                "metersAboveSeaLevel=" + metersAboveSeaLevel + ", " +
                "establishmentDate=" + establishmentDate + ", " +
                "capital=" + capital + ", " +
                "government=" + government + ", " +
                "coordinates=" + coordinates + ']';
    }

}
