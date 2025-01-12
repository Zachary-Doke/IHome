package com.ihome.dao;

import com.ihome.pojo.EnvironmentData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentDataDao extends CrudRepository<EnvironmentData, Integer> {
}
