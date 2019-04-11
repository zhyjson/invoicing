package cn.wdu4.invoicing.config;

import cn.wdu4.invoicing.interceptor.AjaxHandlerInterceptor;
import cn.wdu4.invoicing.pojo.Emp;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import static cn.wdu4.invoicing.utils.Dictionary.EMP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zhy
 * @create 2019-04-03 13:24
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 将静态页面与前台路径进行映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
    }

    /**
     * @Author zhy
     * @Description //TODO 配置拦截器
     * @Date 15:07 2019/4/7 0007
     * @Param [registry]
     * @return void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AjaxHandlerInterceptor()).addPathPatterns("/page/**");
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                HttpSession session = request.getSession();
                Emp emp = (Emp)session.getAttribute(EMP);
                if(emp == null) {
                    emp = new Emp(7,"张三", "123456","110","小瓜子", "/image/cboy.jpeg");
                    session.setAttribute(EMP, emp);
                }
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

            }
        }).addPathPatterns("/**");
    }
}
