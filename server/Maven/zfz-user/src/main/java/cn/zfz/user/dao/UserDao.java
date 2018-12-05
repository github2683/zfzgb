package cn.zfz.user.dao;

import cn.zfz.pojo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends BaseDao<User>{

    Integer add(User user)throws SQLException;

    Integer delete(String id)throws SQLException;

    Integer update(User user)throws SQLException;

    User get(String id)throws SQLException;

    List<User> search(User user)throws SQLException;
    List<User> login(User user)throws SQLException;

}
