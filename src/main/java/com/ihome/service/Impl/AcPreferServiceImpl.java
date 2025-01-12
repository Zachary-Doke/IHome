package com.ihome.service.Impl;

import com.ihome.dao.AcPreferDao;
import com.ihome.pojo.AcPrefer;
import com.ihome.pojo.LightPrefer;
import com.ihome.service.AcPreferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcPreferServiceImpl implements AcPreferService {
    @Autowired
    private AcPreferDao acPreferDao;

    @Override
    public AcPrefer addRecord(AcPrefer acPrefer) {
        return acPreferDao.save(acPrefer);
    }

    @Override
    public void deleteRecord(Integer recordId) {
        acPreferDao.deleteById(recordId);
    }

    @Override
    public AcPrefer updateRecord(AcPrefer acPrefer) {
        return acPreferDao.save(acPrefer);
    }

    @Override
    public List<AcPrefer> getRecordList() {
        Iterable<AcPrefer> iterator = acPreferDao.findAll();
        List<AcPrefer> recordList=new ArrayList<>();
        for(AcPrefer acPrefer:iterator){
            recordList.add(acPrefer);
        }
        return recordList;
    }
}
