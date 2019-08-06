package indi.tudan.dreamer.demo.model;

import indi.tudan.dreamer.mybatis.annotation.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询类
 *
 * @author wangtan
 * @date 2019-07-29 17:27:20
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserCondition extends CUTimeAndAuthor {

    private String id;

    @Column(column = "id")
    private String minId;

    @Column(column = "id")
    private String maxId;

    private String name;

    private String email;

    /* start: Builder 链式调用 */
    public UserCondition fluentSetId(String id) {
        this.id = id;
        return this;
    }

    public UserCondition fluentSetMinId(String minId) {
        this.minId = minId;
        return this;
    }

    public UserCondition fluentSetMaxId(String maxId) {
        this.maxId = maxId;
        return this;
    }

    public UserCondition fluentSetName(String name) {
        this.name = name;
        return this;
    }

    public UserCondition fluentSetEmail(String email) {
        this.email = email;
        return this;
    }
    /* end: Builder 链式调用 */
}