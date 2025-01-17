package com.ihome.dao;

import com.ihome.pojo.LightPrefer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightPreferDao extends CrudRepository<LightPrefer, Integer> {
    Iterable<LightPrefer> findAllByDeviceId(Integer deviceId);
}
