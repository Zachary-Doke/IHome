package com.ihome.dao;

import com.ihome.pojo.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao extends CrudRepository<Device, Integer> {
}
