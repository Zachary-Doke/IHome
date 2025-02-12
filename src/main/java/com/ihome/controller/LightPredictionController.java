package com.ihome.controller;

import com.ihome.pojo.LightPrediction;
import com.ihome.pojo.LightState;
import com.ihome.pojo.ResponseMessage;
import com.ihome.service.LightPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lightPrediction")
public class LightPredictionController {
    @Autowired
    private LightPredictionService lightPredictionService;

    // 添加记录
    @PostMapping("/addRecord")
    public ResponseMessage<LightPrediction> addRecord(@RequestBody LightPrediction lightPrediction) {
        LightPrediction result=lightPredictionService.addRecord(lightPrediction);
        return ResponseMessage.success(result);
    }

    @PostMapping("/prediction")
    public ResponseMessage<String> prediction(@RequestBody LightState LightState) throws Exception {
        String result=lightPredictionService.predict(LightState);
        return ResponseMessage.success(result);
    }
}
