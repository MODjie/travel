package com.java.travel.mapper;

import com.java.travel.entity.ClobTest;

public interface ClobTestMapper {
    int insert(ClobTest record);

    int insertSelective(ClobTest record);
}