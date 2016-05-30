package com.altr.core.system;

import com.altr.core.services.IService.UserBean;
import com.altr.core.services.ImplService.UserBeanImpl;

public class LoadingBean {

    public static UserBean UserBean() throws IllegalAccessException, InstantiationException {
        return UserBeanImpl.get();
    }
}
