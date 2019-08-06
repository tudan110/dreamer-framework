package indi.tudan.dreamer.mybatis.page;


import lombok.Data;

/**
 * 分页对象
 *
 * @author wangtan
 * @date 2019-07-30 15:43:33
 * @since 1.0
 */
@Data
public class Page {

    /**
     * 当前页码
     */
    private Integer pageNo;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 排序条件
     */
    private String orderBy;

    /**
     * 数据总量
     */
    private String totalCount;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page(Integer pageNo, Integer pageSize, String orderBy) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }

    /* start: Builder 链式调用 */
    public Page fluentSetPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public Page fluentSetPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Page fluentSetOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }
    /* end: Builder 链式调用 */
}