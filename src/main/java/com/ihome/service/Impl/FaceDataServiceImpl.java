package com.ihome.service.Impl;

import com.ihome.dao.FaceDataDao;
import com.ihome.pojo.FaceData;
import com.ihome.service.ArcFaceService;
import com.ihome.service.FaceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceDataServiceImpl implements FaceDataService {

    @Autowired
    private FaceDataDao faceDataDao;
    @Autowired
    private ArcFaceService arcFaceService;

    @Override
    public FaceData addFaceData(FaceData faceData) {
        return faceDataDao.save(faceData);
    }

    @Override
    public void deleteFaceDataById(Integer dataId) {
        faceDataDao.deleteById(dataId);
    }

    @Override
    public FaceData updateFaceData(FaceData faceData) {
        return faceDataDao.save(faceData);
    }

    @Override
    public FaceData getFaceDataById(Integer dataId) {
        return faceDataDao.findById(dataId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在,参数异常");
        });
    }

    @Override
    public List<FaceData> getFaceDataList() {
        Iterable<FaceData> iterator = faceDataDao.findAll();
        List<FaceData> dataList=new ArrayList<>();
        for(FaceData data:iterator){
            dataList.add(data);
        }
        return dataList;
    }

    @Override
    public List<FaceData> getFaceDataListByUserId(Integer userId) {
        Iterable<FaceData> iterator = faceDataDao.findAll();
        List<FaceData> dataList=new ArrayList<>();
        for(FaceData data:iterator){
            if(data.getUserId() == null) continue;
            if(data.getUserId().equals(userId)) dataList.add(data);
        }
        return dataList;
    }
}
