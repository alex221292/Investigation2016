package com.altr.core.services.IService;


import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;

import java.util.List;

public interface ProductBean {
    public ProductTable findById(Integer id) throws Exception;
    public void save(ProductTable productTable) throws Exception;
    public void update(ProductTable productTable) throws Exception;
    public void delete(ProductTable productTable) throws Exception;
    public List<ProductTable> findAll() throws Exception;
}
