package com.ihome.controller;

import com.ihome.pojo.Device;
import com.ihome.pojo.FaceData;
import com.ihome.pojo.ResponseMessage;
import com.ihome.service.FaceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faceData")
public class FaceDataController {
    @Autowired
    private FaceDataService faceDataService;

    //添加人脸数据
    @PostMapping("/addFaceData")
    public ResponseMessage<FaceData> addFaceData(@RequestBody FaceData faceData) {
        FaceData result=faceDataService.addFaceData(faceData);
        return ResponseMessage.success(result);
    }

    //删除人脸数据
    @DeleteMapping("/deleteFaceDataById/{dataId}")
    public ResponseMessage<String> deleteFaceDataById(@PathVariable Integer dataId) {
        faceDataService.deleteFaceDataById(dataId);
        return ResponseMessage.success("已执行删除操作");
    }

    //更新人脸数据
    @PutMapping("/updateFaceData")
    public ResponseMessage<FaceData> updateFaceData(@RequestBody FaceData faceData) {
        FaceData result=faceDataService.updateFaceData(faceData);
        return ResponseMessage.success(result);
    }

    //获取人脸数据
    @GetMapping("/getFaceDataById")
    public ResponseMessage<FaceData> getFaceDataById(@RequestParam Integer dataId) {
        FaceData result=faceDataService.getFaceDataById(dataId);
        return ResponseMessage.success(result);
    }

    //获取人脸数据列表
    @GetMapping("/getFaceDataList")
    public ResponseMessage<List<FaceData>> getFaceDataList() {
        List<FaceData> result=faceDataService.getFaceDataList();
        return ResponseMessage.success(result);
    }
}
