package com.sq.dao;

import com.sq.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao {
    List<User> findAll();
}
