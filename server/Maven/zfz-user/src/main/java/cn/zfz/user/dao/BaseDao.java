package cn.zfz.user.dao;

import cn.zfz.pojo.base.Base;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T extends Base> {

    Integer add(T t)throws SQLException;

    Integer delete(String id)throws SQLException;

    Integer update(T t)throws SQLException;

    T get(String id)throws SQLException;

    List<T> search(T t)throws SQLException;
}
