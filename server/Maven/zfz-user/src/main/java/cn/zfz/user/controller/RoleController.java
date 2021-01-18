package cn.zfz.user.controller;

import cn.zfz.api.service.RoleServiceApi;
import cn.zfz.pojo.base.BaseController;
import cn.zfz.pojo.base.Result;
import cn.zfz.pojo.entity.Role;
import cn.zfz.user.service.RoleService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/role")
@RestController
public class RoleController extends BaseController<Role> implements RoleServiceApi {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService service;

    public Result add(Role et) throws Exception {
        logger.info("新增  " + JSONObject.toJSONString(et));
        Integer affectRow = service.add(et);

        return responseAdd(et, affectRow, this.getClass());
    }


    public Result delete(String id) throws Exception {
        Integer affectRow = service.delete(id);

        return responseDelete(id, affectRow, this.getClass());
    }


    public Result update(Role et) throws Exception {
        Integer affectRow = service.update(et);

        return responseUpdate(et, affectRow, this.getClass());
    }


    public Result get(String id) throws Exception {
        Role et = service.get(id);

        return responseGet(id, et, this.getClass());
    }


    public Result search(Role et) throws Exception {
        List<Role> ets = service.search(et);
        if (et.getPage() == null || et.getPage() == 1) {
            Integer total = service.searchCount(et);
            total = total == null ? 0 : total;
            et.setTotal(total);
        }
        return responseSearch(et, ets, this.getClass());
    }

}
