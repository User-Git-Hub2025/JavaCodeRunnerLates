package com;

import com.entity.Product;
import com.service.productService;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("请输入要添加的商品: 商品名称 价格 库存");
            String pname = scanner.next();
            double price = scanner.nextDouble();
            int stock = scanner.nextInt();

            Product product = new Product(pname, price, stock);
            if (productService.addProduct(product)) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("添加失败: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
