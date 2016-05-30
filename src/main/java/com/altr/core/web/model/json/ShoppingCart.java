package com.altr.core.web.model.json;


import com.altr.core.web.jsonview.Views;
import com.altr.core.web.session.Product;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class ShoppingCart {

    public ShoppingCart() {
    }

    public ShoppingCart(String itemsCount, String fullPrice) {
        this.itemsCount = itemsCount;
        this.fullPrice = fullPrice;
    }

    @JsonView(Views.Public.class)
    private String itemsCount;

    @JsonView(Views.Public.class)
    private String fullPrice;

    @JsonView(Views.Public.class)
    private List<Product> products;

    public String getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(String itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(String fullPrice) {
        this.fullPrice = fullPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "itemsCount='" + itemsCount + '\'' +
                ", fullPrice='" + fullPrice + '\'' +
                ", products=" + products +
                '}';
    }
}
