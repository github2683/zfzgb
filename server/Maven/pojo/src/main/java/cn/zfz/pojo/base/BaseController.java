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
     * @param e 异常类实例
     * @return 返回通用响应类实例
     */
    protected Result responseAdd(T t,Integer affectRow,Class c,Exception e){
        String p = JSON.toJSONString(t);
        logger.info(c.getName() + "新增参数：" + p);
        boolean flag = affectRow != null && affectRow>0;
        Result result = setResult(flag,e);
        return  result;
    }

    /**
     *  删除返回
     * @param id 要删除的数据ID
     * @param affectRow 新增影响数据库行数
     * @param c 真实调用的Controller
     * @param e 异常类实例
     * @return 返回通用响应类实例
     */
    protected Result responseDelete(String id,Integer affectRow,Class c,Exception e){
        logger.info(c.getName() + "删除参数：id=" + id);
        boolean flag = affectRow != null && affectRow>0;
        Result result = setResult(flag,e);
        return result;
    }

    /**
     *  更新返回
     * @param t 要更新的实体实例
     * @param affectRow 新增影响数据库行数
     * @param c 真实调用的Controller
     * @param e 异常类实例
     * @return 返回通用响应类实例
     */
    protected Result responseUpdate(T t,Integer affectRow,Class c,Exception e){
        String p = JSON.toJSONString(t);
        logger.info(c.getName() + "更新参数：" + p);
        boolean flag = affectRow != null && affectRow>0;
        Result result = setResult(flag,e);
        result.setData(t == null?"":JSONObject.toJSONString(t));
        return result;
    }

    /**
     *  根据ID获取返回
     * @param id 要获取实体的ID
     * @param t 获取到的实体
     * @param c 真实调用的Controller
     * @param e 异常类实例
     * @return 返回通用响应类实例
     */
    protected Result responseGet(String id,T t,Class c ,Exception e){
        String p = t == null?"":JSONObject.toJSONString(t);
        logger.info(c.getName() + "Get参数：id=" + id +"Get结果：" + p);
        Result result = setResult(t != null,e);
        result.setData(p);
        return result;
    }

    /**
     *  查询返回
     * @param t 包含查询参数的实体
     * @param ts 查询结果集全
     * @param c 真实调用的Controller
     * @param e 异常类实例
     * @return 返回通用响应类实例
     */
    protected Result responseSearch(T t,List<T> ts,Class c,Exception e){
        String p = JSON.toJSONString(t);
        String data = ts != null? JSONObject.toJSONString(ts):"";
        logger.info(c.getName() + "查询参数：" + p + "查询结果：" + data);
        Result result = setResult(true,e);
        result.setTotal(t.getTotal());
        result.setPage(t.getPage());
        result.setLimit(t.getLimit());
        result.setData(data);
        return result;
    }

    /**
     * 响应基础数据设置
     * @param flag
     * @param e
     * @return
     */
    private Result setResult(boolean flag,Exception e){
        Result result = new Result();
        if(e != null ){
            logger.error("异常");
            result.setCode(Constants.RESPONE_CODE_EXCEPTION);
            result.setMsg(Constants.RESPONE_MSG_EXCEPTION);
        }else {
            if (flag) {
                logger.info("成功");
                result.setCode(Constants.RESPONE_CODE_SUCCESS);
                result.setMsg(Constants.RESPONE_MSG_SUCCESS);
            } else {
                logger.info("失败");
                result.setCode(Constants.RESPONE_CODE_FAILED);
                result.setMsg(Constants.RESPONE_MSG_FAILED);
            }
        }
        return  result;
    }
}
