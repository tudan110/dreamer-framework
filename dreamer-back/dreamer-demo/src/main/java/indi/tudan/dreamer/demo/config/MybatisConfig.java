package indi.tudan.dreamer.demo.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis 注解配置
 *
 * @author wangtan
 * @date 2019-07-26 10:28:57
 * @since 1.0
 */
@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        // 设置驼峰命名规则
        return configuration -> configuration.setMapUnderscoreToCamelCase(true);
    }
}