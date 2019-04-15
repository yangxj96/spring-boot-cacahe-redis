package com.it100000.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author 卓劲科技
 * @date 2019/4/15 15:06
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    public User(){
        super();
    }

    public User(Integer id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

}
