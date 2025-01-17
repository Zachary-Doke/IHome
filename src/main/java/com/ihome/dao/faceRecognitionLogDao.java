package com.ihome.dao;

import com.ihome.pojo.FaceRecognitionLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface faceRecognitionLogDao extends CrudRepository<FaceRecognitionLog, Integer> {
    Iterable<FaceRecognitionLog> findAllByDeviceId(Integer deviceId);
}
