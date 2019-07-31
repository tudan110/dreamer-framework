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

//        List<User> userList = userMapper.listUser();
//        List<User> userList = userMapper.listUsers();
//        List<User> userList = userMapper.select();

//        List<User> userListOrderBy = userList.stream().filter((User u) -> u.getName() == "1212").collect(Collectors.toList());
//        Collections.sort(userList, (user1, user2) -> user1.getId() - user2.getId());
//        Collections.sort(userList, Comparator.comparingInt(User::getId));
//        userList.sort(Comparator.comparing(User::getId));

//        return userList;

        return userMapper.selectPageByCondition(User.class, new UserCondition()
                        .fluentSetMinId("605398903319166976")
                        .fluentSetMaxId("605399053823377408")
//                        .fluentSetName("%小蓝鲸%")
                        .fluentSetEmail("%com%"),
                new Page(20, 1, "id desc"));
    }

    @Override
    public void addUser(User user) {
        user.setId(IdUtil.nextId());
        userMapper.addUser(user);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public void delUserById(String id) {
        userMapper.delUserById(id);
    }
}