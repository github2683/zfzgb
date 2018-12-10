package cn.zfz.pojo.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 通用controller返回
 * @param <T>
 */
public class BaseController<T extends Base> {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 新增返回
     * @param t 新增的类实例
     * @param affectRow 新增影响数据库行数
     * @param c 真实调用的Controller
     * @return 返回通用响应类实例
     */
    protected Result responseAdd(T t,Integer affectRow,Class c){
        String p = JSON.toJSONString(t);
        logger.info(c.getName() + "新增参数：" + p);
        boolean flag = affectRow != null && affectRow>0;
        Result result = setResult(flag);
        result.setData(t);
        return  result;
    }

    /**
     *  删除返回
     * @param id 要删除的数据ID
     * @param affectRow 新增影响数据库行数
     * @param c 真实调用的Controller
     * @return 返回通用响应类实例
     */
    protected Result responseDelete(String id,Integer affectRow,Class c){
        logger.info(c.getName() + "删除参数：id=" + id);
        boolean flag = affectRow != null && affectRow>0;
        Result result = setResult(flag);
        result.setData(id);
        return result;
    }

    /**
     *  更新返回
     * @param t 要更新的实体实例
     * @param affectRow 新增影响数据库行数
     * @param c 真实调用的Controller
     * @return 返回通用响应类实例
     */
    protected Result responseUpdate(T t,Integer affectRow,Class c){
        String p = t == null?"": JSON.toJSONString(t);
        logger.info(c.getName() + "更新参数：" + p);
        boolean flag = affectRow != null && affectRow>0;
        Result result = setResult(flag);
        result.setData(t);
        return result;
    }

    /**
     *  根据ID获取返回
     * @param id 要获取实体的ID
     * @param t 获取到的实体
     * @param c 真实调用的Controller
     * @return 返回通用响应类实例
     */
    protected Result responseGet(String id,T t,Class c ){
        String p = t == null?"":JSONObject.toJSONString(t);
        logger.info(c.getName() + " : Get参数：id=" + id +"\nGet结果：" + p);
        Result result = setResult(t != null);
        result.setData(t);
        return result;
    }

    /**
     *  查询返回
     * @param t 包含查询参数的实体
     * @param ts 查询结果集全
     * @param c 真实调用的Controller
     * @return 返回通用响应类实例
     */
    protected Result responseSearch(T t,List<T> ts,Class c){
        String p = JSON.toJSONString(t);
        String data = ts != null? JSONObject.toJSONString(ts):"";
        logger.info(c.getName() + " : 查询参数：" + p + "\n查询结果：" + data);
        Result result = setResult(ts != null);
        result.setTotal(t.getTotal());
        result.setPage(t.getPage());
        result.setLimit(t.getLimit());
        result.setData(ts);
        return result;
    }

    /**
     *  无数返回的操作返回
     * @param param1 第一个参数
     * @param param2 第二个参数
     * @param flag 执行结果状态,true 为成功，false 为失败
     * @param msg 操作说明
     * @param c 真实调用此方法的类
     * @return 返回通用响应对象
     */
    protected Result responseExcuteState(Object param1,Object param2,boolean flag,String msg,Class c){
        String info = c.getName() + " \n " + (msg == null?"":msg) + " " + (flag?"成功":"失败");
        if(param1 != null){
            info += "\n 第一个参数：" + JSONObject.toJSONString(param1);
        }
        if(param2 != null){
            info += "\n 第二个参数：" + JSONObject.toJSONString(param2);
        }
        logger.info(info);
        Result result = setResult(flag);
        result.setMsg(msg);
        return result;
    }

    /**
     * 响应基础数据设置
     * @param flag 成功或失败标志
     * @return
     */
    private Result setResult(boolean flag){
        Result result = new Result();

        if (flag) {
            logger.info("成功");
            result.setCode(Constants.RESPONE_CODE_SUCCESS);
            result.setMsg(Constants.RESPONE_MSG_SUCCESS);
        } else {
            logger.info("失败");
            result.setCode(Constants.RESPONE_CODE_FAILED);
            result.setMsg(Constants.RESPONE_MSG_FAILED);
        }

        return  result;
    }
}
