package com.java.travel.service;

import com.java.travel.entity.ExUser;

public interface ExUserService {
	int deleteByPrimaryKey(Integer USERID);

    int insert(ExUser record);

    int insertSelective(ExUser record);

    ExUser selectByPrimaryKey(Integer USERID);
    
    //通过昵称查找用户
    ExUser selectByNickName(String nickName);

    int updateByPrimaryKeySelective(ExUser record);

    int updateByPrimaryKey(ExUser record);
}
