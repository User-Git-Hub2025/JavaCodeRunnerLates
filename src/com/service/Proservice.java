package com.service;


import com.Entity.ProductEntity;

import java.util.List;

public interface Proservice {
    //查找所有的商品
    List<ProductEntity> findALL();

    //添加商品
    boolean addProduct(ProductEntity product);

    //删除商品
    boolean deleteById(int pid);

    //编辑商品
    boolean updateProduct(ProductEntity product);
}