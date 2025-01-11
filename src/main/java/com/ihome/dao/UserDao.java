package com.ihome.dao;

import com.ihome.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findUserByUsernameAndPassword(String username, String password);
}
