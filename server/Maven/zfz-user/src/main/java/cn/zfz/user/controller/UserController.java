package cn.zfz.user.controller;


import cn.zfz.pojo.base.BaseController;
import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.User;
import cn.zfz.pojo.util.Encrypt;
import cn.zfz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    @Autowired
    private UserService userService;




    @GetMapping("/add")
    public Result add(User user) throws Exception {

        user.setPassword(Encrypt.encodeMD5(user.getPassword(),null));
        Integer affectRow = userService.add(user);

        return responseAdd(user,affectRow,this.getClass());
    }

    @GetMapping("/delete")
    public Result delete(String id) throws Exception {
        Integer affectRow =  userService.delete(id);

        return responseDelete(id,affectRow,this.getClass());
    }

    @PostMapping("/update")
    public Result update(User user) throws Exception {
        Integer affectRow = userService.update(user);

        return responseUpdate(user,affectRow,this.getClass());
    }

    @GetMapping("/get")
    public Result get(String id) throws Exception {
        User user = userService.get(id);

        return responseGet(id,user,this.getClass());
    }


    @GetMapping("/search")
    public Result search(User user) throws Exception {
        List<User> users = userService.search(user);
        if(user.getPage() == null || user.getPage() == 1){
            Integer total = userService.searchCount(user);
            total = total==null?0:total;
            user.setTotal(total);
        }
        return responseSearch(user,users,this.getClass());
    }


    @GetMapping("/login")
    public Result login(User user) throws Exception {
        User u = userService.login(user);

        List<User> users = new ArrayList();
        users.add(u);

        return responseSearch(user,users,this.getClass());
    }
}
