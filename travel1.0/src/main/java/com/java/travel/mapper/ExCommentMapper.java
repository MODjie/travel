package com.java.travel.mapper;

import java.util.List;

import com.java.travel.entity.ExComment;
import com.java.travel.entity.ExCommentDetail;

public interface ExCommentMapper {
    int deleteByPrimaryKey(Integer COMMENTID);

    int insert(ExComment record);

    int insertSelective(ExComment record);

    ExComment selectByPrimaryKey(Integer COMMENTID);
    
  //���ݼ���id��������
    List<ExCommentDetail> selectCommentsByExid(int exprienceId);

    int updateByPrimaryKeySelective(ExComment record);

    int updateByPrimaryKey(ExComment record);
}