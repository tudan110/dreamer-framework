package indi.tudan.dreamer.mybatis.builder;

import indi.tudan.dreamer.mybatis.page.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import static indi.tudan.dreamer.mybatis.builder.SqlProviderUtil.*;


/**
 * @param <T>
 * @author wangtan
 * @date 2019-07-26 17:17:52
 * @since 1.0
 */
@Slf4j
public abstract class BaseSqlProvider<T> {

    /**
     * 实体类
     */
    private Class<T> entityClass;

    /**
     * 构造时，获取实体类的 Class 对象
     */
    public BaseSqlProvider() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    /**
     * 获取表名
     *
     * @return String
     */
    protected abstract String getTableName();

    /**
     * 拼接查询 SQL
     *
     * @return String
     */
    public String select() {
        SQL sql = selectColumnFromTable(this.getTableName(), entityClass);
        logDebugSql(sql);
        return sql.toString();
    }

    /**
     * 按条件拼接查询 SQL
     *
     * @param condition 查询条件
     * @param orderBy   排序条件
     * @return String
     */
    public String selectByCondition(@Param("condition") Object condition, String orderBy) {
        SQL sql = selectColumnFromTable(this.getTableName(), entityClass);
        where(sql, condition, orderBy);
        logDebugSql(sql);
        return sql.toString();
    }

    /**
     * 拼接分页查询 SQL
     *
     * @param page 分页条件和排序条件
     * @return String
     */
    public String page(Page page) {
        return pageByCondition(null, page);
    }

    /**
     * 按条件拼接分页查询 SQL
     *
     * @param condition 查询条件
     * @param page      分页条件和排序条件
     * @return String
     */
    public String pageByCondition(@Param("condition") Object condition, Page page) {
        String orderBy = null;
        if (null != page) {
            orderBy = page.getOrderBy();
        }
        SQL sql = selectColumnFromTable(this.getTableName(), entityClass);
        where(sql, condition, orderBy);
        String sqlStr = sql.toString();
        if (null != page) {
            long limit = page.getPageSize();
            long offset = limit * (page.getPageNo() - 1);
            sqlStr += " limit " + offset + "," + limit;
        }
        logDebugSql(sqlStr);
        return sqlStr;
    }

    /**
     * 拼接计数查询 SQL
     *
     * @param param 查询条件
     * @return String
     */
    public String countByCondition(Map<String, Object> param) {
        SQL sql = countFromTable(this.getTableName());
        where(sql, param.get("condition"), null);
        logDebugSql(sql);
        return sql.toString();
    }
}