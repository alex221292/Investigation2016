package com.altr.core.DAO;

import com.altr.core.Model.CategoryTable;

import java.util.List;

public interface CategoryDao {
    public void save(CategoryTable category);
    public void update(CategoryTable category);
    public void delete(CategoryTable category);
    public CategoryTable findByCategoryId(Integer id);
    public List<CategoryTable> findAll();
}
