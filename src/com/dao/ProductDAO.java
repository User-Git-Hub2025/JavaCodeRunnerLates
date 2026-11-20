package com.dao;

import com.Entity.ProductEntity;

import java.util.List;

public interface ProductDAO {

    //添加商品
    int insert(ProductEntity product);

    //删除商品
//    boolean deleteById(int pid);

    //更新产品信息
//    boolean update(ProductEntity product);

    //查找所有的商品
    List<ProductEntity> findALL();

    //根据id查找一个记录
//    ProductEntity findById(int pid);
}
