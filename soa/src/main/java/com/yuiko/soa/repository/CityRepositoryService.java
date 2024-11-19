package com.yuiko.soa.repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import com.yuiko.soa.model.CitiesRequest;
import com.yuiko.soa.model.FilterType;
import com.yuiko.soa.model.SortingStrategy;
import com.yuiko.soa.model.db.CityEntity;
import com.yuiko.soa.model.db.CoordinatesEntity;
import com.yuiko.soa.model.db.GovernmentEnum;
import com.yuiko.soa.model.db.SqlOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CityRepositoryService {

    ZoneOffset defaultZoneOffset = ZoneOffset.UTC;

    private final RowMapper<CityEntity> CITY_ENTITY_MAPPER = (rs, idx) -> new CityEntity(
            rs.getLong("id"),
            rs.getString("name"),
            Optional.ofNullable(rs.getTimestamp("creation_date"))
                    .map(date -> date.toLocalDateTime().atOffset(defaultZoneOffset))
                    .orElse(null),
            rs.getFloat("area"),
            rs.getLong("population"),
            rs.getDouble("meters_above_sea_level"),
            Optional.ofNullable(rs.getTimestamp("establishment_date"))
                    .map(Timestamp::toLocalDateTime)
                    .orElse(null),
            rs.getBoolean("capital"),
            Optional.ofNullable(rs.getString("government")).map(GovernmentEnum::valueOf).orElse(null),
            new CoordinatesEntity(rs.getLong("coordinates_id"), rs.getFloat("x"), rs.getInt("y"))
    );

    private final String DEFAULT_QUERY = """
            SELECT "public"."city"."id"                     AS "id",
                   "public"."city"."name"                    AS "name",
                   "public"."city"."area"                   AS "area",
                   "public"."city"."capital"                AS "capital",
                   "public"."city"."government"             AS "government",
                   "public"."city"."population"             AS "population",
                   "public"."city"."creation_date"          AS "creation_date",
                   "public"."city"."establishment_date"     AS "establishment_date",
                   "public"."city"."meters_above_sea_level" AS "meters_above_sea_level",
                   "coordinates"."x"                        AS "x",
                   "coordinates"."y"                        AS "y",
                   "coordinates"."id"                       AS "coordinates_id"
            FROM "public"."city"
                     LEFT OUTER JOIN "public"."coordinate" "coordinates" ON "coordinates"."city" = "public"."city"."id"
            """;

    private final String DEFAULT_QUERY_WITH_FILTERS = DEFAULT_QUERY + "%s\n %s\n offset :offset\n limit :limit";

    private final NamedParameterJdbcTemplate namedParameterJdbcOperations;

    public CityRepositoryService(NamedParameterJdbcTemplate namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    public List<CityEntity> getCitiesWithParams(CitiesRequest citiesRequest) {
        String sql = DEFAULT_QUERY_WITH_FILTERS;
        StringBuilder where = new StringBuilder("where 1=1\n");
        String order = "";
        for (var filterStrategy : citiesRequest.getFilterStrategies()) {
            if (filterStrategy.getFilterType() == FilterType.CONTAINS) {
                where.append("AND city.%s ".formatted(filterStrategy.getFilterColumn().getValue()))
                        .append(" like '%")
                        .append(filterStrategy.getFilterValue())
                        .append("%'\n");
                continue;
            }
            where.append("AND city.%s %s '%s'\n".formatted(
                    filterStrategy.getFilterColumn().getValue(),
                    SqlOperations.fromValue(filterStrategy.getFilterType().getValue()).getOperation(),
                    filterStrategy.getFilterValue())
            );
        }
        SortingStrategy sortingStrategy = citiesRequest.getSortingStrategies();
        if (sortingStrategy != null) {
            order = "order by %s %s".formatted(sortingStrategy.getSortingColumn(), sortingStrategy.getSortingType());
        } else {
            order = "order by id desc";
        }
        return namedParameterJdbcOperations.query(
                sql.formatted(where, order),
                new MapSqlParameterSource()
                        .addValue("offset", (citiesRequest.getPage() - 1) * citiesRequest.getPageSize())
                        .addValue("limit", citiesRequest.getPageSize()),
                CITY_ENTITY_MAPPER
        );
    }

    public CityEntity updateCityEntityById(Long cityId, CityEntity cityEntity) {
        // TODO add update coordinates
        String sql = """
                insert into public.city (id, name, creation_date, area, population, meters_above_sea_level, establishment_date, capital, government)
                values (:cityId, :name, :creationDate, :area, :population, :metersAboveSeaLevel, :establishmentDate, :capital, :government)
                on conflict do update set
                    name = excluded.name,
                    creation_date = excluded.creation_date,
                    area = excluded.area,
                    population = excluded.population,
                    meters_above_sea_level = excluded.meters_above_sea_level,
                    establishment_date = excluded.establishment_date,
                    capital = excluded.capital,
                    government = excluded.government;
                """ + DEFAULT_QUERY + " where city.id = :cityId";
        List<CityEntity> cityEntities = namedParameterJdbcOperations.query(
                sql,
                new MapSqlParameterSource("cityId", cityId)
                        .addValue("name", cityEntity.name())
                        .addValue("creationDate", cityEntity.creationDate())
                        .addValue("area", cityEntity.area())
                        .addValue("population", cityEntity.population())
                        .addValue("metersAboveSeaLevel", cityEntity.metersAboveSeaLevel())
                        .addValue("establishmentDate", cityEntity.establishmentDate())
                        .addValue("capital", cityEntity.capital())
                        .addValue("government", cityEntity.government()),
                CITY_ENTITY_MAPPER
        );
        if (cityEntities.isEmpty()) {
            return null;
        }
        return cityEntities.get(0);
    }

    public CityEntity getCityByMaxEstablishmentDate() {
        String sql = DEFAULT_QUERY + " order by establishment_date desc";
        return namedParameterJdbcOperations.query(
                sql,
                new MapSqlParameterSource(),
                CITY_ENTITY_MAPPER
        ).stream().findFirst().orElse(null);
    }

    public CityEntity getCityByMinId() {
        String sql = DEFAULT_QUERY + " order by id";
        return namedParameterJdbcOperations.query(
                sql,
                new MapSqlParameterSource(),
                CITY_ENTITY_MAPPER
        ).stream().findFirst().orElse(null);
    }
}
