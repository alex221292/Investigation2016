package com.altr.core.DAO;

import com.altr.core.Model.RolesTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("roleDao")
public class RoleDaoImpl extends CustomHibernateDaoSupport implements RoleDao {
    private static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

    public void save(RolesTable role){
        getHibernateTemplate().save(role);
    }

    public void update(RolesTable role){
        getHibernateTemplate().update(role);
    }

    public void delete (RolesTable role){
        getHibernateTemplate().delete(role);
    }

    public RolesTable findByRoleId(Integer roleId){
        List list = getHibernateTemplate().find(
                "from RoleTable where id=?",roleId
        );
        return (RolesTable)list.get(0);
    }
}
