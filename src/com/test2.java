package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class test2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db01"
                    + "?useSSL=false"                      // 练习时关闭 SSL，避免握手问题
                    + "&serverTimezone=Asia/Shanghai"      // 指定时区，避免时区错误
                    + "&characterEncoding=utf8"            // 防止中文乱码
                    + "&allowPublicKeyRetrieval=true";     // MySQL 8 认证协议需要
            conn = DriverManager.getConnection(url, "root", "root");
            String sql = "select * from tb_user";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            System.out.println("=======用户表的记录========");

            while (rs.next()){
                String id = rs.getString("id");
                String username = rs.getString("username");
                String pwd = rs.getString("pwd");
                String address = rs.getString("address");
                System.out.println("账号：" + id +"\t用户名：" + username + "\t密码：" + pwd + "\t地址：" + address);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
