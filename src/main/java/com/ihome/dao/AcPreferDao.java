package com.ihome.dao;

import com.ihome.pojo.AcPrefer;
import org.springframework.data.repository.CrudRepository;

public interface AcPreferDao extends CrudRepository<AcPrefer, Integer> {
    Iterable<AcPrefer> findAllByDeviceId(Integer deviceId);
}
