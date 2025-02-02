package com.ihome.controller;

import com.ihome.pojo.Device;
import com.ihome.pojo.ResponseMessage;
import com.ihome.service.DeviceService;
import com.ihome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserService userService;

    //添加设备
    @PostMapping("/addDevice")
    public ResponseMessage<Device> addDevice(@RequestBody Device device, int userId) {
        Device result=deviceService.addDevice(device,userId);
        return ResponseMessage.success(result);
    }

    @PostMapping("/saveDevice")
    public ResponseMessage<Device> saveDevice(@RequestBody Device device) {
        Device result=deviceService.saveDevice(device);
        return ResponseMessage.success(result);
    }

    //删除设备
    @DeleteMapping("/deleteDeviceById/{deviceId}")
    public ResponseMessage<String> deleteDeviceById(@PathVariable Integer deviceId) {
        deviceService.deleteDeviceById(deviceId);
        return ResponseMessage.success("已执行删除操作");
    }

    //更新设备信息
    @PutMapping("/updateDevice")
    public ResponseMessage<Device> updateDevice(@RequestBody Device device) {
        Device result=deviceService.updateDevice(device);
        return ResponseMessage.success(result);
    }

    //获取设备信息
    @GetMapping("/getDeviceById")
    public ResponseMessage<Device> getDeviceById(@RequestParam Integer deviceId) {
        Device result=deviceService.getDeviceById(deviceId);
        return ResponseMessage.success(result);
    }

    //获取用户的设备列表
    @GetMapping("/getDeviceList")
    public ResponseMessage<List<Device>> getDeviceList(@RequestParam Integer userId) {
        List<Device> result=deviceService.getDeviceList(userId);
        return ResponseMessage.success(result);
    }

    //启动设备
    @GetMapping("/openDevice")
    public ResponseMessage<String> openDevice(@RequestParam Integer deviceId) {
        Device device=deviceService.getDeviceById(deviceId);
        if(device.getStatus().equals("1")){
            return ResponseMessage.success("设备已经开启");
        }

        /*向设备发送命令并检查结果*/

        if(true/*设备成功启动*/){
            device.setStatus("1");
            deviceService.updateDevice(device);
            return ResponseMessage.success("设备启动成功");
        }else {
            return ResponseMessage.success("设备启动失败");
        }
    }

    //关闭设备
    @GetMapping("/shutDevice")
    public ResponseMessage<String> shutDevice(@RequestParam Integer deviceId) {
        Device device=deviceService.getDeviceById(deviceId);
        if(device.getStatus().equals("0")){
            return ResponseMessage.success("设备已经关闭");
        }

        /*向设备发送命令并检查结果*/

        if(true/*设备成功关闭*/){
            device.setStatus("0");
            deviceService.updateDevice(device);
            return ResponseMessage.success("设备关闭成功");
        }else {
            return ResponseMessage.success("设备关闭失败");
        }
    }

    //调节灯光
    @PostMapping("/adjustLight")
    public ResponseMessage<String> adjustLight(@RequestBody Device request) {
        Integer deviceId = request.getId();
        String parameters = request.getParameters();

        Device device=deviceService.getDeviceById(deviceId);
        if(!device.getType().equals("light")){
            return ResponseMessage.success("设备不是灯光设备");
        }

        /*向设备发送命令并检查结果*/

        if(true/*成功*/){
            device.setParameters(parameters);
            deviceService.updateDevice(device);
            return ResponseMessage.success("灯光调整成功");
        }else {
            return ResponseMessage.success("灯光调整失败");
        }
    }

    //调节空调
    @PostMapping("/adjustAc")
    public ResponseMessage<String> adjustAc(@RequestBody Device request) {
        Integer deviceId = request.getId();
        String parameters = request.getParameters();

        Device device=deviceService.getDeviceById(deviceId);
        if(!device.getType().equals("airConditioner")){
            return ResponseMessage.success("设备不是空调设备");
        }

        /*向设备发送命令并检查结果*/

        if(true/*成功*/){
            device.setParameters(parameters);
            deviceService.updateDevice(device);
            return ResponseMessage.success("空调调整成功");
        }else {
            return ResponseMessage.success("空调调整失败");
        }
    }

    //自动调节
    public String autoAdjustment () {
        return "此方法为后端AI功能调用";
    }

    //人脸识别
    @PostMapping("/faceRecognition")
    public ResponseMessage<String> faceRecognition(@RequestBody Image image) {

        /*调用人脸识别算法*/Integer userId=0;

        String username= userService.getUserById(userId).getUsername();
        if(true/*成功*/){
            return ResponseMessage.success(username);
        }else {
            return ResponseMessage.success("非法人员");
        }
    }

}
