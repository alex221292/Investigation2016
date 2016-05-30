package com.altr.core.web.session;


public class Product {
    private String id;
    private String productName;
    private String cost;

    public Product(String id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Product() {
    }

    public Product(String id, String productName, String cost) {
        this.id = id;
        this.productName = productName;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
