package com;
import com.service.userService;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        String name, pwd, address;
        System.out.println("请输入添加记录的: 用户名，密码， 地址");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        pwd = scanner.next();
        address = scanner.next();

        if (userService.adduser(name, pwd, address)){
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
//        System.out.println(insertUser(name, pwd, address));
    }
}

//第五次提交

//睡觉前最后一次测试





//再来