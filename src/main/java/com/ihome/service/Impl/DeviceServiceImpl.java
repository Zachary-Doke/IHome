package com.ihome.service.Impl;

import com.ihome.dao.DeviceDao;
import com.ihome.pojo.Device;
import com.ihome.pojo.User;
import com.ihome.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;

    @Override
    public Device addDevice(Device device) {
        return deviceDao.save(device);
    }

    @Override
    public void deleteDeviceById(Integer deviceId) {
        deviceDao.deleteById(deviceId);
    }

    @Override
    public Device updateDevice(Device device) {
        return deviceDao.save(device);
    }

    @Override
    public Device getDeviceById(Integer deviceId) {
        return deviceDao.findById(deviceId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在,参数异常");
        });
    }

    @Override
    public List<Device> getDeviceList(Integer userId) {
        Iterable<Device> iterator = deviceDao.findAll();
        List<Device> deviceList=new ArrayList<>();
        for(Device device:iterator){
            deviceList.add(device);
        }
        return deviceList;
    }
}
