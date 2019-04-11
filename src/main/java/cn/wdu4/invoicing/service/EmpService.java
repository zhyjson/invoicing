package cn.wdu4.invoicing.service;

import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Emp;

import java.util.List;

/**
 * @author zhy
 * @create 2019-04-03 10:26
 */
public interface EmpService {
    List<Emp> listEmp(Emp emp, Limit limit, List<Integer> empIdList);

    Integer countEmp(Emp emp, List<Integer> empIdList);

    Boolean saveEmp(Emp emp);

    Boolean removeEmp(Integer empId);

    Boolean updateEmp(Emp emp);
}
