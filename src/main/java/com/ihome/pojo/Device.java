package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Table(name = "devices")
@Entity
@Data
public class Device implements Serializable {

    /**
    * 设备ID
    */
    @Id
    private Integer id;
    /**
    * 设备名称
    */
    private String name;
    /**
    * 设备类型
    */
    private String type;
    /**
    * 所属用户
    */
    private Integer userId;
    /**
    * 设备状态
    */
    private String status;
    /**
     * 操作参数
     */
    private Double parameters;

}
