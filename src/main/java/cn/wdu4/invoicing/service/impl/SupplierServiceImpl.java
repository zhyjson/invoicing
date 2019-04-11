package cn.wdu4.invoicing.service.impl;

import cn.wdu4.invoicing.mapper.SupplierMapper;
import cn.wdu4.invoicing.pojo.Limit;
import cn.wdu4.invoicing.pojo.Supplier;
import cn.wdu4.invoicing.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhy
 * @create 2019-04-03 10:26
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public List<Supplier> listSupplier(Supplier supplier, Limit limit) {
        return supplierMapper.listSupplier(supplier, limit);
    }

    @Override
    public Integer countSupplier(Supplier supplier) {
        return supplierMapper.countSupplier(supplier);
    }

    @Override
    public Boolean saveSupplier(Supplier supplier) {
        return supplierMapper.saveSupplier(supplier);
    }

    @Override
    public Boolean removeSupplier(Integer supplierId) {
        return supplierMapper.removeSupplier(supplierId);
    }

    @Override
    public Boolean updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }
}
