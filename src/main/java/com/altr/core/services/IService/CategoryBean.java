package com.altr.core.services.IService;


import com.altr.core.Model.CategoryTable;

import java.util.List;

public interface CategoryBean {
    public CategoryTable findById(Integer id) throws Exception;
    public void save(CategoryTable categoryTable) throws Exception;
    public void update(CategoryTable categoryTable) throws Exception;
    public void delete(CategoryTable categoryTable) throws Exception;
    public List<CategoryTable> findAll() throws Exception;
}
