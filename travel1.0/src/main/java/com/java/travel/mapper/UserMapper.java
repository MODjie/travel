package com.java.travel.mapper;

import com.java.travel.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Short USERID);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Short USERID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}