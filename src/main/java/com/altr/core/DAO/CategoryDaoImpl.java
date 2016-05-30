package com.altr.core.DAO;


import com.altr.core.Model.CategoryTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cstegoryDao")
public class CategoryDaoImpl extends CustomHibernateDaoSupport implements CategoryDao {
    private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

    public void save(CategoryTable category) {
        getHibernateTemplate().save(category);
    }

    public void update(CategoryTable category) {
        getHibernateTemplate().update(category);
    }

    public void delete(CategoryTable category) {
        getHibernateTemplate().delete(category);
    }

    public CategoryTable findByCategoryId(Integer id) {
        List list = getHibernateTemplate().find("from CategoryTable where id = ?", id);
        return (CategoryTable) list.get(0);
    }

    public List<CategoryTable> findAll(){
        return ((List<CategoryTable>) getHibernateTemplate().find("from CategoryTable order by id"));
    }
}
