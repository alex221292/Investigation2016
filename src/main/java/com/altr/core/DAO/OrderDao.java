package com.altr.core.DAO;


import com.altr.core.Model.OrderTable;

import java.util.List;

public interface OrderDao {
    public void save(OrderTable orderTable);
    public void update(OrderTable orderTable);
    public void delete(OrderTable orderTable);
    public List<OrderTable> findAll();
    public OrderTable findByOrderId(Integer id);
}
