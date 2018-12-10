package cn.zfz.api.service;

import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.Role;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/role")
public interface RoleServiceApi {

    @GetMapping("/add")
    Result add(Role role) throws Exception ;

    @GetMapping("/delete")
    Result delete(@RequestParam("id") String id) throws Exception ;

    @PostMapping("/update")
    Result update(Role role) throws Exception ;


    @GetMapping("/get")
    Result get(@RequestParam("id")String id) throws Exception ;

    @GetMapping("/search")
    Result search(Role role) throws Exception ;


}
