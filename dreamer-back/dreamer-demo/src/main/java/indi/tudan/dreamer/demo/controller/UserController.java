package indi.tudan.dreamer.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import indi.tudan.dreamer.demo.model.User;
import indi.tudan.dreamer.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangtan
 * @date 2019-07-26 17:06:41
 * @since 1.0
 */
@Api("用户API")
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    /*@ApiOperation("查询用户")
    @GetMapping("/user")
    public List<User> listUser() {
        log.info("查询所有用户");
//        PropertiesUtils.getCommonYml("custom.str");
//        env.getProperty("custom.str");
        return userService.listUsers();
    }*/

    @ApiOperation("分页查询用户")
    @GetMapping("/user")
    public PageInfo<User> listUser(@RequestParam(value = "pageNum") int pageNum,
                                   @RequestParam(value = "pageSize") int pageSize
            /*@RequestBody JSONObject param*/) {
        log.info("分页查询用户");
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.listUsers();
        return new PageInfo<User>(users);
    }

    @ApiOperation("增加用户")
    @PostMapping("/user")
    public void addUser(User user) {
        log.info("新增一位用户");
        userService.addUser(user);
    }

    @ApiOperation("修改用户")
    @PutMapping("/user")
    public void updateUser(User user) {
        log.info("更新一位用户");
        userService.updateUserById(user);
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "用户编号", required = true, dataType = "Integer")
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam(value = "id") String id) {
        log.info("删除一位用户");
        userService.delUserById(id);
    }
}