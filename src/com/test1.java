package com;
import com.Entity.userEntity;
import com.service.userService;
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
                  String name,pwd,address;
                  System.out.println("请输入添加记录的：用户名，密码，地址");
        Scanner sc=new Scanner(System.in);
         name=sc.next();
         pwd=sc.next();
         address=sc.next();

         userEntity  model=new userEntity();
         model.setName(name);
         model.setPassword(pwd);
         model.setAddress(address);

      if(userService.adduser(model))    //调用业务逻辑逻辑层   ， 成功返回true,失败返回false
      {
          System.out.println("添加成功");
      }else
      {
          System.out.println("添加失败");
      }
    }
}
