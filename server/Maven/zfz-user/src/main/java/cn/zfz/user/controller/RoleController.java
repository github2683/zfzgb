package cn.zfz.user.controller;

import cn.zfz.api.service.RoleServiceApi;
import cn.zfz.pojo.base.BaseController;
import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.Permission;
import cn.zfz.pojo.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController extends BaseController<Role> implements RoleServiceApi {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Override
    public Result add(Role role) throws Exception {
        logger.info(" role add ");
        return responseAdd(role,0,this.getClass());
    }

    @Override
    public Result delete(String id) throws Exception {
        logger.info("role delete ");
        return responseGet(id,null,this.getClass());
    }

    @Override
    public Result update(Role role) throws Exception {
        logger.info(" role update ");
        return responseUpdate(role,0,this.getClass());
    }

    @Override
    public Result get(String id) throws Exception {
        logger.info(" role get .");
        return responseGet(id,null,this.getClass());
    }

    @Override
    public Result search(Role role) throws Exception {
        logger.info("role search ");
        return responseSearch(role,null,this.getClass());
    }

    @RequestMapping("/addPermission")
    public Result addPermission(Permission permission,String id) throws Exception {
        logger.info(" role  addPermission ");
        String msg = " 角色添加功能 ";
        return responseExcuteState(permission,id,false,msg,this.getClass());
    }
}
