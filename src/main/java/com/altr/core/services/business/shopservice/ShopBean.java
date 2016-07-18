package com.altr.core.services.business.shopservice;

import com.altr.core.web.model.json.ShoppingCart;

public interface ShopBean {
    public void addCard(Integer productId) throws Exception;
    public void getCart(String productId, ShoppingCart shoppingCart) throws Exception;
}