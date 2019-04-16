package com.it100000.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 道一
 * @date 2019/4/15 15:56
 */
@Setter
@Getter
@ToString
public class Result<T> implements Serializable {

    /**成功*/
    public static final int SUCCESS = 0;

    /**失败*/
    public static final int FAIL = 1;

    private int status;

    private T obj;

    private String msg;

    public Result(){
        super();
    }

    public Result(int status ,T obj,String msg){
        this.status = status;
        this.obj    = obj;
        this.msg    = msg;
    }

}
