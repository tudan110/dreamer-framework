package indi.tudan.dreamer.mybatis.page;


import indi.tudan.dreamer.core.bean.BaseObject;
import lombok.Data;

/**
 * 分页对象
 *
 * @author wangtan
 * @date 2019-07-30 15:43:33
 * @since 1.0
 */
@Data
public class Page extends BaseObject {

    private Integer pageNo;
    private Integer pageSize;
    private String orderBy;

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