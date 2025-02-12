package com.ihome.service;

import com.ihome.pojo.LightPrediction;
import com.ihome.pojo.LightState;

import java.net.MalformedURLException;

public interface LightPredictionService {
    /**
     * 添加一条记录
     * @param lightPrediction
     * @return
     */
    LightPrediction addRecord(LightPrediction lightPrediction);

    String predict(LightState lightState) throws Exception;
}
