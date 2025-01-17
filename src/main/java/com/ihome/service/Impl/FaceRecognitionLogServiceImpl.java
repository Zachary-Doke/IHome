package com.ihome.service.Impl;

import com.ihome.dao.faceRecognitionLogDao;
import com.ihome.pojo.Device;
import com.ihome.pojo.FaceRecognitionLog;
import com.ihome.service.FaceRecognitionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceRecognitionLogServiceImpl implements FaceRecognitionLogService {
    @Autowired
    private com.ihome.dao.faceRecognitionLogDao faceRecognitionLogDao;

    @Override
    public FaceRecognitionLog addRecord(FaceRecognitionLog faceRecognitionLog) {
        return faceRecognitionLogDao.save(faceRecognitionLog);
    }

    @Override
    public void deleteDeviceById(Integer recordId) {
        faceRecognitionLogDao.deleteById(recordId);
    }

    @Override
    public List<FaceRecognitionLog> getRecordList(Integer deviceId) {
        Iterable<FaceRecognitionLog> iterator = faceRecognitionLogDao.findAllByDeviceId(deviceId);
        List<FaceRecognitionLog> faceRecognitionLogList=new ArrayList<>();
        for(FaceRecognitionLog faceRecognitionLog:iterator){
            faceRecognitionLogList.add(faceRecognitionLog);
        }
        return faceRecognitionLogList;
    }
}
