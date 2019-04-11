package cn.wdu4.invoicing.service;

import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Supplier;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author zhy
 * @create 2019-04-03 10:26
 */
public interface SupplierService {
    List<Supplier> listSupplier(Supplier supplier, Limit limit);

    Integer countSupplier(Supplier supplier);

    Boolean saveSupplier(Supplier supplier);

    Boolean removeSupplier(Integer supplierId);

    Boolean updateSupplier(Supplier supplier);
}
