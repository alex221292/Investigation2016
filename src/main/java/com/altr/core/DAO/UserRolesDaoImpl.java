package com.altr.core.DAO;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Алексей on 21.05.2016.
 */
public class UserRolesDaoImpl implements UserRolesDao {
    private static final Logger logger = LoggerFactory.getLogger(UserRolesDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

}
