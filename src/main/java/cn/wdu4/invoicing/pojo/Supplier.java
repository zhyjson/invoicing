package cn.wdu4.invoicing.pojo;

import java.io.Serializable;

/**
 * @author zhy
 * @create 2019-04-02 21:01
 */
public class Supplier implements Serializable {
    /** serialVersionUID*/
    private static final long serialVersionUID = 1L;
    // 供应商ID
    private Integer supplierId;
    // 供应商姓名
    private String supplierName;
    // 供应商电话
    private String supplierPhone;
    // 供应商地址
    private String supplierAddress;

    public Supplier(Integer supplierId, String supplierName, String supplierPhone, String supplierAddress) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierAddress = supplierAddress;
    }

    public Supplier() {}

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                '}';
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
}
