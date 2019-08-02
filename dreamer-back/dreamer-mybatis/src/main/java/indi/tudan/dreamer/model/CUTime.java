package indi.tudan.dreamer.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 创建时间、修改时间
 *
 * @author wangtan
 * @date 2019-08-02 11:09:37
 * @since 1.0
 */
@Data
public class CUTime {

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /* start: Builder 链式调用 */
    public CUTime fluentSetCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public CUTime fluentSetUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    /* end: Builder 链式调用 */
}