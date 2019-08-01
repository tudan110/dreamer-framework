package indi.tudan.dreamer.mybatis.builder;

/**
 * SqlProvider 常量
 *
 * @author wangtan
 * @date 2019-07-30 15:20:41
 * @since 1.0
 */
public class SqlProviderConstant {

    /**
     * 查询方法名称
     */
    public static final String SELECT = "select";

    /**
     * 按条件查询方法名称
     */
    public static final String SELECT_BY_CONDITION = "selectByCondition";

    /**
     * 分页查询方法名称
     */
    public static final String PAGE = "page";

    /**
     * 按条件分页查询方法名称
     */
    public static final String PAGE_BY_CONDITION = "pageByCondition";

    /**
     * 插入方法名称
     */
    public static final String INSERT = "insert";

    /**
     * 按主键更新方法名称
     */
    public static final String UPDATE_BY_PRIMARY_KEY = "updateByPrimaryKey";

    /**
     * 按条件删除方法名称
     */
    public static final String DELETE_BY_CONDITION = "deleteByCondition";

    /**
     * 按条件计数方法名称
     */
    public static final String COUNT_BY_CONDITION = "countByCondition";

}