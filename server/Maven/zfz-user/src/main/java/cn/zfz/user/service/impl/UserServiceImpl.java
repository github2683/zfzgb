package cn.zfz.user.service.impl;

import cn.zfz.pojo.entity.User;
import cn.zfz.pojo.util.Encrypt;
import cn.zfz.user.dao.UserDao;
import cn.zfz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户的个性化功能实现
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) throws Exception{
        User loginUser = userDao.login(user);
        if(loginUser.getPassword().equals(Encrypt.encodeMD5(user.getPassword(),null))) {
            return loginUser;
        }
        return null;
    }
}
