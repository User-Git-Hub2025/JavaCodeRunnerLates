package com;

import com.service.userService;

import java.sql.ResultSet;

public class test4 {
    public static void main(String[] args) {
        ResultSet rs = userService.getUser;

        try {
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                String address = rs.getString("address");
                System.out.println("id=" + id + "\t名字：" + name + "\t");

            }
        }
    }
}
