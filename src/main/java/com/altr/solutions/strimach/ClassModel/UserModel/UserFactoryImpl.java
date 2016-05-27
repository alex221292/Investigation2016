package com.altr.solutions.strimach.ClassModel.UserModel;

import com.altr.core.Model.UserTable;
import com.altr.core.services.UserBean;
import com.altr.core.system.LoadingBean;
import com.altr.core.system.Tools;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Алексей on 21.05.2016.
 */
@Service("userFactory")
public class UserFactoryImpl implements UserFactory, InitializingBean {

    private static UserFactoryImpl instance;

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public static UserFactoryImpl get() {
        return instance;
    }

    @Override
    public UserTable getUserById(int id) throws Exception {
        List<Integer> roles =  LoadingBean.UserBean().getRoleIdsByUserId(id);
        if (Tools.isEmpty(roles)) throw new RuntimeException("User does not exist");
        return LoadingBean.UserBean().getUserById(id);
    }

}
