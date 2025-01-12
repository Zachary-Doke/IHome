package com.ihome.dao;

import com.ihome.pojo.FaceData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceDataDao extends CrudRepository<FaceData, Integer> {
}
