package cn.wdu4.invoicing.controller;

import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Emp;
import cn.wdu4.invoicing.service.EmpService;
import cn.wdu4.invoicing.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import static cn.wdu4.invoicing.utils.Dictionary.*;

import java.util.*;

/**
 * @author zhy
 * @create 2019-04-03 20:18
 */
@RestController
@RequestMapping("emp")
public class EmpController {
    @Autowired
    EmpService empService;
    @GetMapping
    public Map<String, Object> listEmp(Emp emp, Limit limit, HttpSession session) {
        Emp emp1 = (Emp)session.getAttribute(EMP);
        List<Integer> empIdList = new ArrayList<>();
        if (emp1 != null) {
            Arrays.asList(emp1.getEmpId());
        }
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put(ROWS, empService.listEmp(emp, limit, empIdList));
        pageMap.put(TOTAL, empService.countEmp(emp, empIdList));
        return pageMap;
    }

    @PostMapping
    public Map<String, String> saveEmp(MultipartFile empFace, Emp emp) {
        // 储存文件
        String fileName = FileUtils.fileStorage(empFace);
        Map<String, String> messageMap = new HashMap<>();
        if(!"".equals(fileName)){
            emp.setEmpFaceUrl(fileName);
        }else {
            emp.setEmpFaceUrl(DEFAULT_EMP_FACE_URL);
        }
        if(empService.saveEmp(emp)) {
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
    public Map<String, String> updateEmp(MultipartFile empFace, Emp emp) {
        String fileName = FileUtils.fileStorage(empFace);
        Map<String, String> messageMap = new HashMap<>();
        if(!"".equals(fileName)){
            emp.setEmpFaceUrl(fileName);
        }
        if(empService.updateEmp(emp)) {
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

    @DeleteMapping("/{empId}")
    public Map<String, String> removeEmp(@PathVariable Integer empId) {
        Map<String, String> messageMap = new HashMap<>();
        if(empService.removeEmp(empId)) {
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
