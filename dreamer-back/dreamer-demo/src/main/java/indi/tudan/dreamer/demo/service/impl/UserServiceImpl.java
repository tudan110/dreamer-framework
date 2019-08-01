package indi.tudan.dreamer.demo.service.impl;

import indi.tudan.dreamer.core.utils.Id.IdUtil;
import indi.tudan.dreamer.demo.mapper.UserMapper;
import indi.tudan.dreamer.demo.model.User;
import indi.tudan.dreamer.demo.model.UserCondition;
import indi.tudan.dreamer.demo.service.UserService;
import indi.tudan.dreamer.mybatis.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.page(new Page(1, 20, "id asc"));
    }

    @Override
    public void addUser(User user) {
//        user.setId(IdUtil.nextId());
//        userMapper.addUser(user);
        userMapper.insert(user.fluentSetId(IdUtil.nextId()));
    }

    @Override
    public void updateUserById(User user) {
//        userMapper.updateUserById(user.getId(), user.getName(), user.getEmail());
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delUserById(String id) {
//        userMapper.delUserById(id);
        userMapper.deleteByCondition(User.class, new UserCondition().fluentSetId(id));
    }
}