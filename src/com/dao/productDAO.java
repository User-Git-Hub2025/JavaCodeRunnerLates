package com.dao;

import com.entity.ProductEntity;
import com.until.JdbcHelper;

public class productDAO {
    /**
     * pid 由 MySQL 自增生成，这里只插入商品名称、价格和库存。
     */
    public static int AddProduct(ProductEntity productEntity) {
        String sql = "insert into tb_product(pname, price, stock) values ('"+ model.getPname() +", "+ model.getPrice() +", "+ model.getStock() +"‘)";
        return JdbcHelper.update(sql);
    }
}
