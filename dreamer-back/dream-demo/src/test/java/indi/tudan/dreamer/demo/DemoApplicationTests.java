package indi.tudan.dreamer.demo;

import indi.tudan.dreamer.demo.mapper.UserMapper;
import indi.tudan.dreamer.demo.model.User;
import indi.tudan.dreamer.demo.model.UserCondition;
import indi.tudan.dreamer.mybatis.page.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        log.info("查询结果: {}", userMapper.select());
    }

    @Test
    public void selectByCondition() {
        log.info("条件查询结果: {}", userMapper.selectByCondition(User.class,
                new UserCondition()
                        .fluentSetMinId("605398903319166976")
                        .fluentSetMaxId("605399053823377408")
//                        .fluentSetName("%小蓝鲸%")
                        .fluentSetEmail("%com%"),
                "id asc"));
    }

    @Test
    public void selectPageByCondition() {
        log.info("分页查询结果: {}", userMapper.selectPageByCondition(User.class,
                new UserCondition()
                        .fluentSetMinId("605398903319166976")
                        .fluentSetMaxId("605399053823377408")
//                        .fluentSetName("%小蓝鲸%")
                        .fluentSetEmail("%com%"),
                new Page(20, 1, "id desc")));
    }

    @Test
    public void countByCondition() {
        log.info("共 {} 条", userMapper.countByCondition(new UserCondition()
                .fluentSetMinId("605398903319166976")
                .fluentSetMaxId("605399053823377408")));
    }
}