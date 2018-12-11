package cn.zfz.user.service.impl;

import cn.zfz.pojo.entity.User;
import cn.zfz.pojo.util.Encrypt;
import cn.zfz.user.dao.UserDao;
import cn.zfz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户的个性化功能实现
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService {

    @Autowired
    private UserDao userDao;


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.dao = userDao;
    }

    @Override
    public User login(User user) throws Exception{
        List<User> users = userDao.login(user);
        if(users == null || users.size() == 0 ){
            return null;
        }
        String pw = Encrypt.encodeMD5(user.getPassword(),null);
        for(User u : users){
            if(u.getPassword().equals(pw)){
                return u;
            }
        }
        return null;
    }
}
