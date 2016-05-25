package com.altr.core.DAO;

import com.altr.core.Model.UserTable;

/**
 * Created by Алексей on 21.05.2016.
 */
public interface UserDao {
    void save(UserTable user);
    void update(UserTable user);
    void delete(UserTable user);
    UserTable findByUserId(Integer userId);
}
