package cn.zfz.user.service;

import cn.zfz.pojo.base.Base;

import java.util.List;

public interface BaseService<T extends  Base> {

    Integer add(T t)throws Exception;

    Integer delete(String id)throws Exception;

    Integer update(T t)throws Exception;

    T get(String id)throws Exception;

    List<T> search(T t)throws Exception;

    Integer searchCount(T t)throws Exception;
}
