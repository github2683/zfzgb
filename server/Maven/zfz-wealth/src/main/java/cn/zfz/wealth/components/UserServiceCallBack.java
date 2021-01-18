package cn.zfz.wealth.components;

import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.User;
import cn.zfz.wealth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务调用容错
 */
@Component
public class UserServiceCallBack {

    private static Logger logger = LoggerFactory.getLogger(UserServiceCallBack.class);


    public Result add(User user) throws Exception {
        logger.info(" remote user add call back ");
        return null;
    }


    public Result delete(String id) throws Exception {
        logger.info(" remote user delete call back ");
        return null;
    }


    public Result update(User user) throws Exception {
        logger.info(" remote user update call back ");
        return null;
    }


    public Result get(String id) throws Exception {
        logger.info(" remote user get call back ");
        return null;
    }


    public Result search(User user) throws Exception {
        logger.info(" remote user search call back ");
        return null;
    }
}
