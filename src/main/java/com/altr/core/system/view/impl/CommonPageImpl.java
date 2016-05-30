package com.altr.core.system.view.impl;


import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;
import com.altr.core.services.IService.CategoryBean;
import com.altr.core.services.IService.ProductBean;
import com.altr.core.system.view.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("commonPage")
public class CommonPageImpl implements CommonPage {

    @Autowired
    private CategoryBean categoryBean;
    @Autowired
    private ProductBean productBean;

    private List<CategoryTable> categories = new ArrayList<CategoryTable>();
    private List<ProductTable> products = new ArrayList<ProductTable>();
    private Integer categoryId;

    @Override
    public void pageLoad(Integer categoryId) throws Exception{
        categories = categoryBean.findAll();
        CategoryTable categoryInstance = categoryBean.findById(categoryId);
        this.categoryId = categoryInstance.getId();
        products = categoryInstance.getProducts();
    }

    public List<CategoryTable> getCategories() {
        return categories;
    }

    public List<ProductTable> getProducts() {
        return products;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
