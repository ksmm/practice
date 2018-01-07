package com.lijing.practice.service.impl;

import com.lijing.practice.exception.ServiceException;
import com.lijing.practice.model.Result;
import com.lijing.practice.pojo.User;
import com.lijing.practice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by zhuozhuo on 2018/1/6.
 */
@Service
public class UserServiceImpl implements UserService {

    private static User user = new User("123", false);

    @Override
    public User getUser(String userId) throws ServiceException{
        userId = Optional.ofNullable(userId)
                .map(id -> id)
                .orElseThrow(() -> new ServiceException(Result.ResponseEnum.BAD_REQUEST));
        if(userId.equals(user.getUserId())){
            return user;
        }
        throw new ServiceException(Result.ResponseEnum.OK.getCode(), "没有该用户");
    }

    @Override
    public User setIsGiveLike(String userId, Boolean isGiveLike) throws ServiceException {
        if(userId == null || isGiveLike==null){
            throw new ServiceException(Result.ResponseEnum.BAD_REQUEST);
        }
        if(!userId.equals(user.getUserId())){
            throw new ServiceException(Result.ResponseEnum.OK.getCode(), "没有该用户");
        }
        if(user.getIsGiveLike() == isGiveLike){
            throw new ServiceException(Result.ResponseEnum.OK.getCode(), isGiveLike ? "该用户已经点赞了" : "该用户已经踩了");
        }
        user.setIsGiveLike(isGiveLike);
        return user;
    }
}
