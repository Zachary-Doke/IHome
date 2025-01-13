package com.ihome.config;

import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;

public class ArcFace {

    public static final void arcFace(){
        //激活码，从官网获取
        String appId = "H8bcw4bf5PQbZJuQQA6Lmqf9ZACHXdM1PwDVjnwgyq31";
        String sdkKey = "A5MFL5Z28vJxkSBVqGnNfnFr38udVXzaSS8F5tP5Rz3V";
        String activeKey = "86L1-11V3-A131-T5CG";

        System.err.println("注意，如果返回的errorCode不为0，可查看com.arcsoft.face.enums.ErrorInfo类获取相应的错误信息");

        //人脸识别引擎库存放路径
        FaceEngine faceEngine = new FaceEngine("E:\\JavaProject\\IHome\\src\\main\\resources\\libs\\WIN64");
        //激活引擎
        int errorCode = faceEngine.activeOnline(appId, sdkKey, activeKey);
        System.out.println("引擎激活errorCode:" + errorCode);

        ActiveDeviceInfo activeDeviceInfo = new ActiveDeviceInfo();
        //采集设备信息（可离线）
        errorCode = faceEngine.getActiveDeviceInfo(activeDeviceInfo);
        System.out.println("采集设备信息errorCode:" + errorCode);
        System.out.println("设备信息:" + activeDeviceInfo.getDeviceInfo());

//        faceEngine.activeOffline("d:\\ArcFacePro64.dat.offline");

        ActiveFileInfo activeFileInfo = new ActiveFileInfo();
        errorCode = faceEngine.getActiveFileInfo(activeFileInfo);
        System.out.println("获取激活文件errorCode:" + errorCode);
        System.out.println("激活文件信息:" + activeFileInfo.toString());

        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
        engineConfiguration.setDetectFaceMaxNum(10);
        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        functionConfiguration.setSupportImageQuality(true);
        functionConfiguration.setSupportMaskDetect(true);
        functionConfiguration.setSupportUpdateFaceData(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);

        //初始化引擎
        errorCode = faceEngine.init(engineConfiguration);
        System.out.println("初始化引擎errorCode:" + errorCode);
        VersionInfo version = faceEngine.getVersion();
        System.out.println(version);
    }
}
