package com.ihome.controller;

import com.ihome.pojo.ResponseMessage;
import com.ihome.pojo.User;
import com.ihome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
public class UserController {

    @Autowired
    UserService userServiceImpl;

    //增加
    @PostMapping("/addUser")
    public ResponseMessage<User> addUser(@RequestBody User user) {
        User result=userServiceImpl.addUser(user);
        return ResponseMessage.success(result);
    }

    //查询用户
    @GetMapping("/getUserById")
    public ResponseMessage<User> getUser(@RequestParam Integer userId) {
        User result=userServiceImpl.getUserById(userId);
        return ResponseMessage.success(result);
    }

    //查询用户列表
    @GetMapping("/getUserList")
    public ResponseMessage<List<User>> getUserList() {
        List<User> result=userServiceImpl.getUserList();
        return ResponseMessage.success(result);
    }

    //修改
    @PutMapping("/updateUser")
    public ResponseMessage<User> updateUser(User user) {
        User result=userServiceImpl.updateUser(user);
        return ResponseMessage.success(result);
    }

    //删除
    @DeleteMapping("/deleteUserById")
    public ResponseMessage<String> deleteUser(Integer userId) {
        userServiceImpl.deleteUser(userId);
        return ResponseMessage.success("已执行删除操作");
    }
}
