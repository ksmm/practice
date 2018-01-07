package com.lijing.practice.rest;

import com.lijing.practice.exception.ServiceException;
import com.lijing.practice.model.Result;
import com.lijing.practice.pojo.User;
import com.lijing.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Created by zhuozhuo on 2018/1/6.
 */
@RestController
@RequestMapping("/")
public class UserResource {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable("id") @NotNull String id) throws ServiceException {
        return new Result.Builder<User>()
                .responseEnum(Result.ResponseEnum.OK)
                .data(userService.getUser(id))
                .builder();
    }

    @PostMapping("/{id}")
    public Result<User> set(@PathVariable("id") @NotNull String id,
                            @RequestParam(value = "isGiveLike",required = true) Boolean isGiveLike) throws ServiceException {
        System.out.println(isGiveLike);
        return new Result.Builder<User>()
                .responseEnum(Result.ResponseEnum.OK)
                .data(userService.setIsGiveLike(id, isGiveLike))
                .builder();
    }


}
