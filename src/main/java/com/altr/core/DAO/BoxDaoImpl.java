package com.altr.core.DAO;

import com.altr.core.Model.BoxesTable;
import com.altr.core.Model.UserTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boxDao")
public class BoxDaoImpl extends CustomHibernateDaoSupport implements BoxDao {
    private static final Logger logger = LoggerFactory.getLogger(BoxDaoImpl.class);

    public void save(BoxesTable boxesTable) {
        getHibernateTemplate().save(boxesTable);
    }

    public void update(BoxesTable boxesTable) {
        getHibernateTemplate().update(boxesTable);
    }

    public void delete(BoxesTable boxesTable) {
        getHibernateTemplate().delete(boxesTable);
    }

    public void deleteAllForUser(List<BoxesTable> boxes) {
        getHibernateTemplate().deleteAll(boxes);
    }

    public List<BoxesTable> findAll() {
        return ((List<BoxesTable>) getHibernateTemplate().find("from BoxesTable order by id"));
    }

    public BoxesTable findByBoxId(Integer id) {
        List list = getHibernateTemplate().find("from BoxesTable where id = ?", id);
        return (BoxesTable)list.get(0);
    }
}
