package com.service;

import com.dao.userDAO;
import  com.Entity.userEntity;

import java.sql.ResultSet;

public  class userService {

    public static userEntity login(String name) {
        boolean flag = false;
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("用户名不能为空");
        }

        userEntity  model = userDAO.getUserByUsername(name);
        if (model == null) {
            return  null;
        }

        return model;
    }
}
