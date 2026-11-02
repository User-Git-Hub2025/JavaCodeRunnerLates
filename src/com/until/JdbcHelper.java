package com.until;

import java.sql.*;

public class JdbcHelper {

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String url =
            "jdbc:mysql://localhost:3306/db1"          // 3306 端口，db1 数据库
                    + "?useSSL=false"                          // 练习关闭 SSL，避免握手问题
                    + "&serverTimezone=Asia/Shanghai"          // 指定时区，避免时区错误
                    + "&characterEncoding=utf8"                // 防止中文乱码
                    + "&useUnicode=true"                       // 与 characterEncoding 配合
                    + "&allowPublicKeyRetrieval=true";         // MySQL 8 认证协议需要

    private static final String username = "root";
    private static final String password = "root";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("MySQL 驱动加载失败: " + e.getMessage());
        }
    }

    private JdbcHelper() {}

    /** 获取连接，失败统一抛 DataAccessException */
    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DataAccessException("获取数据库连接失败", e);
        }
    }

    // ==================== 统一异常 ====================

    public static class DataAccessException extends RuntimeException {
        public DataAccessException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // ==================== 增删改 ====================

    /**
     * 执行增删改操作
     * @param sql 带有占位符 ? 的 SQL 语句
     * @param params 可变参数，按顺序传入 SQL 中 ? 对应的值
     * @return 受影响的行数
     */
    public static int update(String sql, Object... params) {
        if (sql == null || sql.trim().isEmpty()) {
            throw new IllegalArgumentException("SQL 不能为空");
        }
        // 使用 try-with-resources 自动关闭连接和 PreparedStatement
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 如果有参数，则循环将参数赋值给 SQL 中的 ?
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    // 注意：JDBC 的参数索引是从 1 开始的，所以这里是 i + 1
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            // 执行更新并返回受影响的行数
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new DataAccessException("执行更新失败: " + sql, e);
        }
    }
}