package com.ihome.dao;

import com.ihome.pojo.LightPrediction;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightPredictionDao extends CrudRepository<LightPrediction,Integer> {
}
