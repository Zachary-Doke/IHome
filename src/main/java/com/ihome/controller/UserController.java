package com.ihome.controller;

import com.ihome.pojo.ResponseMessage;
import com.ihome.pojo.User;
import com.ihome.service.Impl.UserServiceImpl;
import com.ihome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //增加
    @PostMapping("/addUser")
    public ResponseMessage<User> addUser(@RequestBody User user) {
        User result=userService.addUser(user);
        return ResponseMessage.success(result);
    }

    //查询用户
    @GetMapping("/getUserById")
    public ResponseMessage<User> getUser(@RequestParam Integer userId) {
        User result=userService.getUserById(userId);
        return ResponseMessage.success(result);
    }

    //查询用户列表
    @GetMapping("/getUserList")
    public ResponseMessage<List<User>> getUserList() {
        List<User> result=userService.getUserList();
        return ResponseMessage.success(result);
    }

    //修改
    @PutMapping("/updateUser")
    public ResponseMessage<User> updateUser(@RequestBody User user) {
        User result=userService.updateUser(user);
        return ResponseMessage.success(result);
    }

    //删除
    @DeleteMapping("/deleteUserById/{userId}")
    public ResponseMessage<String> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseMessage.success("已执行删除操作");
    }

    //用户登录
    @PostMapping("/login")
    public ResponseMessage<User> login(@RequestBody User user) {
        User result=userService.getUserByNameAndPwd(user);

        return ResponseMessage.success(result);  //失败为null
    }

    //修改密码
    @PostMapping("/modifyPwd")
    public ResponseMessage<User> modifyPwd(@RequestBody User user) {
        User result=userService.updateUser(user);
        return ResponseMessage.success(result);
    }
}
