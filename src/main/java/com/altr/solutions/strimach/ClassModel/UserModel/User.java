package com.altr.solutions.strimach.ClassModel.UserModel;

/**
 * Created by Алексей on 21.05.2016.
 */
public class User {
    private String username;
    private Integer userId;
    private Integer roleId;

    public User() {
    }

    public User(String username, Integer userId, Integer roleId) {
        this.username = username;
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
