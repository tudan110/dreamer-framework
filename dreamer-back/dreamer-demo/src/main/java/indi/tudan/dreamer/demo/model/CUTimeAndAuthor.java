package indi.tudan.dreamer.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建人、修改人 & 创建时间、修改时间
 *
 * @author wangtan
 * @date 2019-08-02 11:12:20
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CUTimeAndAuthor extends CUTime {

    public String createUser;

    public String updateUser;

    /* start: Builder 链式调用 */
    public CUTimeAndAuthor fluentSetCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public CUTimeAndAuthor fluentSetUpdateUser(String updateUser) {
        this.updateUser = updateUser;
        return this;
    }
    /* end: Builder 链式调用 */
}