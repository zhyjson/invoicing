package cn.wdu4.invoicing.mapper;

import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhy
 * @create 2019-04-03 10:20
 */
public interface SupplierMapper {
    List<Supplier> listSupplier(@Param("supplier") Supplier supplier, @Param("limit") Limit limit);

    Integer countSupplier(Supplier supplier);

    Boolean saveSupplier(Supplier supplier);

    Boolean removeSupplier(Integer supplierId);

    Boolean updateSupplier(Supplier supplier);
}
