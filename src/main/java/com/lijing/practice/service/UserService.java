package com.lijing.practice.service;

import com.lijing.practice.exception.ServiceException;
import com.lijing.practice.model.Result;
import com.lijing.practice.pojo.User;

/**
 * Created by zhuozhuo on 2018/1/6.
 */
public interface UserService {

    User getUser(String userId) throws ServiceException;

    User setIsGiveLike(String userId, Boolean isGiveLike) throws ServiceException;

}
