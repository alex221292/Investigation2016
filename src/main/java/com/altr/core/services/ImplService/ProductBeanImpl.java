package com.altr.core.services.ImplService;


import com.altr.core.DAO.ProductDao;
import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;
import com.altr.core.services.IService.ProductBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productBean")
public class ProductBeanImpl implements ProductBean, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(ProductBeanImpl.class);

    @Autowired
    private ProductDao productDao;
    private static ProductBeanImpl instance;

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public static ProductBeanImpl get() {
        return instance;
    }

    @Override
    public ProductTable findById(Integer id) throws Exception {
        return productDao.findByProductId(id);
    }

    @Override
    public void save(ProductTable productTable) throws Exception {
        productDao.save(productTable);
    }

    @Override
    public void update(ProductTable productTable) throws Exception {
        productDao.update(productTable);
    }

    @Override
    public void delete(ProductTable productTable) throws Exception {
        productDao.delete(productTable);
    }

    @Override
    public List<ProductTable> findAll() throws Exception {
        return productDao.findAll();
    }

}
