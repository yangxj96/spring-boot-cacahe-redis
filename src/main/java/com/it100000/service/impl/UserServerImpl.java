package com.it100000.service.impl;

import com.it100000.config.RedisConfig;
import com.it100000.dao.UserDao;
import com.it100000.entity.User;
import com.it100000.service.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 卓劲科技
 * @date 2019/4/15 15:13
 */
@Slf4j
@Service
public class UserServerImpl implements UserServer {

    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate<String,User> redisTemplate;

    /**
     * 功能描述：查询所有
     *
     * @author 卓劲科技
     * @date 2019/4/15 15:12
     */
    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    /**
     * 功能描述：根据ID查询
     *
     * @author 卓劲科技
     * @date 2019/4/15 15:12
     */
    @Override
    public User findUserById(Integer id) {
        // 设置查询的key
        String key = RedisConfig.KEY_PREFIX + id;
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey(key);
        User user;
        if (hasKey !=null && hasKey){
            log.info("=================================");
            log.info("       从Redis中读取的数据         ");
            log.info("=================================");
            user = valueOperations.get(key);
        } else {
            log.info("=================================");
            log.info("       从Mysql中读取的数据         ");
            log.info("=================================");
            user = userDao.findUserById(id);
            // 把查到的数据写入缓存中
            valueOperations.set(key,user,3, TimeUnit.HOURS);
            log.info("=================================");
            log.info("     在Redis中加入新的缓存        ");
            log.info("=================================");
        }
        return user;
    }

    /**
     * 功能描述：更新
     *
     * @author 卓劲科技
     * @date 2019/4/15 15:12
     */
    @Override
    public Integer updateUser(User user) {
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();

        // 更新数据
        int result = userDao.updateUser(user);

        if (result != 0){
            // 删除原来的缓存 然后插入新的缓存

            // 0 准备工作
            String key = RedisConfig.KEY_PREFIX + user.getId();
            Boolean hasKey = redisTemplate.hasKey(key);

            // 1 删除缓存
            if (hasKey!=null && hasKey){
                redisTemplate.delete(key);
                log.info("=================================");
                log.info("         从Redis中删除key         ");
                log.info("=================================");
            }
            // 2 插入新的缓存

            user = userDao.findUserById(user.getId());
            if (user != null){
                valueOperations.set(key,user,3, TimeUnit.HOURS);
                log.info("=================================");
                log.info("     在Redis中加入新的缓存        ");
                log.info("=================================");
            }
        }
        return result;
    }

    /**
     * 功能描述：删除
     *
     * @author 卓劲科技
     * @date 2019/4/15 15:12
     */
    @Override
    public Integer deleteUserById(int id) {
        Integer result = userDao.deleteUserById(id);
        String key = RedisConfig.KEY_PREFIX + id;
        if (result !=null && result != 0) {
            Boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey!=null && hasKey) {
                redisTemplate.delete(key);
                log.info("=================================");
                log.info("       从Redis中删除了缓存         ");
                log.info("=================================");
            }
        }
        return result;
    }
}
