package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Table(name = "face_recognition_logs")
@Entity
@Data
public class FaceRecognitionLog implements Serializable {

    /**
    * 记录ID
    */
    @Id
    private Integer id;
    /**
    * 设备ID
    */
    private Integer deviceId;
    /**
    * 识别到的人员id
    */
    private Integer recognizedId;
    /**
    * 人脸识别置信度
    */
    private Double confidence;
    /**
    * 是否成功开门
    */
    private String accessStatu;
    /**
    * 采集图片存储路径
    */
    private String capturedImagePath;
    /**
    * 识别时间
    */
    private Date create;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getRecognizedId() {
        return recognizedId;
    }

    public void setRecognizedId(Integer recognizedId) {
        this.recognizedId = recognizedId;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public String getAccessStatu() {
        return accessStatu;
    }

    public void setAccessStatu(String accessStatu) {
        this.accessStatu = accessStatu;
    }

    public String getCapturedImagePath() {
        return capturedImagePath;
    }

    public void setCapturedImagePath(String capturedImagePath) {
        this.capturedImagePath = capturedImagePath;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
