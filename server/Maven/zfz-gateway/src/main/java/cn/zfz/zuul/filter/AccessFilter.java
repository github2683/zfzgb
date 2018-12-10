package cn.zfz.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 指定过虑类型，就是过虑在什么时期执行
     * <li>pre 此过虑器在路由转发前执行</li>
     * <li>routing 此过虑器在路由请求时执行</li>
     * <li>post：在routing和error过滤器之后被调用</li>
     * <li>error 请求路由发生错误时执行</li>
     * @return
     */
    @Override
    public String filterType() {

        return "pre";//此过虑器在路由转发前执行
    }

    /**
     * 此过虑器执行的顺序（可能会有众多的过虑器，所以要排顺序）
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断此过虑器是否需要被执行，false为不执行，true为执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体过虑逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accesstoken = request.getParameter("accesstoken");
        logger.info("accesstoken="+accesstoken);
        if(accesstoken == null){
            logger.warn(" no permisstion ");
//            ctx.setSendZuulResponse(true);
//            ctx.setResponseStatusCode(200);
            //过滤该请求，不往下级服务去转发请求，到此结束
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"result\":\"accessToken为空!\"}");
            ctx.getResponse().setContentType("text/html;charset=UTF-8");

        }else{
            //正常通过

            //或者可以设置
//            ctx.setSendZuulResponse(true);
//            ctx.setResponseStatusCode(200);
        }

        return null;
    }
}
