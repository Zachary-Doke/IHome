package com.ihome.dao;

import com.ihome.pojo.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandDao extends CrudRepository <Command, Integer> {
}