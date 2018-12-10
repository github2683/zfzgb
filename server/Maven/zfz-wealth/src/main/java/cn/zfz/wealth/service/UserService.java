package cn.zfz.wealth.service;

import cn.zfz.pojo.base.Result;
import cn.zfz.wealth.components.UserServiceCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用户服务接口
 * UserServiceCallBack 中定义了容错
 */
@FeignClient(value = "zfz-user",fallback = UserServiceCallBack.class)
public interface UserService {

    @RequestMapping("/get")
    Result get(String id);
}
