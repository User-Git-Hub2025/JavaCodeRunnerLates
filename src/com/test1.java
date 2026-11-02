package com;
import sun.applet.Main;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class test1 {
    public static boolean insertUser(String name, String pwd, String address){
        Connection conn = null;
        PreparedStatement st = null;
        boolean flag = false;
        int n = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db01"
                    + "?useSSL=false"                      // 练习时关闭 SSL，避免握手问题
                    + "&serverTimezone=Asia/Shanghai"      // 指定时区，避免时区错误
                    + "&characterEncoding=utf8"            // 防止中文乱码
                    + "&allowPublicKeyRetrieval=true";     // MySQL 8 认证协议需要

            conn = DriverManager.getConnection(url, "root", "root");
            String sql = "insert into tb_user (username, pwd, address) value (?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pwd);
            st.setString(3, address);
            n = st.executeUpdate();
            if (n > 0){
                flag = true;
            }

            //flag = st.execute();
            return flag;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null){
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        String name, pwd, address;
        System.out.println("请输入添加记录的: 用户名，密码， 地址");

        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        pwd = scanner.next();
        address = scanner.next();

        System.out.println(insertUser(name, pwd, address));
    }
}
