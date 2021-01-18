package cn.zfz.user.service;

import cn.zfz.pojo.entity.User;

public interface UserService extends BaseService<User> {

    User login(User user) throws Exception;

}
