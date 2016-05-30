package com.altr.core.services.ImplService;


import com.altr.core.DAO.OrderDao;
import com.altr.core.Model.OrderTable;
import com.altr.core.services.IService.OrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderBean")
public class OrderBeanImpl implements OrderBean, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(OrderBeanImpl.class);

    @Autowired
    private OrderDao orderDao;
    private static OrderBeanImpl instance;

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public static OrderBeanImpl get() {
        return instance;
    }

    @Override
    public OrderTable findById(Integer id) throws Exception {
        return orderDao.findByOrderId(id);
    }

    @Override
    public void save(OrderTable orderTable) throws Exception {
        orderDao.save(orderTable);
    }

    @Override
    public void update(OrderTable orderTable) throws Exception {
        orderDao.update(orderTable);
    }

    @Override
    public void delete(OrderTable orderTable) throws Exception {
        orderDao.delete(orderTable);
    }

    @Override
    public List<OrderTable> findAll() throws Exception{
        return orderDao.findAll();
    }
}
