package com.Entity;

public class ProductEntity {
    //  实体-ProductEntity---对应数据表 ：tb_product
    //属性---------数据表的字段， 一一对应  pid,pname,price ,stock
    private  int  pid;
    private  String pname;
    private   double price;
    private   int stock;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
