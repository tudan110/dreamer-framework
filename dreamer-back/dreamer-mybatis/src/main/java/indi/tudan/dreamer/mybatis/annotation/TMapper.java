package indi.tudan.dreamer.mybatis.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 注解，扫描类（仅供自己学习）
 * <p/>
 * <pre>
 *     @MapperScan(basePackages = {"tudan.test.demo.mapper"}, annotationClass = TMapper.class)
 * </pre>
 *
 * @author wangtan
 * @date 2019-07-30 15:09:55
 * @since 1.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface TMapper {
}