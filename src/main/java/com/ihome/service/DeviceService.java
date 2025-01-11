package com.ihome.service;

import com.ihome.pojo.Device;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    Device addDevice(Device device);

    void deleteDeviceById(Integer deviceId);

    Device updateDevice(Device device);

    Device getDeviceById(Integer deviceId);

    List<Device> getDeviceList(Integer userId);
}
