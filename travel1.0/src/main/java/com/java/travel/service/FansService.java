package com.java.travel.service;

import com.java.travel.entity.Fans;

public interface FansService {
	int deleteByPrimaryKey(Integer FANSID);

    int insert(Fans record);

    int insertSelective(Fans record);

    Fans selectByPrimaryKey(Integer FANSID);

    int updateByPrimaryKeySelective(Fans record);

    int updateByPrimaryKey(Fans record);
}
