package cn.wdu4.invoicing.service.impl;

import cn.wdu4.invoicing.pojo.Emp;
import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceImplTest {

    @Autowired
    EmpService empService;
    @Test
    public void listEmp() {
        Emp emp = new Emp();
        Limit limit = new Limit(0,10);
        List<Integer> empIdList = new ArrayList<>();
        empIdList.add(1);
        empService.listEmp(emp, limit, empIdList).stream().forEach(System.out::println);
    }

}