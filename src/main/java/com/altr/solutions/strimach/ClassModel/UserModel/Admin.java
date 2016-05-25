package com.altr.solutions.strimach.ClassModel.UserModel;

/**
 * Created by Алексей on 21.05.2016.
 */
public class Admin extends User {

    public Admin() {
    }

    public Admin(String username, Integer userId, Integer roleId) {
        super(username, userId, roleId);
    }
}
