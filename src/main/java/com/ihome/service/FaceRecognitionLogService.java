package com.ihome.service;

import com.ihome.pojo.FaceRecognitionLog;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface FaceRecognitionLogService {
    /**
     * 添加记录
     * @param faceRecognitionLog
     * @return
     */
    FaceRecognitionLog addRecord(FaceRecognitionLog faceRecognitionLog);

    /**
     * 根据id删除记录
     * @param recordId
     */
    void deleteDeviceById(Integer recordId);

    /**
     * 获取记录列表
     * @return
     */
    List<FaceRecognitionLog> getRecordList(Integer deviceId);
}
