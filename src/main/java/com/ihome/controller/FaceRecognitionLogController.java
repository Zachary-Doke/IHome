package com.ihome.controller;

import com.ihome.pojo.Device;
import com.ihome.pojo.FaceRecognitionLog;
import com.ihome.pojo.ResponseMessage;
import com.ihome.service.FaceRecognitionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faceRecognitionLog")
public class FaceRecognitionLogController {
    @Autowired
    private FaceRecognitionLogService faceRecognitionLogService;

    //添加人脸识别记录
    @PostMapping("/addRecord")
    public ResponseMessage<FaceRecognitionLog> addRecord(@RequestBody FaceRecognitionLog faceRecognitionLog) {
        FaceRecognitionLog result=faceRecognitionLogService.addRecord(faceRecognitionLog);
        return ResponseMessage.success(result);
    }

    //删除人脸识别记录
    @DeleteMapping("/deleteRecord/{recordId}")
    public ResponseMessage<String> deleteRecord(@PathVariable Integer recordId) {
        faceRecognitionLogService.deleteDeviceById(recordId);
        return ResponseMessage.success("已执行删除操作");
    }

    //获取人脸识别记录
    @GetMapping("/getRecordList")
    public ResponseMessage<List<FaceRecognitionLog>> getRecordList() {
        List<FaceRecognitionLog> result=faceRecognitionLogService.getRecordList();
        return ResponseMessage.success(result);
    }

}
