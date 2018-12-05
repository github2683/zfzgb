package cn.zfz.user.dao;

import cn.zfz.pojo.entity.User;

import java.sql.SQLException;

public interface UserDao extends BaseDao<User>{


    User login(User user)throws SQLException;

}
