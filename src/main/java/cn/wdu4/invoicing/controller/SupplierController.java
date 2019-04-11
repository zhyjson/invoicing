package cn.wdu4.invoicing.controller;

import static cn.wdu4.invoicing.utils.Dictionary.*;
import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Supplier;
import cn.wdu4.invoicing.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhy
 * @create 2019-04-03 20:18
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;


    @GetMapping
    public Map<String, Object> listSupplier(Supplier supplier, Limit limit) {
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put(ROWS, supplierService.listSupplier(supplier, limit));
        pageMap.put(TOTAL, supplierService.countSupplier(supplier));
        return pageMap;
    }

    @PostMapping
    public Map<String, String> saveSupplier(Supplier supplier) {
        Map<String, String> messageMap = new HashMap<>();
        if(supplierService.saveSupplier(supplier)) {
            // 返回一条message为 添加 ,status为 0 的json格式数据提示用户
            messageMap.put(MESSAGE, SAVE_SUCCESS);
            messageMap.put(STATUS, SUCCESS_STATUS);
        }else {
            // 返回一条message为 添加失败 ,status为 1 的json格式数据提示用户
            messageMap.put(MESSAGE, SAVE_FAIL);
            messageMap.put(STATUS, FAIL_STATUS);
        }
        return messageMap;
    }

    @PutMapping
    public Map<String, String> updateSupplier(Supplier supplier) {
        Map<String, String> messageMap = new HashMap<>();
        if(supplierService.updateSupplier(supplier)) {
            // 返回一条message为 修改成功 ,status为 0 的json格式数据提示用户
            messageMap.put(MESSAGE, UPDATE_SUCCESS);
            messageMap.put(STATUS, SUCCESS_STATUS);
        }else {
            // 返回一条message为 修改失败 ,status为 1 的json格式数据提示用户
            messageMap.put(MESSAGE, UPDATE_FAIL);
            messageMap.put(STATUS, FAIL_STATUS);
        }
        return messageMap;
    }

    @DeleteMapping("/{supplierId}")
    public Map<String, String> removeSupplier(@PathVariable Integer supplierId) {
        Map<String, String> messageMap = new HashMap<>();
        if(supplierService.removeSupplier(supplierId)) {
            // 返回一条message为 修改成功 ,status为 0 的json格式数据提示用户
            messageMap.put(MESSAGE, REMOVE_SUCCESS);
            messageMap.put(STATUS, SUCCESS_STATUS);
        }else {
            // 返回一条message为 修改失败 ,status为 1 的json格式数据提示用户
            messageMap.put(MESSAGE, REMOVE_FAIL);
            messageMap.put(STATUS, FAIL_STATUS);
        }
        return messageMap;
    }
}
