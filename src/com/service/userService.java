package com.service;

import com.dao.userDAO;

public class userService {
    public static boolean adduser(String name, String password, String address){
        boolean flag = false;
        if (userDAO.adduser(name, password, address) > 0) {
            flag = true;
        }
        return flag;

    }
}
