package com.java.travel.mapper;

import com.java.travel.entity.Exprience;

public interface ExprienceMapper {
    int deleteByPrimaryKey(Integer EXPRIENCEID);

    int insert(Exprience record);

    int insertSelective(Exprience record);

    Exprience selectByPrimaryKey(Integer EXPRIENCEID);

    int updateByPrimaryKeySelective(Exprience record);

    int updateByPrimaryKeyWithBLOBs(Exprience record);

    int updateByPrimaryKey(Exprience record);
}