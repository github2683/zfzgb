package com.zhc.springcloud.feignservice.remotecall;

import org.springframework.stereotype.Component;

@Component
public class RemoteHystric implements ServiceClient1Remote{


    @Override
    public String getName(String id) {
        return "调用service-client1.getName方法出错，参数id="+id;
    }
}
