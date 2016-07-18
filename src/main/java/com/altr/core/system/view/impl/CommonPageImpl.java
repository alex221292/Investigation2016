package com.altr.core.system.view.impl;


import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;
import com.altr.core.services.IService.CategoryBean;
import com.altr.core.services.IService.ProductBean;
import com.altr.core.system.view.CommonPage;
import com.altr.core.web.model.json.Category;
import com.altr.core.web.model.json.PageContext;
import com.altr.core.web.model.json.Product;
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

    private List<ProductTable> products = new ArrayList<ProductTable>();
    private Integer categoryId;

    @Override
    public void pageLoad(Integer categoryId, PageContext pageContext) throws Exception {
        List<CategoryTable> categories = categoryBean.findAll();
        List<Category> jsonCategories = new ArrayList<Category>();
        List<Product> jsonProducts = new ArrayList<Product>();
        for (CategoryTable categoryTable : categories) {
            jsonCategories.add(new Category(categoryTable.getName(), categoryTable.getId().toString()));
            if (categoryId.equals(categoryTable.getId())){
                for (ProductTable productTable : categoryTable.getProducts()){
                    jsonProducts.add(new Product(productTable.getId().toString(), productTable.getName(), productTable.getCost()));
                }
            }
        }
        pageContext.setCategories(jsonCategories);
        pageContext.setProducts(jsonProducts);
    }

}
