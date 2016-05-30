package com.altr.core.DAO;

import com.altr.core.Model.OrderTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends CustomHibernateDaoSupport implements OrderDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    public void save(OrderTable orderTable) {
        getHibernateTemplate().save(orderTable);
    }

    public void update(OrderTable orderTable) {
        getHibernateTemplate().update(orderTable);
    }

    public void delete(OrderTable orderTable) {
        getHibernateTemplate().delete(orderTable);
    }

    public List<OrderTable> findAll() {
        return ((List<OrderTable>) getHibernateTemplate().find("from OrderTable order by id"));
    }

    public OrderTable findByOrderId(Integer id) {
        List list = getHibernateTemplate().find("from OrderTable where id = ?", id);
        return (OrderTable)list.get(0);
    }
}
