package cn.zfz.wealth.controller;

import cn.zfz.pojo.base.Result;
import cn.zfz.wealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/base")
@RestController
public class BaseController {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Result getUser(String userId) throws Exception {
//        String url = "http://zfz-user/user/get?id=" + userId;
//
//        System.out.println(url);
//        Result r = restTemplate.getForEntity(url,Result.class).getBody();
//        System.out.println(JSONObject.toJSONString(r));

        Result r  = userService.get(userId);


        return r;
    }
}
