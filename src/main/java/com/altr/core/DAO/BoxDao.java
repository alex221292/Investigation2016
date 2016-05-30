package com.altr.core.DAO;


import com.altr.core.Model.BoxesTable;
import com.altr.core.Model.UserTable;

import java.util.List;

public interface BoxDao {
    public void save(BoxesTable boxesTable);
    public void update(BoxesTable boxesTable);
    public void delete(BoxesTable boxesTable);
    public void deleteAllForUser(List<BoxesTable> boxes);
    public List<BoxesTable> findAll();
    public BoxesTable findByBoxId(Integer id);
}
