package cn.zfz.user.interceptor;

import cn.zfz.pojo.base.Constants;
import cn.zfz.pojo.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobelExceptionInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(GobelExceptionInterceptor.class);
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
//        model.addAttribute("author", "Magical Sam");
    }

    @ExceptionHandler(Exception.class)
    public Result excuteException(Exception ex){


        Result result = new Result();
        result.setCode(Constants.RESPONE_CODE_EXCEPTION);
        result.setMsg(Constants.RESPONE_MSG_EXCEPTION);
        result.setData(ex.getMessage());

        logger.error( this.getClass().getName() + " ===========> 注解拦截器 " + ex.getMessage());
        ex.printStackTrace();

        return result;
    }
}
