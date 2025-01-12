package com.ihome.service.Impl;

import com.ihome.dao.LightPredictionDao;
import com.ihome.pojo.LightPrediction;
import com.ihome.service.LightPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightPredictionServiceImpl implements LightPredictionService {
    @Autowired
    private LightPredictionDao lightPredictionDao;

    @Override
    public LightPrediction addRecord(LightPrediction lightPrediction) {
        return lightPredictionDao.save(lightPrediction);
    }
}
