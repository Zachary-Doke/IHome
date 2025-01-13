package com.ihome.controller;

import com.ihome.pojo.AcPrediction;
import com.ihome.pojo.ResponseMessage;
import com.ihome.pojo.User;
import com.ihome.service.AcPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acPrediction")
public class AcPredictionController {

    @Autowired
    private AcPredictionService acPredictionService;

    // 添加记录
    @PostMapping("/addRecord")
    public ResponseMessage<AcPrediction> addRecord(@RequestBody AcPrediction acPrediction) {
        AcPrediction result=acPredictionService.addRecord(acPrediction);
        return ResponseMessage.success(result);
    }
}
