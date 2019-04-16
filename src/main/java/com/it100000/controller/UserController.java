package com.it100000.controller;

import com.it100000.entity.User;
import com.it100000.service.UserServer;
import com.it100000.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 道一
 * @date 2019/4/15 15:55
 */
@Slf4j
@Controller
public class UserController {

    @Resource
    private UserServer userServer;

    /**
     * 功能描述：查询所有数据
     *
     * @author 道一
     * @date 2019/4/15 16:03
     */
    @RequestMapping(value = "/queryUserAll", method = RequestMethod.POST)
    @ResponseBody
    public Result queryUserAll() {
        List<User> list = userServer.queryAll();
        return new Result<>(Result.SUCCESS, list, "查询成功");
    }

    /**
     * 功能描述：根据ID查询数据
     *
     * @author 道一
     * @date 2019/4/15 16:03
     */
    @RequestMapping(value = "/queryUserById", method = RequestMethod.POST)
    @ResponseBody
    public Result queryUserById(Integer userId) {
        User user = userServer.findUserById(userId);
        return new Result<>(Result.SUCCESS, user, "查询成功");
    }

    /**
     * 功能描述：更新数据
     *
     * @author 道一
     * @date 2019/4/15 16:03
     */
    @RequestMapping(value = "/updateUserInfoById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateUserInfoById(User user) {
        Integer integer = userServer.updateUser(user);
        if (integer != null && integer != 0) {
            return new Result<>(Result.SUCCESS, null, "更新成功");
        }
        return new Result<>(Result.FAIL, null, "更新失败");
    }

    /**
     * 功能描述：根据ID删除用户
     *
     * @author 道一
     * @date 2019/4/15 16:03
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteUserById(Integer userId) {
        Integer integer = userServer.deleteUserById(userId);
        if (integer != null && integer != 0) {
            return new Result<>(Result.SUCCESS, null, "删除成功");
        }
        return new Result<>(Result.SUCCESS, null, "删除失败");
    }

}
