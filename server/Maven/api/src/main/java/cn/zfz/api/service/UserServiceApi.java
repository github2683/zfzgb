package cn.zfz.api.service;

import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.User;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/user")
public interface UserServiceApi  {

    @GetMapping("/add")
    Result add(@RequestBody User user) throws Exception ;

    @GetMapping("/delete")
    Result delete(@RequestParam("id") String id) throws Exception ;

    @PostMapping("/update")
    Result update(@RequestBody User user) throws Exception ;

    @GetMapping("/get")
    Result get(@RequestParam("id")String id) throws Exception ;

    @GetMapping("/search")
    Result search(User user) throws Exception ;



}
