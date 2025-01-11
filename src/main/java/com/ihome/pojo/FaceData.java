package com.ihome.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Table(name = "face_data")
@Entity
@Data
public class FaceData implements Serializable {

    /**
    * 人脸数据ID
    */
    @Id
    private Integer id;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 人脸特征向量
    */
    private byte[] faceFeature;

}
