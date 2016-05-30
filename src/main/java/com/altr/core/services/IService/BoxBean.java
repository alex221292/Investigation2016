package com.altr.core.services.IService;


import com.altr.core.Model.BoxesTable;
import com.altr.core.Model.UserTable;

import java.util.List;

public interface BoxBean {
    public BoxesTable findById(Integer id) throws Exception;
    public void save(BoxesTable boxesTable) throws Exception;
    public void update(BoxesTable boxesTable) throws Exception;
    public void delete(BoxesTable boxesTable) throws Exception;
    public List<BoxesTable> findAll() throws Exception;
    public void deleteAll(List<BoxesTable> boxesTables) throws Exception;
}
