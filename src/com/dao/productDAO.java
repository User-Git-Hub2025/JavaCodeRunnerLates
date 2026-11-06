package com.dao;

import com.entity.Product;
import com.until.JdbcHelper;

public class productDAO {
    /**
     * pid 由 MySQL 自增生成，这里只插入商品名称、价格和库存。
     */
    public static int addProduct(Product product) {
        String sql = "insert into tb_product(pname, price, stock) values (?, ?, ?)";
        return JdbcHelper.update(sql,
                product.getPname(),
                product.getPrice(),
                product.getStock());
    }
}
