package com.yuiko.soa.repository;

import com.yuiko.soa.model.db.CityEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Long> {

    CityEntity getCityEntityById(Long id);

    @Query("delete from city\n" +
            "        where city.id = :id\n" +
            "        returning true")
    Boolean deleteCityEntityById(Long id);
}
