package indi.tudan.dreamer.mybatis.inteceptor;

import indi.tudan.dreamer.core.utils.SpringUtil;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;


/**
 * 当注解方法被执行后拦截并修改查询后的结果
 *
 * @author wangtan
 * @date 2019-08-01 19:57:49
 * @since 1.0
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class PageInteceptor implements Interceptor {
    private Properties properties;
    private SpringUtil spring; //实现  ApplicationContextAware 接口的类包含获取spring容器中的bean的静态方法

    @Override
    @SuppressWarnings(value = {"all"})
    public Object intercept(Invocation invocation) throws Throwable {
        // 因为 handleResultSets  方法执行结束后可以收到一个list类型的数据结果集，所以虽然该方法的目的是用于结束本次拦截，执行预定方法（handleResultSets）方便下次拦截
        List<Object> results = (List<Object>) invocation.proceed();
        try {
            //自定义方法用于判断对象是否为空
            if (null != results) { //ConstantFactory 是自定义的包含常用方法的一个类，现在用到的是它包含在其中的通过字典主键获取字典名称的方法
                Class<?> cls = results.get(0).getClass();
                Field[] fields = cls.getDeclaredFields();// 获取private修饰的成员变量  获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return results;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}