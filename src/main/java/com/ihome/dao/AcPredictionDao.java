package com.ihome.dao;

import com.ihome.pojo.AcPrediction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcPredictionDao extends CrudRepository<AcPrediction, Long> {
}
