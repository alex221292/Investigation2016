package com.altr.core.services.ImplService;

import com.altr.core.DAO.RoleDao;
import com.altr.core.DAO.UserDao;
import com.altr.core.Model.RolesTable;
import com.altr.core.Model.UserTable;
import com.altr.core.services.IService.UserBean;
import com.altr.core.system.JdbcInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userBean")
public class UserBeanImpl implements UserBean, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(UserBeanImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    private static UserBeanImpl instance;

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public static UserBeanImpl get() {
        return instance;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Cacheable("user")
    public UserTable getUserById(int id) throws Exception {
        return this.userDao.findByUserId(id);
    }

    @Override
    public RolesTable getRoleById(int id) throws Exception {
        return this.roleDao.findByRoleId(id);
    }

    @Override
    @Cacheable("roles")
    public List<Integer> getRoleIdsByUserId(int id) throws Exception {
        return JdbcInstance.getJDBC().queryForList("select role_id from user_roles where user_id = ?", new Object[]{id}, Integer.class);

    }

    @Override
    public void updateUser(UserTable userTable) throws Exception{
        userDao.update(userTable);
    }

    @Override
    public void deleteUser(UserTable userTable) throws Exception{
        userDao.delete(userTable);
    }

    @Override
    public void saveUser(UserTable userTable) throws Exception{
        userDao.save(userTable);
    }
}
