package com.altr.core.services.ImplService;

import com.altr.core.DAO.CategoryDao;
import com.altr.core.Model.CategoryTable;
import com.altr.core.services.IService.CategoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service("categoryBean")
public class CategoryBeanImpl implements CategoryBean, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(CategoryBeanImpl.class);

    @Autowired
    private CategoryDao categoryDao;
    private static CategoryBeanImpl instance;

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public static CategoryBeanImpl get() {
        return instance;
    }

    @Override
    @Cacheable("category")
    public CategoryTable findById(Integer id) throws Exception {
        return categoryDao.findByCategoryId(id);
    }

    @Override
    public void save(CategoryTable categoryTable) throws Exception {
        categoryDao.save(categoryTable);
    }

    @Override
    public void update(CategoryTable categoryTable) throws Exception {
        categoryDao.update(categoryTable);
    }

    @Override
    public void delete(CategoryTable categoryTable) throws Exception {
        categoryDao.delete(categoryTable);
    }

    public List<CategoryTable> findAll() throws Exception{
        return categoryDao.findAll();
    }

}
