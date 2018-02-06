package com.java.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.travel.entity.Exprience;

public interface ExprienceService {
	int deleteByPrimaryKey(Integer EXPRIENCEID);

    int insert(Exprience record);

    int insertSelective(Exprience record);

    Exprience selectByPrimaryKey(Integer EXPRIENCEID);
    
  //查询所有的exprience
    List<Exprience> selectAllExprience(); 
    
  //根据作者昵称查询exprience
    List<Exprience> selectExprienceByAuthorName(String authorName); 

    int updateByPrimaryKeySelective(Exprience record);

    int updateByPrimaryKeyWithBLOBs(Exprience record);

    int updateByPrimaryKey(Exprience record);
}
