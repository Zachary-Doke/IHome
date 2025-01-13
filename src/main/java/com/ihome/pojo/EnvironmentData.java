package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Double lightLevlel;
    /**
    * 数据采集时间
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

    public Double getLightLevlel() {
        return lightLevlel;
    }

    public void setLightLevlel(Double lightLevlel) {
        this.lightLevlel = lightLevlel;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
