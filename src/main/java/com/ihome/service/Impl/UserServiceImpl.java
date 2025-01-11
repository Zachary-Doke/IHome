package com.ihome.service.Impl;

import com.ihome.dao.UserDao;
import com.ihome.pojo.User;
import com.ihome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在,参数异常");
        });
    }

    @Override
    public List<User> getUserList() {
        Iterable<User> iterator = userDao.findAll();
        List<User> userList=new ArrayList<>();
        for(User user:iterator){
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteById(userId);
    }

}
