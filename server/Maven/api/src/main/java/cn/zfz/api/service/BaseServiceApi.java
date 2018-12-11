package cn.zfz.api.service;

import cn.zfz.pojo.base.Base;
import cn.zfz.pojo.base.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
public interface BaseServiceApi<T extends Base> {

    @GetMapping("/add")
    Result add(T et) throws Exception ;

    @GetMapping("/delete")
    Result delete(@RequestParam("id") String id) throws Exception ;

    @GetMapping("/update")
    Result update(T et) throws Exception ;


    @GetMapping("/get")
    Result get(@RequestParam("id") String id) throws Exception ;

    @GetMapping("/search")
    Result search(T et) throws Exception ;


}
