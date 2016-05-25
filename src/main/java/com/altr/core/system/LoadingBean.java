package com.altr.core.system;

import com.altr.core.services.UserBean;
import com.altr.core.services.UserBeanImpl;
import com.altr.solutions.strimach.ClassModel.UserModel.UserFactory;
import com.altr.solutions.strimach.ClassModel.UserModel.UserFactoryImpl;

/**
 * Created by Алексей on 21.05.2016.
 */
public class LoadingBean {
    public static UserFactory UserFactory() throws IllegalAccessException, InstantiationException {
        return UserFactoryImpl.get();
    }

    public static UserBean UserBean() throws IllegalAccessException, InstantiationException {
        return UserBeanImpl.get();
    }
}
