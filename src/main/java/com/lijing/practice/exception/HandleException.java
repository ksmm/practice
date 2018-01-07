package com.lijing.practice.exception;

import com.lijing.practice.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuozhuo on 2018/1/6.
 */
@ControllerAdvice
public class HandleException {

    private final static Logger logger = LoggerFactory.getLogger(HandleException.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        e.printStackTrace();
        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            return new Result.Builder()
                    .code(serviceException.getCode())
                    .msg(serviceException.getMessage())
                    .builder();
        }
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return new Result.Builder()
                    .responseEnum(Result.ResponseEnum.NOT_FOUND)
                    .builder();
        }

        return new Result.Builder()
                .responseEnum(Result.ResponseEnum.SERVICE_UNAVAILABLE)
                .builder();
    }

}
