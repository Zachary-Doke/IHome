package com.ihome.service;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.enums.ExtractType;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.ihome.dao.ArcFaceDao;
import com.ihome.pojo.FaceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArcFaceService {

    @Autowired
    private ArcFaceDao arcFaceDao;

    public FaceEngine imageEngineInit() {
        FaceEngine faceEngine = new FaceEngine("E:\\JavaProject\\IHome\\src\\main\\resources\\libs\\WIN64");

        // 配置引擎模式为image
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE); // 视频模式

        // 设置检测方向和最大人脸数
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
        engineConfiguration.setDetectFaceMaxNum(10);

        // 功能配置：启用所需的功能
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportFaceDetect(true); // 启用人脸检测
        functionConfiguration.setSupportFaceRecognition(true);//人脸识别
        engineConfiguration.setFunctionConfiguration(functionConfiguration);

        int errorCode = faceEngine.init(engineConfiguration);

        if (errorCode != ErrorInfo.MOK.getValue()) {
            System.out.println("引擎初始化失败，错误码：" + errorCode);
        }
        System.out.println("初始化引擎errorCode:" + errorCode);
        VersionInfo version = faceEngine.getVersion();
        System.out.println(version);
        return faceEngine;
    }


    //人脸识别
    public float faceRecognition(String imagePath,Integer userId){
        FaceEngine faceEngine=imageEngineInit();

        if (faceEngine == null) {
            System.out.println("FaceEngine not initialized.");
            return 0;
        }

        //封装帧为ImageInfo
        File image = new File(imagePath);
        ImageInfo imageInfo = ImageFactory.getRGBData(image);
        int errorCode = 0;

        //人脸检测
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        errorCode = faceEngine.detectFaces(imageInfo,faceInfoList);
        System.out.println("人脸检测errorCode:" + errorCode);
        System.out.println("检测到人脸数:" + faceInfoList.size());

        //特征提取
        FaceFeature faceFeature = new FaceFeature();
        errorCode = faceEngine.extractFaceFeature(imageInfo, faceInfoList.get(0), ExtractType.RECOGNIZE, 0, faceFeature);
        System.out.println("特征提取errorCode:" + errorCode);

        //获取库中人脸特征
        FaceData faceData =arcFaceDao.findByUserId(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在,参数异常");
        });

        //特征比对
        FaceFeature sourceFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(faceData.getFaceFeature());
        FaceSimilar faceSimilar = new FaceSimilar();

        errorCode = faceEngine.compareFaceFeature(faceFeature, sourceFaceFeature, faceSimilar);
        System.out.println("特征比对errorCode:" + errorCode);
        System.out.println("人脸相似度：" + faceSimilar.getScore());

        destroy(faceEngine);
        return faceSimilar.getScore();
    }

    //人脸注册
    public void addFace(List<String> imagePathList,Integer userId) {
        FaceEngine faceEngine=imageEngineInit();
        if (faceEngine == null) {
            System.out.println("FaceEngine not initialized.");
            return ;
        }

        //对每张照片分别提取人脸特征
        List<FaceFeature> featureList = new ArrayList<>();
        for (String imagePath : imagePathList){

            //封装帧为ImageInfo
            File image = new File(imagePath);
            ImageInfo imageInfo = ImageFactory.getRGBData(image);
            int errorCode = 0;

            //人脸检测
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
            errorCode = faceEngine.detectFaces(imageInfo, faceInfoList);
            System.out.println("人脸检测errorCode:" + errorCode);
            System.out.println("检测到人脸数:" + faceInfoList.size());

            //特征提取
            FaceFeature faceFeature = new FaceFeature();
            errorCode = faceEngine.extractFaceFeature(imageInfo, faceInfoList.get(0), ExtractType.RECOGNIZE, 0, faceFeature);
            System.out.println("特征提取errorCode:" + errorCode);
            featureList.add(faceFeature);
        }

        //特征融合
        if (featureList.isEmpty()) {
            throw new IllegalArgumentException("Feature list is empty");
        }

        int featureLength = featureList.get(0).getFeatureData().length;
        float[] mergedFeatures = new float[featureLength];

        // 累加每个特征向量
        for (FaceFeature feature : featureList) {
            byte[] data = feature.getFeatureData();
            for (int i = 0; i < featureLength; i++) {
                mergedFeatures[i] += Byte.toUnsignedInt(data[i]);
            }
        }

        // 求平均值
        for (int i = 0; i < featureLength; i++) {
            mergedFeatures[i] /= featureList.size();
        }

        // 转换为FaceFeature对象
        byte[] finalFeatureData = new byte[featureLength];
        for (int i = 0; i < featureLength; i++) {
            finalFeatureData[i] = (byte) Math.round(mergedFeatures[i]);
        }

        //存储人脸特征到数据库
        FaceData faceData = new FaceData();
        faceData.setUserId(userId);
        faceData.setFaceFeature(finalFeatureData);
        arcFaceDao.save(faceData);

        destroy(faceEngine);
    }



    // 销毁引擎
    public  void destroy(FaceEngine faceEngine) {
        if (faceEngine != null) {
            faceEngine.unInit();
            System.out.println("FaceEngine destroyed.");
        }
    }

}
