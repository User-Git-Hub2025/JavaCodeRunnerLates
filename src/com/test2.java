package com;
import java.sql.*;
public class test2 {
    public static void main(String[] args) {
        Connection conn=null;//负责链接mysql
        PreparedStatement st=null;  //执行sql命令的对象
        ResultSet  rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");     //引用驱动
            String url = "jdbc:mysql://localhost:3306/db1"        //3306是mysql的接口,db1是连接的数据库
                    + "?useSSL=false"                      // 练习时关闭 SSL，避免握手问题
                    + "&serverTimezone=Asia/Shanghai"      // 指定时区，避免时区错误
                    + "&characterEncoding=utf8"            // 防止中文乱码
                    + "&allowPublicKeyRetrieval=true&useUnicode=true";     // MySQL 8 认证协议需要
            conn = DriverManager.getConnection(url, "root", "root");
            //String sql = "select * from  tb_user";
            String sql = "select * from tb_user";
            st = conn.prepareStatement(sql);
            rs=st.executeQuery();// 执行SQL-----得到一个结果，可能有N条记录
            System.out.println("=====用户表的记录======");
          while (rs.next())    //rs.next 表示指针指向下一条记录，如果不为空，则返回true, 否则 false
          {
              String id=rs.getString("id");
              String name =rs.getString("name");
              String password=rs.getString("password");
              String address=rs.getString("address");
       System.out.println("账号："+id+"\t用户名："+name+"\t密码："+password+"\t地址："+address);
          }
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            // 关闭资源：rs-->PreparedStatement--->connnection
            try{if(rs!=null)  rs.close();}catch (Exception e){ e.printStackTrace();}
            try{if(st!=null)  st.close();}catch (Exception e){e.printStackTrace();}
            try{if(conn!=null)  conn.close();}catch (Exception e){e.printStackTrace();}
        }
    }
}
