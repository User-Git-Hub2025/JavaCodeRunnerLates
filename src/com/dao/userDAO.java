package com.dao;

import com.until.JdbcHelper;

import java.sql.ResultSet;

public class userDAO {
    public static int adduser (String name, String password, String address) {
        // 1. 补全 SQL 语句，使用 ? 作为占位符
        String sql = "insert into tb_user(name, password, address) values (?, ?, ?)";

        // 2. 把这三个参数传给 JdbcHelper.update
        return JdbcHelper.update(sql, name, password, address);
    }

    public static ResultSet getUser() {
        String sql = "select * from tb_user";
        return JdbcHelper.getResultSet(sql);
    }
}