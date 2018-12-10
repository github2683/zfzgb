package cn.zfz.api.service;

import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.User;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/user")
public interface UserServiceApi  {

    @GetMapping("/add")
    Result add(User user) throws Exception ;

    @GetMapping("/delete")
    Result delete(@RequestParam("id") String id) throws Exception ;

    @PostMapping("/update")
    Result update(User user) throws Exception ;

    @GetMapping("/get")
    Result get(@RequestParam("id")String id) throws Exception ;

    @GetMapping("/search")
    Result search(User user) throws Exception ;



}
