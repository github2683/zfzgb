package cn.zfz.wealth.components;

import cn.zfz.pojo.base.Result;
import cn.zfz.wealth.service.UserService;
import org.springframework.stereotype.Component;

/**
 * 用户服务调用容错
 */
@Component
public class UserServiceCallBack implements UserService {

    @Override
    public Result get(String id) {
        return null;
    }
}
