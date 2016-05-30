package com.altr.core.DAO;


import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends CustomHibernateDaoSupport implements ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    public void save(ProductTable productTable) {
        getHibernateTemplate().save(productTable);
    }

    public void update(ProductTable productTable) {
        getHibernateTemplate().update(productTable);
    }

    public void delete(ProductTable productTable) {
        getHibernateTemplate().delete(productTable);
    }

    public List<ProductTable> findByCategory(CategoryTable categoryTable) {
        List list = getHibernateTemplate().find("from ProductTable where category = ?", categoryTable);
        return list;
    }

    public List<ProductTable> findAll() {
        return ((List<ProductTable>) getHibernateTemplate().find("from ProductTable order by id"));
    }

    public ProductTable findByProductId(Integer id) {
        List list = getHibernateTemplate().find("from ProductTable where id = ?", id);
        return (ProductTable)list.get(0);
    }

}
