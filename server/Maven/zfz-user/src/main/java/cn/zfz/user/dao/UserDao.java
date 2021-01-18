package cn.zfz.user.dao;

import cn.zfz.pojo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends BaseDao<User> {

    List<User> login(User user) throws SQLException;

}
