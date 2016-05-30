package com.altr.core.services.IService;


import com.altr.core.Model.OrderTable;

import java.util.List;

public interface OrderBean {
    public OrderTable findById(Integer id) throws Exception;
    public void save(OrderTable orderTable) throws Exception;
    public void update(OrderTable orderTable) throws Exception;
    public void delete(OrderTable orderTable) throws Exception;
    public List<OrderTable> findAll() throws Exception;
}
