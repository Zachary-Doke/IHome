package com.ihome.pojo;



import java.io.Serializable;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name = "ac_prefer")
@Entity
@Data
public class AcPrefer implements Serializable {

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

}
