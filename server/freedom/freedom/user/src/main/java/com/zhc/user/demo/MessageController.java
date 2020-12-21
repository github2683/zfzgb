package com.zhc.user.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhc
 * @Date 2020/12/17 17:22
 */
@RefreshScope
@RequestMapping("/demo")
@RestController
public class MessageController {

    @Value("${message:default message}")
    private String message;


    @RequestMapping("/message")
    public String showMessage(){

        System.out.println(" message controller is " +  this.message);
        return message;
    }
}
