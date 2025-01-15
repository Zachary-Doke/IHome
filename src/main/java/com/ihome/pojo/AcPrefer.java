package com.ihome.pojo;



import java.io.Serializable;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "ac_prefer")
@Entity
@Data
public class AcPrefer implements Serializable {

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
    * 空调参数
    */
    private String parameters;
    /**
    * 起始环境温度
    */
    private String temperature;
    /**
    * 启动时间
    */
    private Date startTime;
    /**
    * 结束时间
    */
    private Date endTime;

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

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
