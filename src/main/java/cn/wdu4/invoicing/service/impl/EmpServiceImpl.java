package cn.wdu4.invoicing.service.impl;

import cn.wdu4.invoicing.mapper.EmpMapper;
import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Emp;
import cn.wdu4.invoicing.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhy
 * @create 2019-04-03 10:26
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper EmpMapper;

    @Override
    public List<Emp> listEmp(Emp emp, Limit limit, List<Integer> empIdList) {
        return EmpMapper.listEmp(emp, limit, empIdList);
    }

    @Override
    public Integer countEmp(Emp emp, List<Integer> empIdList) {
        return EmpMapper.countEmp(emp, empIdList);
    }

    @Override
    public Boolean saveEmp(Emp emp) {
        return EmpMapper.saveEmp(emp);
    }

    @Override
    public Boolean removeEmp(Integer empId) {
        return EmpMapper.removeEmp(empId);
    }

    @Override
    public Boolean updateEmp(Emp emp) {
        return EmpMapper.updateEmp(emp);
    }
}
