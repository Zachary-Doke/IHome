package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Table(name = "light_prefer")
@Entity
@Data
public class LightPrefer implements Serializable {

    /**
    * 记录ID
    */
    @Id
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
    * 灯光亮度
    */
    private String brightness;
    /**
    * 灯光颜色
    */
    private String color;
    /**
    * 起始时间
    */
    private Date startTime;
    /**
    * 结束时间
    */
    private Date endTime;
    /**
    * 记录生成时间
    */
    private Date create;
}
