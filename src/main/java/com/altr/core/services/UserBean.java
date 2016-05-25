package com.altr.core.services;

import com.altr.core.Model.RolesTable;
import com.altr.core.Model.UserTable;

import java.util.List;

/**
 * Created by Алексей on 21.05.2016.
 */
public interface UserBean {
    public UserTable getUserById(int id) throws Exception;
    public RolesTable getRoleById(int id) throws Exception;
    public List<Integer> getRoleIdsByUserId(int id) throws Exception;
}
