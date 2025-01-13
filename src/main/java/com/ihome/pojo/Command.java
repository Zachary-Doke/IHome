package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Table(name = "commands")
@Entity
@Data
public class Command implements Serializable {

    /**
    * 指令ID
    */
    @Id
    private Integer id;
    /**
    * 设备ID
    */
    private Integer deviceId;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 指令内容
    */
    private String command;
    /**
    * 指令执行状态（等待/已执行/失败）
    */
    private String status;
    /**
    * 指令生成时间
    */
    private Date create;
    /**
    * 指令执行时间
    */
    private Date execute;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getExecute() {
        return execute;
    }

    public void setExecute(Date execute) {
        this.execute = execute;
    }
}
