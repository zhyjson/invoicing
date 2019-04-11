package cn.wdu4.invoicing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import static cn.wdu4.invoicing.utils.Dictionary.*;
/**
 * @author zhy 对每个子页面模板初始化
 * @create 2019-04-07 10:38
 */
@Controller
@RequestMapping("/page")
public class PageDispatcherController {

    /**
     * @Author zhy
     * @Description //TODO 初始化供应商子页面
     * @Date 18:04 2019/4/7 0007
     * @Param []
     * @return java.lang.String
     */
    @GetMapping("/supplier.html")
    public String supplierDispatcher(){
        return SUPPLIER;
    }

    /**
     * @Author zhy
     * @Description //TODO 初始化员工子页面
     * @Date 18:04 2019/4/7 0007
     * @Param []
     * @return java.lang.String
     */
    @GetMapping("/emp.html")
    public String empDispatcher(){
        return EMP;
    }


}
