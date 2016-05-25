package com.altr.core.DAO;

import com.altr.core.Model.RolesTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Алексей on 21.05.2016.
 */
@Repository("roleDao")
public class RoleDaoImpl extends CustomHibernateDaoSupport implements RoleDao {
    private static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

    public void save(RolesTable user){
        getHibernateTemplate().save(user);
    }

    public void update(RolesTable user){
        getHibernateTemplate().update(user);
    }

    public void delete (RolesTable user){
        getHibernateTemplate().delete(user);
    }

    public RolesTable findByRoleId(Integer userId){
        List list = getHibernateTemplate().find(
                "from UserTable where id=?",userId
        );
        return (RolesTable)list.get(0);
    }
}
