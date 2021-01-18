package cn.zfz.user.service.impl;

import cn.zfz.pojo.base.Base;
import cn.zfz.user.dao.BaseDao;
import cn.zfz.user.service.BaseService;

import java.util.List;

public class BaseServiceImpl<T extends Base, Dao extends BaseDao<T>> implements BaseService<T> {


    protected Dao dao;

    @Override
    public Integer add(T t) throws Exception {
        t.addInit();
        return dao.add(t);
    }

    @Override
    public Integer delete(String id) throws Exception {

        return dao.delete(id);
    }

    @Override
    public Integer update(T t) throws Exception {
        t.updateInit();
        return dao.update(t);
    }

    @Override
    public T get(String id) throws Exception {
        return dao.get(id);
    }

    @Override
    public List<T> search(T t) throws Exception {
        return dao.search(t);
    }

    @Override
    public Integer searchCount(T t) throws Exception {
        return dao.searchCount(t);
    }


}
