package com.altr.core.DAO;

import com.altr.core.Model.UserTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Алексей on 21.05.2016.
 */
@Repository("userDao")
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public void save(UserTable user){
        getHibernateTemplate().save(user);
    }

    public void update(UserTable user){
        getHibernateTemplate().update(user);
    }

    public void delete (UserTable user){
        getHibernateTemplate().delete(user);
    }

    public UserTable findByUserId(Integer userId){
        List list = getHibernateTemplate().find(
                "from UserTable where id=?",userId
        );
        return (UserTable)list.get(0);
    }

}
