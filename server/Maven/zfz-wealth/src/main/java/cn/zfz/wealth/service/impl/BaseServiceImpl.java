package cn.zfz.wealth.service.impl;

import cn.zfz.pojo.entity.User;
import cn.zfz.wealth.service.BaseService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用 服务方法，如果出错，则调用 fallbackMethod 里的访求
     *
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "getUser2")
    public User getUser(String id) {
        return new User();
    }


    public User getUser2(String id) {
        return new User();
    }
}
