package com.dao;

import com.until.JdbcHelper;

public class userDAO {
    public static int adduser (String name, String password, String address) {
        String sql = "insert into tb_user(name, password, address)";
        return JdbcHelper.update(sql);
    }
}
