package indi.tudan.dreamer.mybatis.annotation;

import java.lang.annotation.*;

/**
 * 字段主键注解
 *
 * @author wangtan
 * @date 2019-07-30 15:09:42
 * @since 1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PK {
}