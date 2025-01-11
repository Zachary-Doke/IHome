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
    * 
    */
    @Id
    private Integer id;
    /**
    * 
    */
    private String name;
    /**
    * 
    */
    private String type;
    /**
    * 
    */
    private Integer userId;
    /**
    * 
    */
    private String status;

}
