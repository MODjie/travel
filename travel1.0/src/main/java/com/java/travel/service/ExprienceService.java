package com.java.travel.service;

import com.java.travel.entity.Exprience;

public interface ExprienceService {
	int deleteByPrimaryKey(Integer EXPRIENCEID);

    int insert(Exprience record);

    int insertSelective(Exprience record);

    Exprience selectByPrimaryKey(Integer EXPRIENCEID);

    int updateByPrimaryKeySelective(Exprience record);

    int updateByPrimaryKey(Exprience record);
}
