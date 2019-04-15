package com.it100000.service;

import com.it100000.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 卓劲科技
 * @date 2019/4/15 15:10
 */
@Service
public interface UserServer {

    /**
     *
     * 功能描述：查询所有
     *
     * @author  卓劲科技
     * @date    2019/4/15 15:12
     */
    List<User> queryAll();

    /**
     *
     * 功能描述：根据ID查询
     *
     * @author  卓劲科技
     * @date    2019/4/15 15:12
     */
    User findUserById(Integer id);

    /**
     *
     * 功能描述：更新
     *
     * @author  卓劲科技
     * @date    2019/4/15 15:12
     */
    Integer updateUser(User user);

    /**
     *
     * 功能描述：删除
     *
     * @author  卓劲科技
     * @date    2019/4/15 15:12
     */
    Integer deleteUserById(int id);

}
