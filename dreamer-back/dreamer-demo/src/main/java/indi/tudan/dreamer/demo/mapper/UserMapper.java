package indi.tudan.dreamer.demo.mapper;

import indi.tudan.dreamer.demo.entity.User;
import indi.tudan.dreamer.demo.model.UserCondition;
import indi.tudan.dreamer.mybatis.page.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static indi.tudan.dreamer.mybatis.builder.SqlProviderConstant.*;


/**
 * @author wangtan
 * @date 2019-07-26 17:06:29
 * @since 1.0
 */
//@Mapper
//@TMapper
@Repository
public interface UserMapper {

    /* start: 普通方法 */
    @Select("select * from user")
    List<User> listUser();

    @SelectProvider(type = UserSqlProvider.class, method = "listUser")
    List<User> listUsers();

    @Insert({"insert into user(id, name, email) values(#{id}, #{name}, #{email})"})
    void addUser(User userInfo);

    @Update("update user set name = #{name}, email = #{email} where id = #{id}")
    void updateUserById(@Param("id") String id, @Param("name") String name, @Param("email") String email);

    @Delete("delete from user where id=#{id}")
    void delUserById(@Param("id") String id);
    /* end: 普通方法 */

    /* start: 使用封装的工具类（BaseSqlProvider 和 SqlProviderUtil） */
    @SelectProvider(type = UserSqlProvider.class, method = SELECT)
    List<User> select();

    @SelectProvider(type = UserSqlProvider.class, method = SELECT_BY_CONDITION)
    List<User> selectByCondition(@Param("condition") UserCondition condition, String orderBy);

    @SelectProvider(type = UserSqlProvider.class, method = PAGE)
    List<User> page(Page page);

    @SelectProvider(type = UserSqlProvider.class, method = PAGE_BY_CONDITION)
    List<User> pageByCondition(@Param("condition") UserCondition condition, Page page);

    @InsertProvider(type = UserSqlProvider.class, method = INSERT)
    int insert(User record);

    @UpdateProvider(type = UserSqlProvider.class, method = UPDATE_BY_PRIMARY_KEY)
    int updateByPrimaryKey(User record);

    @UpdateProvider(type = UserSqlProvider.class, method = DELETE_BY_CONDITION)
    int deleteByCondition(@Param("condition") UserCondition condition);

    @SelectProvider(type = UserSqlProvider.class, method = COUNT_BY_CONDITION)
    long countByCondition(@Param("condition") UserCondition condition);
    /* end: 使用封装的工具类（BaseSqlProvider 和 SqlProviderUtil） */
}