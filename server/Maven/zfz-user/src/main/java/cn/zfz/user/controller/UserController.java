package cn.zfz.user.controller;


import cn.zfz.pojo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zfz.pojo.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(User user){
        return "id=" + user.getId();
    }
}
