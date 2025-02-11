package com.ihome.controller;

import com.ihome.pojo.ResponseMessage;
import com.ihome.pojo.User;
import com.ihome.service.ArcFaceService;
import com.ihome.util.ExtractFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/camera")
public class CameraController {

    @Autowired
    private ArcFaceService arcFaceService;

    //人脸比对
    @PostMapping("/faceVideoCompare")
    public ResponseMessage<Boolean> faceVideoCompare(@RequestParam("video") MultipartFile video, @RequestParam Integer userId) {

        //获取视频流，转为帧
        List<String> imagePathList =new ExtractFrame().extractFrame(video);


        //每帧人脸识别
        float confidence = 0;
        Boolean flag=false;
        for (String imagePath : imagePathList){
            confidence=arcFaceService.faceRecognition(imagePath,userId);
            if (confidence>0.8){
                flag=true;
                break;
            }
        }

        return ResponseMessage.success(flag);
    }

    @PostMapping("/faceImageCompare")
    public ResponseMessage<Boolean> faceImageCompare(@RequestParam("image") MultipartFile image, @RequestParam Integer userId) {

        //获取视频流，转为帧
        String imagePath =new ExtractFrame().extractImage(image);


        //每帧人脸识别
        float confidence = 0;
        Boolean flag=false;
        confidence=arcFaceService.faceRecognition(imagePath,userId);
        if (confidence>0.8){
            flag=true;
        }
        return ResponseMessage.success(flag);
    }

    @PostMapping("/addFace")
    public ResponseMessage<String> addFace(@RequestParam("video") MultipartFile video,@RequestParam Integer userId) {

        //获取视频流，转为帧
        List<String> imagePathList = new ExtractFrame().extractFrame(video);

        //每帧人脸识别
        arcFaceService.addFace(imagePathList,userId);
        return ResponseMessage.success("成功录入人脸");
    }

}
