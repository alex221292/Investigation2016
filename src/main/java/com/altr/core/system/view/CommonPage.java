package com.altr.core.system.view;


import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;

import java.util.List;

public interface CommonPage {
    public void pageLoad(Integer categoryId) throws Exception;
    public List<CategoryTable> getCategories();
    public List<ProductTable> getProducts();
    public Integer getCategoryId();
}
