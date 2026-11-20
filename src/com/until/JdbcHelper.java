package com.until;

import java.sql.*;

public class JdbcHelper {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String url =
            "jdbc:mysql://localhost:3306/db1"          // 3306 端口，db1 数据库
                    + "?useSSL=false"                          // 练习关闭 SSL，避免握手问题
                    + "&serverTimezone=Asia/Shanghai"          // 指定时区，避免时区错误
                    + "&characterEncoding=utf8"                // 防止中文乱码
                    + "&useUnicode=true"                       // 与 characterEncoding 配合
                    + "&allowPublicKeyRetrieval=true";         // MySQL 8 认证协议需要

    private static final String username = "root";    //登录mysql 账号
    private static final String password = "123456";    //登录mysql 密码

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("MySQL 驱动加载失败: " + e.getMessage());
        }
    }



    private JdbcHelper() {}

    /** 获取连接，失败统一抛 DataAccessException */
    private static Connection getConnection() {   //得到连接数据库的对象
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DataAccessException("获取数据库连接失败", e);
        }
    }
    // ==================== 2. 统一异常 ====================

    public static class DataAccessException extends RuntimeException {
        public DataAccessException(String message, Throwable cause) {
            super(message, cause);
        }
    }


    // ---------- 增删改：只传 SQL，直接执行 ----------
    public static int update(String sql) {
        if (sql == null || sql.trim().isEmpty()) {
            throw new IllegalArgumentException("SQL 不能为空");
        }
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException("执行更新失败: " + sql, e);
        }
    }

   // 实现批量查询功能的   select  * from 表名
    public static ResultSet getResultSet(String sql) {
        if (sql == null || sql.trim().isEmpty()) {
            throw new IllegalArgumentException("SQL 不能为空");
        }
        try {
            Connection conn = getConnection();          // 普通赋值，不放进 try()
            Statement stmt = conn.createStatement();    // 普通赋值，不放进 try()
            return stmt.executeQuery(sql);              // 直接返回
        } catch (SQLException e) {
            throw new DataAccessException("执行查询失败: " + sql, e);
        }
    }



}
