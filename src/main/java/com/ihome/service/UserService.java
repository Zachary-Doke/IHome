package com.ihome.service;

import com.ihome.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    User addUser(User user);

    User getUserById(Integer userId);

    List<User> getUserList();

    User updateUser(User user);

    void deleteUser(Integer userId);
}
