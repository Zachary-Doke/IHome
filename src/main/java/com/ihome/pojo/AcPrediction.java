package com.ihome.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Table(name = "ac_predictions")
@Entity
@Data
public class AcPrediction implements Serializable {

    /**
    * 记录ID
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
    * 空调设备ID
    */
    private Integer deviceId;
    /**
    * 调整操作
    */
    private String adjustment;
    /**
    * 参数
    */
    private Double parameters;
    /**
    * 调整时间
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

    public String getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(String adjustment) {
        this.adjustment = adjustment;
    }

    public Double getParameters() {
        return parameters;
    }

    public void setParameters(Double parameters) {
        this.parameters = parameters;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
