package com.java.travel.mapper;

import com.java.travel.entity.Focus;

public interface FocusMapper {
    int deleteByPrimaryKey(Integer FOCUSID);

    int insert(Focus record);

    int insertSelective(Focus record);

    Focus selectByPrimaryKey(Integer FOCUSID);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
}