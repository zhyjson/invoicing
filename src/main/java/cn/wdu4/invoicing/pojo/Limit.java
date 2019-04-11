package cn.wdu4.invoicing.pojo;

/**
 * 分页对象
 * @author zhy
 * @create 2019-04-04 13:30
 */
public class Limit {
    private Integer offset;
    private Integer limit;

    public Limit(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Limit() {
    }

    @Override
    public String toString() {
        return "Limit{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
