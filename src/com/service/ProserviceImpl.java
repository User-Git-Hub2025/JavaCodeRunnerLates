package com.service;

import com.Entity.ProductEntity;
import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;

import java.util.List;

public class ProserviceImpl implements Proservice {
    private final ProductDAO pdao = new ProductDAOImpl();

    //删除
    public boolean deleteById(int pid) {
        if (pid < 0) {
            return false;
        }
        return pdao.deleteById(pid);
    }

    @Override
    public boolean addProduct(ProductEntity product) {
        if (product == null || product.getPname() == null || product.getPname().isEmpty()) {
            System.err.println("业务校检失败：商品名称不能为空");
            return false;
        }

        if (product.getPrice() < 0) {
            System.err.println("业务校检失败：商品单价不能为负数");
            return false;
        }

        if (product.getStock() < 0) {
            System.err.println("业务校检失败：商品库存不能为负数");
            return false;
        }

        int num = pdao.insert(product);

        boolean flag = false;
        if (num > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<ProductEntity> findALL() {
        return pdao.findALL();
    }
}
