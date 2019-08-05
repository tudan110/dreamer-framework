package indi.tudan.dreamer.demo.service.impl;

import indi.tudan.dreamer.core.utils.Id.IdUtil;
import indi.tudan.dreamer.demo.entity.User;
import indi.tudan.dreamer.demo.mapper.UserMapper;
import indi.tudan.dreamer.demo.model.UserCondition;
import indi.tudan.dreamer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户业务类
 *
 * @author wangtan
 * @date 2019-07-26 10:43:11
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers() {
//        return userMapper.page(new Page(1, 20, "id asc"));
        return userMapper.select();
    }

    @Override
    public void addUser(User user) {
//        user.setId(IdUtil.nextId());
//        userMapper.addUser(user);
        userMapper.insert((User) user.fluentSetId(IdUtil.nextId())
                .fluentSetCreateUser("default")
                .fluentSetCreateTime(LocalDateTime.now()));
    }

    @Override
    public void updateUserById(User user) {
//        userMapper.updateUserById(user.getId(), user.getName(), user.getEmail());
        userMapper.updateByPrimaryKey((User) user
                .fluentSetUpdateUser("default")
                .fluentSetUpdateTime(LocalDateTime.now()));
    }

    @Override
    public void delUserById(String id) {
//        userMapper.delUserById(id);
        userMapper.deleteByCondition(new UserCondition().fluentSetId(id));
    }
}