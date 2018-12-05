package cn.zfz.user.controller;


import cn.zfz.pojo.base.BaseController;
import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.User;
import cn.zfz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Result add(User user){
        Integer affectRow = 0;
        Exception e = null;
        try {
            affectRow = userService.add(user);
        }catch (Exception ex){
            e = ex;
            //TODO 异常处理
        }
        return responseAdd(user,affectRow,this.getClass(),e);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Result delete(String id){
        Integer affectRow = 0;
        Exception e = null;
        try {
            affectRow = userService.delete(id);
        }catch (Exception ex){
            e = ex;
            //TODO 异常处理
        }
        return responseDelete(id,affectRow,this.getClass(),e);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Result update(User user){
        Integer affectRow = 0;
        Exception e = null;
        try {
            affectRow = userService.update(user);
        }catch (Exception ex){
            e = ex;
            //TODO 异常处理
        }
        return responseUpdate(user,affectRow,this.getClass(),e);
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Result get(String id){
        Integer affectRow = 0;
        Exception e = null;
        User user = null;
        try {
            user = userService.get(id);
        }catch (Exception ex){
            e = ex;
            //TODO 异常处理
        }
        return responseGet(id,user,this.getClass(),e);
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Result search(User user){
        List<User> users = null;
        Exception e = null;

        try {
            users = userService.search(user);
        }catch (Exception ex){
            e = ex;
            //TODO 异常处理
        }
        return responseSearch(user,users,this.getClass(),e);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Result login(User user){
        User u = null;
        Exception e = null;
        try {
            u = userService.login(user);
        } catch (Exception ex) {
            e = ex;
        }
        List<User> users = new ArrayList();
        users.add(u);

        return responseSearch(user,users,this.getClass(),e);
    }
}
