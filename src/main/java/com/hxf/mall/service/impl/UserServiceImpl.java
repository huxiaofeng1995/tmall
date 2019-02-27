package com.hxf.mall.service.impl;

import com.hxf.mall.dao.UserMapper;
import com.hxf.mall.entity.User;
import com.hxf.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.select_user_list();
    }
}
