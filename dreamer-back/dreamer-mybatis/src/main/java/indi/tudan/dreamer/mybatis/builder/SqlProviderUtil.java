package indi.tudan.dreamer.mybatis.builder;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import indi.tudan.dreamer.core.utils.SpringUtil;
import indi.tudan.dreamer.mybatis.annotation.Column;
import indi.tudan.dreamer.mybatis.annotation.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.UnknownTypeHandler;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtan
 * @date 2019-07-26 17:05:14
 * @since 1.0
 */
@Slf4j
public class SqlProviderUtil {

    /**
     * 是否使用驼峰
     */
    private static Boolean mapUnderscoreToCamelCase;

    /**
     * 实体类的 field
     */
    private static Map<Class, List<Field>> classFieldMap = new HashMap<>();

    /**
     * 日志是 debug 级别，打印 sql
     *
     * @param sql sql语句
     */
    static void logDebugSql(String sql) {
        if (log.isDebugEnabled()) {
            log.debug(sql);
        }
    }

    /**
     * 日志是 debug 级别，打印 sql
     *
     * @param sql sql语句
     */
    static void logDebugSql(SQL sql) {
        logDebugSql(sql.toString());
    }

    /**
     * 读取配置文件：是否使用驼峰
     *
     * @return boolean
     */
    static boolean mapUnderscoreToCamelCase() {
        if (null == mapUnderscoreToCamelCase) {
            mapUnderscoreToCamelCase = SpringUtil.getProperty("mybatis.configuration.map-underscore-to-camel-case", Boolean.class, false);
        }
        return mapUnderscoreToCamelCase;
    }

    /**
     * 获取某实体类某个 field 的值
     *
     * @param condition 查询条件对象
     * @param fieldName field名称
     * @return Object
     */
    static Object valueOfField(Object condition, String fieldName) {
        try {
            return condition.getClass().getMethod("get" + StringUtils.capitalize(fieldName)).invoke(condition);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 驼峰转换成下划线拼接字符串
     *
     * @param str 实体类某个 field 的名字
     * @return 转换后的名称
     */
    static String getColumnName(String str) {
        if (mapUnderscoreToCamelCase()) {
            return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
        }
        return str;
    }

    /**
     * 拼接字段表达式 Field Expression Language
     *
     * @param fieldName  字段名称
     * @param annotation 字段注解
     * @return String
     */
    static String getFieldEL(String fieldName, Column annotation) {
        StringBuilder sb = new StringBuilder("#{").append(fieldName);
        if (null != annotation) {
            if (!JdbcType.UNDEFINED.equals(annotation.jdbcType())) {
                sb.append(",jdbcType=").append(annotation.jdbcType().name());
            }
            if (!UnknownTypeHandler.class.equals(annotation.typeHandler())) {
                sb.append(",typeHandler=").append(annotation.typeHandler().getCanonicalName());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 获取某个实体类所有 field
     *
     * @param clazz 某个实体类
     * @return List<Field>
     */
    static List<Field> getAllDeclaredFields(Class clazz) {
        if (classFieldMap.containsKey(clazz)) {
            return classFieldMap.get(clazz);
        }
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length < 1) {
            return Collections.emptyList();
        }
        List<Field> fieldList = Lists.newArrayList(fields);
        if (null != clazz.getSuperclass()) {
            fieldList.addAll(getAllDeclaredFields(clazz.getSuperclass()));
        }
        classFieldMap.put(clazz, fieldList);
        return fieldList;
    }

    /**
     * 拼接 where 查询条件
     *
     * @param sql       待拼接 SQL
     * @param condition 查询条件
     * @param orderBy   排序条件
     */
    static void where(SQL sql, Object condition, String orderBy) {
        if (null != condition) {
            getAllDeclaredFields(condition.getClass()).stream()
                    .filter(field -> !field.isAnnotationPresent(Ignore.class))
                    .forEach(field -> {
                        String fieldName = field.getName();
                        String columnName;
                        String fieldEL;
                        if (field.isAnnotationPresent(Column.class)) {
                            Column annotation = field.getAnnotation(Column.class);
                            columnName = annotation.column().trim();
                            fieldEL = getFieldEL("condition." + fieldName, annotation);
                        } else {
                            columnName = getColumnName(fieldName);
                            fieldEL = getFieldEL("condition." + fieldName, null);
                        }
                        Object value = valueOfField(condition, fieldName);
                        if (null != value) {
                            if (value instanceof String) {
                                if (!StringUtils.isEmpty(value) && !value.equals("%%")) {
//                                sql.WHERE(getColumnName + " like " + getFieldEL);
                                    if (fieldName.startsWith("min")) {
                                        sql.WHERE(columnName + " >= " + fieldEL);
                                    } else if (field.getName().startsWith("max")) {
                                        sql.WHERE(columnName + " <= " + fieldEL);
                                    } else if (((String) value).startsWith("%") || ((String) value).endsWith("%")) {
                                        sql.WHERE(columnName + " like " + fieldEL);
                                    } else {
                                        sql.WHERE(columnName + " = " + fieldEL);
                                    }
                                }
                            } else if (value instanceof Number
                                    || value instanceof LocalDate
                                    || value instanceof LocalDateTime) {
                                if (fieldName.startsWith("min")) {
                                    sql.WHERE(columnName + " >= " + fieldEL);
                                } else if (field.getName().startsWith("max")) {
                                    sql.WHERE(columnName + " <= " + fieldEL);
                                } else {
                                    sql.WHERE(columnName + "=" + fieldEL);
                                }
                            } else {
                                sql.WHERE(columnName + " = " + fieldEL);
                            }
                        }
                    });
        }
        if (null != orderBy && !orderBy.isEmpty()) {
            sql.ORDER_BY(orderBy);
        }
    }

    /**
     * 拼接实体类查询 SQL
     *
     * @param tableName 表名
     * @param clazz     实体类 Class 对象
     * @return SQL
     */
    static SQL selectColumnFromTable(String tableName, Class clazz) {
        SQL sql = new SQL().FROM(tableName);
        getAllDeclaredFields(clazz).forEach(field -> sql.SELECT(getColumnName(field.getName())));
        return sql;
    }

    /**
     * 拼接计数 SQL
     *
     * @param tableName 表名
     * @return SQL
     */
    static SQL countFromTable(String tableName) {
        return new SQL().SELECT("count(*)").FROM(tableName);
    }
}