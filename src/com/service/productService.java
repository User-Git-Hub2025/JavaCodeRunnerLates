package com.service;

import com.dao.productDAO;
import com.entity.ProductEntity;



public class productService {
//    public static boolean addProduct(Product product) {
//        if (product == null) {
//            throw new IllegalArgumentException("商品不能为空");
//        }
//        if (product.getPname() == null || product.getPname().trim().isEmpty()) {
//            throw new IllegalArgumentException("商品名称不能为空");
//        }
//        if (product.getPrice() < 0) {
//            throw new IllegalArgumentException("商品价格不能为负数");
//        }
//        if (product.getStock() < 0) {
//            throw new IllegalArgumentException(" 商品库存不能为负数");
//        }
//        return productDAO.addProduct(product) > 0;
//    }

    public static boolean AddProduct(ProductEntity model) {
        boolean flag = false;

        if (productDAO.AddProduct(model) > 0) {
            flag = true;
        }

        return flag;
    }

}
