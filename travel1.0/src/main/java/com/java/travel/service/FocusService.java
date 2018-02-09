package com.java.travel.service;

import com.java.travel.entity.Focus;

public interface FocusService {
	int deleteByPrimaryKey(Integer FOCUSID);

    int insert(Focus record);

    int insertSelective(Focus record);

    Focus selectByPrimaryKey(Integer FOCUSID);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
}
