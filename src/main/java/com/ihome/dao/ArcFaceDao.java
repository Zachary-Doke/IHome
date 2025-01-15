package com.ihome.dao;

import com.ihome.pojo.FaceData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArcFaceDao extends CrudRepository<FaceData, Integer> {

    Optional<FaceData> findByUserId(Integer userId);
}