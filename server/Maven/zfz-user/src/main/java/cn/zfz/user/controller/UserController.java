package cn.zfz.user.controller;


import cn.zfz.api.service.UserServiceApi;
import cn.zfz.pojo.base.BaseController;
import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.User;
import cn.zfz.pojo.util.Encrypt;
import cn.zfz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController<User> implements UserServiceApi {//extends BaseServiceApiImpl<User,UserService>

    @Autowired
    private UserService service;

//    public void setService(UserService service) {
//        this.service = service;
//    }

    @Override
    public Result add(User user) throws Exception {

        user.setPassword(Encrypt.encodeMD5(user.getPassword(),null));
        Integer affectRow = service.add(user);

        return responseAdd(user,affectRow,this.getClass());
    }


    public Result delete(String id) throws Exception {
        Integer affectRow =  service.delete(id);

        return responseDelete(id,affectRow,this.getClass());
    }


    public Result update(User user) throws Exception {
        Integer affectRow = service.update(user);

        return responseUpdate(user,affectRow,this.getClass());
    }


    public Result get(String id) throws Exception {
        User user = service.get(id);

        return responseGet(id,user,this.getClass());
    }



    public Result search(User user) throws Exception {
        List<User> users = service.search(user);
        if(user.getPage() == null || user.getPage() == 1){
            Integer total = service.searchCount(user);
            total = total==null?0:total;
            user.setTotal(total);
        }
        return responseSearch(user,users,this.getClass());
    }


    @GetMapping("/login")
    public Result login(User user) throws Exception {
        User u = service.login(user);

        List<User> users = new ArrayList();
        users.add(u);

        return responseSearch(user,users,this.getClass());
    }
}
