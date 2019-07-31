package indi.tudan.dreamer.demo.model;

import indi.tudan.dreamer.mybatis.annotation.PK;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author wangtan
 * @date 2019-07-26 17:06:15
 * @since 1.0
 */
@Data
public class User {

    @PK
    private String id;

    private String name;

    private String email;

    /* start: Builder 链式调用 */
    public void fluentSetId(String id) {
        this.id = id;
    }

    public void fluentSetName(String name) {
        this.name = name;
    }

    public void fluentSetEmail(String email) {
        this.email = email;
    }
    /* end: Builder 链式调用 */

}