package indi.tudan.dreamer.demo.mapper;

import indi.tudan.dreamer.demo.model.User;
import indi.tudan.dreamer.mybatis.builder.BaseSqlProvider;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author wangtan
 * @date 2019-07-26 17:05:50
 * @since 1.0
 */
public class UserSqlProvider extends BaseSqlProvider<User> {

    @Override
    protected String getTableName() {
        return "user";
    }

    public String listUser() {
        return new SQL() {{
            SELECT("*");
            FROM("user");
        }}.toString();
    }
}