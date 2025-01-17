package com.ihome.service.Impl;

import com.ihome.dao.EnvironmentDataDao;
import com.ihome.pojo.EnvironmentData;
import com.ihome.pojo.User;
import com.ihome.service.EnvironmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentDataServiceImpl implements EnvironmentDataService {
    @Autowired
    private EnvironmentDataDao environmentDataDao;

    @Override
    public EnvironmentData addData(EnvironmentData data) {
        return environmentDataDao.save(data);
    }

    @Override
    public void deleteData(Integer dataId) {
        environmentDataDao.deleteById(dataId);
    }

    @Override
    public EnvironmentData updateData(EnvironmentData data) {
        return environmentDataDao.save(data);
    }

    @Override
    public List<EnvironmentData> getEnvironmentDataList(Integer deviceId) {
        Iterable<EnvironmentData> iterator = environmentDataDao.findAllBydeviceId(deviceId);
        List<EnvironmentData> environmentList=new ArrayList<>();
        for(EnvironmentData EnvironmentData:iterator){
            environmentList.add(EnvironmentData);
        }
        return environmentList;
    }
}
