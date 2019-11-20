package com.css.dataexchangesystem.service;

import com.css.dataexchangesystem.entity.User;
import com.css.dataexchangesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id) {
            return userMapper.Sel(id);
    }

    public List getUserList() {
        return userMapper.getUserList();
    }
}