package com.zhc.springcloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user1")
@RestController
public class UserController {
    //读配置属性参数
    @Value("${server.port}")
    String port;

    //提供一个接口服务
    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String getName(String id) {

        return id+":" +port;
    }
}
