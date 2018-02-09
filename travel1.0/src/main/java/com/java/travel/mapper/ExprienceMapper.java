package com.java.travel.mapper;

import java.util.List;

import com.java.travel.entity.Exprience;

public interface ExprienceMapper {
    int deleteByPrimaryKey(Integer EXPRIENCEID);

    int insert(Exprience record);

    int insertSelective(Exprience record);

    Exprience selectByPrimaryKey(Integer EXPRIENCEID);
    
    //��ѯ���е�exprience
    List<Exprience> selectAllExprience(); 
    
    //���������ǳƺ��Ƿ񷢲���ѯexprience
    List<Exprience> selectExprienceByAuthorName(String authorName,String isPublish); 

    //���������ǳƺ����Ͳ�ѯexprience
    List<Exprience> selectExprienceByType(String authorName,int typeId,String isPublish);
    
    //��ѯ������
    List<Exprience> weekRankExprience(String thisWeekMonday,String lastWeekMonday);
    
    //�����ǳƲ�ѯ��Ʒ����
    List<Exprience> authorRankExprience(String authorName);
    int updateByPrimaryKeySelective(Exprience record);

    int updateByPrimaryKeyWithBLOBs(Exprience record);

    int updateByPrimaryKey(Exprience record);
}