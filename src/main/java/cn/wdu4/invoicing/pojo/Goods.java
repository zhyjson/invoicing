package cn.wdu4.invoicing.pojo;

/**
 * @author zhy
 * @create 2019-04-02 20:53
 */
public class Goods {
    // 商品ID
    private Integer goodId;
    // 供应商
    private Supplier supplier;
    // 商品进价
    private Double goodPrice;
    // 商品卖价
    private Double sellingPrice;
    // 商品名字
    private String goodName;
    // 商品类型
    private String goodType;
    // 商品单位
    private String unitName;

    public Goods(int goodId, Supplier supplier, double goodPrice, double sellingPrice, String goodName, String goodType, String unitName) {
        this.goodId = goodId;
        this.supplier = supplier;
        this.goodPrice = goodPrice;
        this.sellingPrice = sellingPrice;
        this.goodName = goodName;
        this.goodType = goodType;
        this.unitName = unitName;
    }

    public Goods() {
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
