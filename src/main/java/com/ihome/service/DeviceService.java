package com.ihome.service;

import com.ihome.pojo.Device;

import java.util.List;

public interface DeviceService {
    Device addDevice(Device device);

    Device saveDevice(Device device);

    void deleteDeviceById(Integer deviceId);

    Device updateDevice(Device device);

    Device getDeviceById(Integer deviceId);

    List<Device> getDeviceList(Integer userId);

    List<Device> getDeviceListByType(Integer userId, String type);

    void deleteDeviceByIds(Integer[] deviceIds);

    List<Device> getDeviceListByDevice(String name, String type, String status, Integer userId);
}
