package com.entity;

public class ProductEntity {
    private int pid;
    private String name;
    private double price;
    private int stock;

    public ProductEntity(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public ProductEntity() {

    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return name;
    }

    public void setPname(String pname) {
        this.name = pname;
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
