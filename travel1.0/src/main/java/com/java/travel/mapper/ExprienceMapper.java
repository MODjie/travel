package com.java.travel.mapper;

import java.util.List;

import com.java.travel.entity.Exprience;

public interface ExprienceMapper {
    int deleteByPrimaryKey(Integer EXPRIENCEID);

    int insert(Exprience record);

    int insertSelective(Exprience record);

    Exprience selectByPrimaryKey(Integer EXPRIENCEID);
    
    //查询所有的exprience
    List<Exprience> selectAllExprience(); 
    
    //根据作者昵称和是否发布查询exprience
    List<Exprience> selectExprienceByAuthorName(String authorName,String isPublish); 

    //根据作者昵称和类型查询exprience
    List<Exprience> selectExprienceByType(String authorName,int typeId,String isPublish);
    
    //根据作者昵称和类型查询exprience
    List<Exprience> weekRankExprience(String thisWeekMonday,String lastWeekMonday);
    
    int updateByPrimaryKeySelective(Exprience record);

    int updateByPrimaryKeyWithBLOBs(Exprience record);

    int updateByPrimaryKey(Exprience record);
}