package com.service;


import com.Entity.ProductEntity;

import java.util.List;

public interface Proservice {
    //查找所有的商品
    List<ProductEntity> findALL();

    //添加商品
    boolean addProduct(ProductEntity product);
}
