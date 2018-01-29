package com.java.travel.mapper;

import com.java.travel.entity.ExUser;

public interface ExUserMapper {
    int deleteByPrimaryKey(Integer USERID);

    int insert(ExUser record);

    int insertSelective(ExUser record);

    ExUser selectByPrimaryKey(Integer USERID);
    
    //ͨ���ǳƲ����û�
    ExUser selectByNickName(String nickName);

    int updateByPrimaryKeySelective(ExUser record);

    int updateByPrimaryKey(ExUser record);
}