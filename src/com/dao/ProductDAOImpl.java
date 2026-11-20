package com.dao;

import com.Entity.ProductEntity;
import com.until.JdbcHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public int insert(ProductEntity product) {
            String sql = "insert into tb_product (pname, price, stock) values ('" + product.getPname() + "', " + product.getPrice() + ", " + product.getStock() + ")";
            return JdbcHelper.update(sql);
    }
    @Override
    public List<ProductEntity> findALL(){
        String sql = "select * from tb_product";

        ArrayList<ProductEntity> list = new ArrayList<>();

        ResultSet rs = JdbcHelper.getResultSet(sql);

        try {
            while (rs.next()) {
                ProductEntity model = new ProductEntity();
                model.setPid(rs.getInt("pid"));
                model.setPname(rs.getString("pname"));
                model.setPrice(rs.getDouble("price"));
                model.setStock(rs.getInt("stock"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
