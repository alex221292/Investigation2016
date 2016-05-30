package com.altr.core.DAO;


import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;

import java.util.List;

public interface ProductDao {
    public void save(ProductTable productTable);
    public void update(ProductTable productTable);
    public void delete(ProductTable productTable);
    public ProductTable findByProductId(Integer id);
    public List<ProductTable> findAll();
    public List<ProductTable> findByCategory(CategoryTable categoryTable);
}
