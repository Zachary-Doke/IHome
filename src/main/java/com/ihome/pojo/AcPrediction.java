package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
