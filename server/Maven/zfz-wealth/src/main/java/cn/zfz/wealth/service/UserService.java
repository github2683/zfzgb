package cn.zfz.wealth.service;

import cn.zfz.api.service.UserServiceApi;
import cn.zfz.wealth.components.UserServiceCallBack;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * 用户服务接口
 * UserServiceCallBack 中定义了容错
 */
@FeignClient(value = "zfz-user",fallback = UserServiceCallBack.class)
public interface UserService  extends UserServiceApi {

}
