package cn.wdu4.invoicing.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AjaxHandlerInterceptor
 * @Description TODO 判断对子页面的http请求是否为ajax请求
 * @Auther zhy
 * @Date 2019/4/7 0007 15:08
 * @Version 1.0
 **/
public class AjaxHandlerInterceptor implements HandlerInterceptor {

    private static final String PREFIX = "/page/";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
                return true;
            }
            return false;
    }

    /**
     * @Author zhy
     * @Description //TODO 为子页面视图设置前缀名
     * @Date 16:33 2019/4/7 0007
     * @Param [request, response, handler, modelAndView]
     * @return void
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName(PREFIX + modelAndView.getViewName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
