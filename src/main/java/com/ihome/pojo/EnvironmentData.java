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

}
