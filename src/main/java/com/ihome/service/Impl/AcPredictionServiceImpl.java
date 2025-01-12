package com.ihome.service.Impl;

import com.ihome.dao.AcPredictionDao;
import com.ihome.pojo.AcPrediction;
import com.ihome.service.AcPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcPredictionServiceImpl implements AcPredictionService {
    @Autowired
    private AcPredictionDao acPredictionDao;

    @Override
    public AcPrediction addRecord(AcPrediction acPrediction) {
        return acPredictionDao.save(acPrediction);
    }
}
