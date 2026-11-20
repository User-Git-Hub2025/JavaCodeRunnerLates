package com;

import com.Entity.ProductEntity;

import java.util.Scanner;
public class test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入产品的信息");
        String  name;
        double price;
        int  stock;
        name=sc.next();
        price=sc.nextDouble();
        stock=sc.nextInt();

        ProductEntity  mode =new ProductEntity();
        mode.setPname(name);
        mode.setPrice(price);
        mode.setStock(stock);

//        if(productService.AddProduct(mode))   //根据业务逻辑词的反馈
//        {
//           System.out.println("商品添加成功");
//        }
//        else
//        {
//            System.out.println("商品添加失败");
//        }

    }
}
