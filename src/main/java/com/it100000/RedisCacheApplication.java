package com.it100000;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 功能描述：  EnableCaching : 开启缓存
 *
 * @author  道一
 * @date    2019/4/15 14:43
 */
@RestController
@MapperScan("com.it100000.dao")
@SpringBootApplication
public class RedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

    /**
     *
     * 功能描述：用于测试下是否正常启动
     *
     * @author  卓劲科技
     * @date    2019/4/16 10:30
     */
    @RequestMapping("/")
    public String toIndex(){
        return "成功";
    }

}
