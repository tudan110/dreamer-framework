package indi.tudan.dreamer.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Spring 工具类
 *
 * @author wangtan
 * @date 2019-07-26 22:13:04
 * @since 1.0
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext ctx;
    private static Environment env;

    public static ApplicationContext ctx() {
        return ctx;
    }

    public static Environment env() {
        if (null == env) {
            env = (Environment) getBean("environment");
        }
        return env;
    }

    public static Object getBean(String name) {
        try {
            return ctx().getBean(name);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        try {
            return ctx().getBean(name, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        return env().getProperty(key, targetType, defaultValue);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
