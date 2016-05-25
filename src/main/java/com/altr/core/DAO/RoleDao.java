package com.altr.core.DAO;

import com.altr.core.Model.RolesTable;

/**
 * Created by Алексей on 21.05.2016.
 */
public interface RoleDao {
    void save(RolesTable user);
    void update(RolesTable user);
    void delete(RolesTable user);
    RolesTable findByRoleId(Integer roleId);
}
