package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "devices")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getParameters() {
        return parameters;
    }

    public void setParameters(Double parameters) {
        this.parameters = parameters;
    }
}
