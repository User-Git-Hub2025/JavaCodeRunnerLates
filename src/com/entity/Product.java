package com.entity;

public class Product {
    private int pid;
    private String pname;
    private double price;
    private int stock;

    public Product() {
    }

    public Product(String pname, double price, int stock) {
        this.pname = pname;
        this.price = price;
        this.stock = stock;
    }

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
