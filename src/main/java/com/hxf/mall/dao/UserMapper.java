package com.hxf.mall.dao;

import com.hxf.mall.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> select_user_list();
}
