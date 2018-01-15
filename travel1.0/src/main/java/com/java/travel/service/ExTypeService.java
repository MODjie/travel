package com.java.travel.service;

import com.java.travel.entity.Extype;

public interface ExTypeService {
	int deleteByPrimaryKey(Integer EXTYPEID);

    int insert(Extype record);

    int insertSelective(Extype record);

    Extype selectByPrimaryKey(Integer EXTYPEID);

    Extype selectByName(String typeName);
    
    int updateByPrimaryKeySelective(Extype record);

    int updateByPrimaryKey(Extype record); 
}
