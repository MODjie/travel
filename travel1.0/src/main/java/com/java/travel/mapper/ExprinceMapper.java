package com.java.travel.mapper;

import com.java.travel.entity.Exprince;

public interface ExprinceMapper {
    int deleteByPrimaryKey(Short EXPRIENCEID);

    int insert(Exprince record);

    int insertSelective(Exprince record);

    Exprince selectByPrimaryKey(Short EXPRIENCEID);

    int updateByPrimaryKeySelective(Exprince record);

    int updateByPrimaryKey(Exprince record);
}