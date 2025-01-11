package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
