package com.ihome.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Table(name = "environment_data")
@Entity
@Data
public class EnvironmentData implements Serializable {

    /**
    * 数据ID
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
    * 设备ID
    */
    private Integer deviceId;
    /**
    * 环境温度
    */
    private Double temperature;
    /**
    * 环境湿度
    */
    private Double humidity;
    /**
    * 光照强度
    */
    private Double lightLevel;
    /**
    * 数据采集时间
    */
    private Date createTime;

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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(Double lightLevlel) {
        this.lightLevel = lightLevlel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date create) {
        this.createTime = create;
    }
}
