package com.lijing.practice.exception;

import com.lijing.practice.model.Result;

/**
 * Created by zhuozhuo on 2018/1/6.
 */
public class ServiceException extends RuntimeException{

    private Integer code;

    public ServiceException() {
        super();
    }

    public ServiceException(Result.ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.code = responseEnum.getCode();
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
