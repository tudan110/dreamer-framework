package indi.tudan.dreamer.demo.model;

import indi.tudan.dreamer.mybatis.annotation.Column;
import lombok.Data;

/**
 * 用户查询类
 *
 * @author wangtan
 * @date 2019-07-29 17:27:20
 * @since 1.0
 */
@Data
public class UserCondition {

    private String id;

    @Column(column = "id")
    private String minId;

    @Column(column = "id")
    private String maxId;

    private String name;

    private String email;

    /* start: Builder 链式调用 @author wangtan @date 2019-07-30 14:58:37 @since 1.0*/
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
    /* end: Builder 链式调用 @author wangtan @date 2019-07-30 14:58:37 @since 1.0*/

}
