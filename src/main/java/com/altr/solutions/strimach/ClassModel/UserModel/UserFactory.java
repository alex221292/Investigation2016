package com.altr.solutions.strimach.ClassModel.UserModel;

import com.altr.core.Model.UserTable;

import java.util.List;

/**
 * Created by Алексей on 21.05.2016.
 */
public interface UserFactory {
    public UserTable getUserById(int id) throws Exception;
}
