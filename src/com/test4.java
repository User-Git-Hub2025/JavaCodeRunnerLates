package com;

import com.service.userService;

import java.sql.ResultSet;

public class test4 {
    public static void main(String[] args) {

        ResultSet rs= userService.getUser();
   try {
       while (rs.next())
       {
           String id=rs.getString("id");
           String name=rs.getString("name");
           String pwd=rs.getString("password");
           String address=rs.getString("address");
          // System.out.println("id"+id+"\t 名字："+name+" 密码+"+pwd+"地址"+address);

           System.out.println("id=" + id + "\t名字：" + name + " 密码：" + pwd + " 地址：" + address);
       }

   }catch (Exception e)
   {
       e.printStackTrace();
   }finally {
       try {
           if(rs!=null)  rs.close();
       }catch ( Exception e) {}
   }

    }
}
