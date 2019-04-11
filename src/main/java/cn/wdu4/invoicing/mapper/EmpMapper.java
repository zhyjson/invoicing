package cn.wdu4.invoicing.mapper;

import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhy
 * @create 2019-04-03 10:20
 */
public interface EmpMapper {
    List<Emp> listEmp(@Param("emp") Emp emp, @Param("limit") Limit limit, @Param("empIdList") List<Integer> empIdList);

    Integer countEmp(@Param("emp") Emp emp, @Param("empIdList") List<Integer> empIdList);

    Boolean saveEmp(Emp emp);

    Boolean removeEmp(Integer empId);

    Boolean updateEmp(Emp emp);
}
