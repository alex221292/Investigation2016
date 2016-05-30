package com.altr.core.services.business.shopservice.impl;


import com.altr.core.Model.BoxesTable;
import com.altr.core.Model.ProductTable;
import com.altr.core.Model.UserTable;
import com.altr.core.services.IService.BoxBean;
import com.altr.core.services.IService.ProductBean;
import com.altr.core.services.IService.UserBean;
import com.altr.core.services.business.shopservice.ShopBean;
import com.altr.core.system.JdbcInstance;
import com.altr.core.web.model.json.AjaxResponseBody;
import com.altr.core.web.model.json.ShoppingCart;
import com.altr.core.web.session.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("shopBean")
public class ShopBeanImpl implements ShopBean {
    private static final Logger logger = LoggerFactory.getLogger(ShopBeanImpl.class);

    @Autowired
    private UserBean userBean;
    @Autowired
    private ProductBean productBean;
    @Autowired
    private BoxBean boxBean;

    private Integer fullCust = 0;

    @Transactional(readOnly = false)
    public void addCard(Integer productId) throws Exception {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer userId = JdbcInstance.getJDBC().queryForObject("select user_id from users where username = ?"
                , new Object[]{currentUserName}
                , Integer.class);
        UserTable userInstance = userBean.getUserById(userId);
        ProductTable productInstance = productBean.findById(productId);
        BoxesTable newBoxInstance = new BoxesTable();
        newBoxInstance.setUser(userInstance);
        newBoxInstance.setProduct(productInstance);
        boxBean.save(newBoxInstance);
    }

    @Transactional(readOnly = true)
    public void getCart(String productId, ShoppingCart shoppingCart) throws Exception {
        ProductTable productInstance = productBean.findById(Integer.parseInt(productId));
        if (productInstance == null) throw new RuntimeException("Product does not exist");
        List<Product> products = new ArrayList<Product>();
        if (shoppingCart.getProducts() != null) {
            products = shoppingCart.getProducts();
        }
        products.add(new Product(productInstance.getId().toString()
                , productInstance.getName()
                , productInstance.getCost()));
        fullCust = 0;
        setFullCost(products);
        shoppingCart.setFullPrice(fullCust.toString());
        shoppingCart.setItemsCount(Integer.toString(products.size()));
        shoppingCart.setProducts(products);
    }

    public void setFullCost(List<Product> products) {
        for (Product product : products) {
            if (product.getCost()!= null) fullCust+=Integer.parseInt(product.getCost());
        }
    }

}
