package com;

import com.service.userService;

import java.sql.ResultSet;

public class test4 {
    public static void main(String[] args) {
        ResultSet rs = userService.getUser;

        try {
            while (rs.next()) {
                String id = rs.getString();
                String name = rs.getString();
                String pwd = rs.getString();
                String address = rs.getString();

            }
        }
    }
}
