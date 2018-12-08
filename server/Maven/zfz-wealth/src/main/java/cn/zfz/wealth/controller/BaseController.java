package cn.zfz.wealth.controller;

import cn.zfz.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/base")
@RestController
public class BaseController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser")
    public User getUser(String userId){
        String url = "http://zfz-user/user/get?id=" + userId;

        System.out.println(url);
        return restTemplate.getForEntity(url,User.class).getBody();

    }
}
