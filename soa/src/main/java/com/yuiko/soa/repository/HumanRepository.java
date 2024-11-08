package com.yuiko.soa.repository;

import java.util.List;

import com.yuiko.soa.model.db.HumanEntity;
import org.springframework.data.repository.CrudRepository;

public interface HumanRepository extends CrudRepository<HumanEntity, Long> {

    List<HumanEntity> getHumanEntitiesByCity(Long city);
}
