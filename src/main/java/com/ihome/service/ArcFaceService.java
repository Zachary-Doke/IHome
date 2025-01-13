package com.ihome.service;

//import com.arcsoft.face.FaceEngine;
//import com.arcsoft.face.FaceFeature;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArcFaceService {

//    @Autowired
//    private FaceEngine faceEngine;
//
//    // 提取人脸特征
//    public FaceFeature extractFaceFeature(byte[] imageBytes) {
//        ImageData imageData = new ImageData(imageBytes, imageWidth, imageHeight, ImageFormat.CP_PAF_BGR24);
//
//        // 检测人脸
//        FaceInfo[] faceInfos = faceEngine.detectFaces(imageData);
//        if (faceInfos == null || faceInfos.length == 0) {
//            throw new RuntimeException("No face detected");
//        }
//
//        // 提取人脸特征
//        FaceFeature faceFeature = faceEngine.extractFaceFeature(imageData, faceInfos[0]);
//        return faceFeature;
//    }
//
//    // 比对两张人脸特征
//    public float compareFaceFeatures(FaceFeature feature1, FaceFeature feature2) {
//        // 比对两张人脸特征，返回相似度
//        FaceComparison result = faceEngine.compareFaceFeature(feature1, feature2);
//        return result.getScore();
//    }

}
