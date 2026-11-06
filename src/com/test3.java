package com;

import com.entity.ProductEntity;
import com.service.productService;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.println("请输入要添加的商品: 商品名称 价格 库存");
//            String pname = scanner.next();
//            double price = scanner.nextDouble();
//            int stock = scanner.nextInt();
//
//            ProductEntity productEntity = new ProductEntity(pname, price, stock);
//            if (productService.AddProduct(productEntity)) {
//                System.out.println("添加成功");
//            } else {
//                System.out.println("添加失败");
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println("添加失败: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品信息：名称 价格 库存");
        String name;
        double price;
        int stock;
        name = scanner.next();
        price = scanner.nextDouble();
        stock = scanner.nextInt();

        ProductEntity mode = new ProductEntity();
        mode.setPname(name);
        mode.setPrice(price);
        mode.setStock(stock);

        if (productService.AddProduct(mode)) {
            System.out.println("商品添加成功");
        } else {
            System.out.println("商品添加失败");
        }

        //测试是否符合预定要求
    }
}
