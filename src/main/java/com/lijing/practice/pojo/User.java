package com.lijing.practice.pojo;

/**
 * Created by zhuozhuo on 2018/1/6.
 */
public class User {

    private String  userId;
    private Boolean isGiveLike;

    public User(String userId, Boolean isGiveLike) {
        this.userId = userId;
        this.isGiveLike = isGiveLike;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getIsGiveLike() {
        return isGiveLike;
    }

    public void setIsGiveLike(Boolean isGiveLike) {
        isGiveLike = isGiveLike;
    }
}
