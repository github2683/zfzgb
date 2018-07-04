package com.zhc.springcloud.feignservice.controller;

import com.zhc.springcloud.feignservice.remotecall.ServiceClient1Remote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ServiceClient1Remote serviceClient1Remote;

    @RequestMapping("/getName")
    @ResponseBody
    @CrossOrigin
    public String getName(String id ){
        return serviceClient1Remote.getName(id);
    }

}
