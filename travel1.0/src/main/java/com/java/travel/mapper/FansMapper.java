package com.java.travel.mapper;

import com.java.travel.entity.Fans;

public interface FansMapper {
    int deleteByPrimaryKey(Integer FANSID);

    int insert(Fans record);

    int insertSelective(Fans record);

    Fans selectByPrimaryKey(Integer FANSID);

    int updateByPrimaryKeySelective(Fans record);

    int updateByPrimaryKey(Fans record);
}