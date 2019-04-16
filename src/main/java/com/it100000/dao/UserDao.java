package com.it100000.dao;

import com.it100000.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 道一
 * @date 2019/4/15 15:08
 */
@Mapper
public interface UserDao {

    /**
     *
     * 功能描述：查询所有记录
     *
     * @author  道一
     * @return  返回查询结果
     * @date    2019/4/15 15:53
     */
    List<User> queryAll();

    /**
     *
     * 功能描述：查询对应记录
     *
     * @author  道一
     * @param   id 用户ID
     * @return  返回查询结果
     * @date    2019/4/15 15:53
     */
    User findUserById(@Param("id") Integer id);

    /**
     *
     * 功能描述：更新数据
     *
     * @param   user 用户实体类
     * @return  返回更新结果并且返回主键
     * @author  道一
     * @date    2019/4/15 15:53
     */
    Integer updateUser(@Param("user") User user);

    /**
     *
     * 功能描述：删除记录
     *
     * @param   id 用户ID
     * @return  返回删除条目数
     * @author  道一
     * @date    2019/4/15 15:53
     */
    Integer deleteUserById(@Param("id") Integer id);


}
