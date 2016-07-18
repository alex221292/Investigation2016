package com.altr.core.web.controller;

import com.altr.core.services.business.shopservice.ShopBean;
import com.altr.core.system.view.CommonPage;
import com.altr.core.web.jsonview.Views;
import com.altr.core.web.model.json.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AjaxController {
    private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

    @Autowired
    private CommonPage commonPage;

    @Autowired
    private ShopBean shopBean;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/cart/api/addItem",
            method = RequestMethod.POST,
            headers = {"content-type=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody setCartItem(@RequestBody CartItem cartItem, HttpSession session) throws Exception {
        AjaxResponseBody response = new AjaxResponseBody();
        ShoppingCart shoppingCart = new ShoppingCart();
        if (cartItem != null && cartItem.getProductId() != null) {
            if (null == session.getAttribute("products")) {
                shoppingCart.setItemsCount("0");
                shoppingCart.setFullPrice("0");
                shopBean.getCart(cartItem.getProductId(), shoppingCart);
                session.setAttribute("products", shoppingCart.getProducts());
                session.setAttribute("itemsCount", shoppingCart.getItemsCount());
                session.setAttribute("fullPrice", shoppingCart.getFullPrice());
            } else {
                shoppingCart.setProducts((List<Product>)session.getAttribute("products"));
                shopBean.getCart(cartItem.getProductId(), shoppingCart);
                session.setAttribute("products", shoppingCart.getProducts());
                session.setAttribute("itemsCount", shoppingCart.getItemsCount());
                session.setAttribute("fullPrice", shoppingCart.getFullPrice());
            }
            response.setCode("200");
            response.setMsg("");
            response.setResults(shoppingCart);
        } else {
            response.setCode("800");
            response.setMsg("Error");
        }
        return response;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/page/api/loadPage",
            method = RequestMethod.POST,
            headers = {"content-type=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody loadPage(@RequestBody CartItem cartItem, HttpSession session) throws Exception {
        AjaxResponseBody response = new AjaxResponseBody();
        PageContext pageContext = new PageContext();
        String itemsCount = (String)session.getAttribute("itemsCount");
        if (itemsCount == null) itemsCount = "0";
        String fullPrice = (String)session.getAttribute("fullPrice");
        if (fullPrice ==null) fullPrice = "0";
        pageContext.setFullPrice(fullPrice);
        pageContext.setItemsCount(itemsCount);
        Integer categoryId = 1;
        try {
            if (!StringUtils.isEmpty(cartItem.getProductId()))
                categoryId = Integer.parseInt(cartItem.getProductId());
            commonPage.pageLoad(categoryId, pageContext);
        } catch (Exception e){
            logger.info("[loadPage] ERROR " + e.toString());
        }
        response.setCode("200");
        response.setResults(pageContext);
        return response;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/cart/api/prepareOrder",
            method = RequestMethod.POST,
            headers = {"content-type=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody prepareOrder(HttpSession session) throws Exception {
        AjaxResponseBody response = new AjaxResponseBody();
        PageContext pageContext = new PageContext();
        pageContext.setProducts((List<Product>)session.getAttribute("products"));
        response.setCode("200");
        response.setResults(pageContext);
        return response;
    }

}
