package indi.tudan.dreamer.demo.service;


import indi.tudan.dreamer.demo.entity.User;

import java.util.List;

/**
 * 用户业务接口
 *
 * @author wangtan
 * @date 2019-07-26 10:42:49
 * @since 1.0
 */
public interface UserService {

    List<User> listUsers();

    void addUser(User user);

    void updateUserById(User user);

    void delUserById(String id);
}