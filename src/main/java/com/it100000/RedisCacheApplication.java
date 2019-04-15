package com.it100000;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 功能描述：  EnableCaching : 开启缓存
 *
 * @author  卓劲科技
 * @date    2019/4/15 14:43
 */
@RestController
@EnableCaching
@MapperScan("com.it100000.dao")
@SpringBootApplication
public class RedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

    @RequestMapping("/")
    public String toIndex(){
        return "成功";
    }

}
