package com.ihome.service;

import com.ihome.pojo.Device;

import java.util.List;

public interface DeviceService {
    Device addDevice(Device device, int userId);

    Device saveDevice(Device device);

    void deleteDeviceById(Integer deviceId);

    Device updateDevice(Device device);

    Device getDeviceById(Integer deviceId);

    List<Device> getDeviceList(Integer userId);
}
