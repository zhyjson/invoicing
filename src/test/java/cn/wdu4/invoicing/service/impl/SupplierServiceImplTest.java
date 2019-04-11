package cn.wdu4.invoicing.service.impl;

import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Supplier;
import cn.wdu4.invoicing.service.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhy
 * @create 2019-04-03 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierServiceImplTest {

    @Autowired
    SupplierService supplierService;
    @Test
    public void listSupplier() {
        Limit limit = new Limit();
        limit.setOffset(0);
        limit.setLimit(10);
        supplierService.listSupplier(new Supplier(), limit).stream().forEach(System.out::println);
    }

//    @Test
//    public boolean saveSupplier(Supplier supplier.html) {
//        return supplierMapper.saveSupplier(supplier.html);
//    }
//
//    @Test
//    public boolean removeSupplier(Integer supplierId) {
//        return supplierMapper.removeSupplier(supplierId);
//    }
//
//    @Test
//    public boolean updateSupplier(Supplier supplier.html) {
//        return supplierMapper.updateSupplier(supplier.html);
//    }
}