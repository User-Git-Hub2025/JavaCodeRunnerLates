package com.dao;

import com.Entity.ProductEntity;
import com.until.JdbcHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    //编辑商品
    @Override
    public boolean update(ProductEntity model) {
        String sql = "update tb_product set pname = '" + model.getPname() + "', price = " + model.getPrice() + ", stock = " + model.getStock() + " where pid = " + model.getPid() + "";
        boolean flag = false;
        int num = JdbcHelper.update(sql);

        if (num > 0) {
            flag = true;
        }
        return flag;
    }

    //删除商品
    @Override
    public boolean deleteById(int pid) {
        boolean flag = false;
        String sql = "delete from tb_product where pid = " + pid + "";

        int num = JdbcHelper.update(sql);
        if (num > 0) {
            flag = true;
        }
        return flag;
    }
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