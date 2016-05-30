package com.altr.core.services.business.shopservice;

import com.altr.core.web.model.json.AjaxResponseBody;
import com.altr.core.web.model.json.ShoppingCart;
import com.altr.core.web.session.Product;

public interface ShopBean {
    public void addCard(Integer productId) throws Exception;
    public void getCart(String productId, ShoppingCart shoppingCart) throws Exception;
}