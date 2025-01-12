package com.ihome.service;

import com.ihome.pojo.FaceData;

import java.util.List;

public interface FaceDataService {
    /**
     * 添加人脸数据
     * @param faceData
     * @return
     */
    FaceData addFaceData(FaceData faceData);

    /**
     * 根据id删除人脸数据
     * @param dataId
     */
    void deleteFaceDataById(Integer dataId);

    /**
     * 更新人脸数据
     * @param faceData
     * @return
     */
    FaceData updateFaceData(FaceData faceData);

    /**
     * 根据id查询人脸数据
     * @param dataId
     * @return
     */
    FaceData getFaceDataById(Integer dataId);

    /**
     * 查询人脸数据列表
     * @return
     */
    List<FaceData> getFaceDataList();
}
