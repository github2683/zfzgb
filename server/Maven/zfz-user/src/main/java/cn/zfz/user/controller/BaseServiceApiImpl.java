package cn.zfz.user.controller;

import cn.zfz.api.service.BaseServiceApi;
import cn.zfz.pojo.base.Base;
import cn.zfz.pojo.base.BaseController;
import cn.zfz.pojo.base.Result;
import cn.zfz.user.service.BaseService;

import java.util.List;

/**
 * 增改删查 通用控制器
 *
 * @param <T>       操作实体
 * @param <Service> 实体对应的服务接口
 */
public class BaseServiceApiImpl<T extends Base, Service extends BaseService<T>> extends BaseController<T> {

    //    @Autowired  由各自的controller注入
    protected Service service;


    public Result add(T et) throws Exception {
        Integer affectRow = service.add(et);
        return responseAdd(et, affectRow, this.getClass());
    }


    public Result delete(String id) throws Exception {
        Integer affectRow = service.delete(id);
        return responseDelete(id, affectRow, this.getClass());
    }


    public Result update(T et) throws Exception {
        Integer affectRow = service.update(et);
        return responseUpdate(et, affectRow, this.getClass());
    }


    public Result get(String id) throws Exception {
        T et = service.get(id);
        return responseGet(id, et, this.getClass());
    }


    public Result search(T et) throws Exception {
        List<T> ets = service.search(et);
        if (et.getPage() == null || et.getPage() == 1) {
            Integer total = service.searchCount(et);
            total = total == null ? 0 : total;
            et.setTotal(total);
        }
        return responseSearch(et, ets, this.getClass());
    }

}
