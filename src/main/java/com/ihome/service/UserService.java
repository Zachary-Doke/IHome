package com.ihome.service;

import com.ihome.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    User addUser(User user);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 更新用户
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据用户名和密码查询用户
     * @param user
     * @return
     */
    User getUserByNameAndPwd(User user);
}
