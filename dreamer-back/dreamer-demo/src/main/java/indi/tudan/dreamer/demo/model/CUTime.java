package indi.tudan.dreamer.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime updateTime;

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