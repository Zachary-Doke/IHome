package com.ihome.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Table(name = "light_predictions")
@Entity
@Data
public class LightPrediction implements Serializable {

    /**
    * 记录ID
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 设备ID
    */
    private Integer deviceId;
    /**
    * 预测的行为
    */
    private String predictedAction;
    /**
    * 操作参数
    */
    private Double parameters;
    /**
    * 预测置信度
    */
    private Double confidence;
    /**
    * 预测生成时间
    */
    private Date create;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getPredictedAction() {
        return predictedAction;
    }

    public void setPredictedAction(String predictedAction) {
        this.predictedAction = predictedAction;
    }

    public Double getParameters() {
        return parameters;
    }

    public void setParameters(Double parameters) {
        this.parameters = parameters;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
