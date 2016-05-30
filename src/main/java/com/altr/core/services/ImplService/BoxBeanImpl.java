package com.altr.core.services.ImplService;

import com.altr.core.DAO.BoxDao;
import com.altr.core.Model.BoxesTable;
import com.altr.core.Model.UserTable;
import com.altr.core.services.IService.BoxBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("boxBean")
public class BoxBeanImpl implements BoxBean, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(BoxBeanImpl.class);

    @Autowired
    private BoxDao boxDao;
    private static BoxBeanImpl instance;

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public void setBoxDao(BoxDao boxDao) {
        this.boxDao = boxDao;
    }

    public static BoxBeanImpl get() {
        return instance;
    }

    @Override
    public BoxesTable findById(Integer id) throws Exception {
        return boxDao.findByBoxId(id);
    }

    @Override
    public void save(BoxesTable boxesTable) throws Exception {
        boxDao.save(boxesTable);
    }

    @Override
    public void update(BoxesTable boxesTable) throws Exception {
        boxDao.update(boxesTable);
    }

    @Override
    public void delete(BoxesTable boxesTable) throws Exception {
        boxDao.delete(boxesTable);
    }

    @Override
    public List<BoxesTable> findAll() throws Exception {
        return boxDao.findAll();
    }

    @Override
    public void deleteAll(List<BoxesTable> boxesTables) throws Exception {
        boxDao.deleteAllForUser(boxesTables);
    }
}
