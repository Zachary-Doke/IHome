package com.ihome.service.Impl;

import com.ihome.dao.LightPreferDao;
import com.ihome.pojo.LightPrefer;
import com.ihome.service.LightPreferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LightPreferServiceImpl implements LightPreferService {

    @Autowired
    private LightPreferDao lightPreferDao;

    @Override
    public LightPrefer addRecord(LightPrefer lightPrefer) {
        return lightPreferDao.save(lightPrefer);
    }

    @Override
    public void deleteRecord(Integer recordId) {
        lightPreferDao.deleteById(recordId);
    }

    @Override
    public LightPrefer updateRecord(LightPrefer lightPrefer) {
        return lightPreferDao.save(lightPrefer);
    }

    @Override
    public List<LightPrefer> getRecordList() {
        Iterable<LightPrefer> iterator = lightPreferDao.findAll();
        List<LightPrefer> recordList=new ArrayList<>();
        for(LightPrefer lightPrefer:iterator){
            recordList.add(lightPrefer);
        }
        return recordList;
    }
}
