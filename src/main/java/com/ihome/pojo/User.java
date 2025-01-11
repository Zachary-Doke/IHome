package com.ihome.pojo;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Table(name = "users")
@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User implements Serializable {

    /**
    * 用户ID
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码（加密）
    */
    private String password;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 手机号
    */
    private String phone;

}
