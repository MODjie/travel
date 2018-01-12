package com.java.travel.mapper;

import com.java.travel.entity.Register;

public interface RegisterMapper {
    int deleteByPrimaryKey(Integer REGISTERID);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer REGISTERID);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}