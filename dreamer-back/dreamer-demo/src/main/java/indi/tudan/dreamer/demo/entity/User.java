package indi.tudan.dreamer.demo.entity;

import indi.tudan.dreamer.demo.model.CUTimeAndAuthor;
import indi.tudan.dreamer.mybatis.annotation.PK;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 *
 * @author wangtan
 * @date 2019-07-26 17:06:15
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends CUTimeAndAuthor {

    @PK
    private String id;

    private String name;

    private String email;

    /* start: Builder 链式调用 */
    public User fluentSetId(String id) {
        this.id = id;
        return this;
    }

    public User fluentSetName(String name) {
        this.name = name;
        return this;
    }

    public User fluentSetEmail(String email) {
        this.email = email;
        return this;
    }
    /* end: Builder 链式调用 */
}