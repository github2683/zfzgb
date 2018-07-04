package com.zhc.springcloud.feignservice.remotecall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-client1")
public interface ServiceClient1Remote {

    @RequestMapping(value = "/user/getName",method = RequestMethod.GET)
    String getName(@RequestParam("id")String id);

}
