package cn.zfz.user.service.impl;

import cn.zfz.pojo.base.Base;
import cn.zfz.pojo.entity.User;
import cn.zfz.user.dao.BaseDao;
import cn.zfz.user.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T extends Base,Dao extends BaseDao> implements BaseService<T> {

    @Autowired
    private Dao dao;

    @Override
    public Integer add(T t)throws Exception {
        return dao.add(t);
    }

    @Override
    public Integer delete(String id) throws Exception{
        return null;
    }

    @Override
    public Integer update(T t) throws Exception{
        return null;
    }

    @Override
    public T get(String id)throws Exception {
        return null;
    }

    @Override
    public List<T> search(T t)throws Exception {
        return null;
    }
}
