package com.java.travel.service;

import java.util.List;

import com.java.travel.entity.ExReply;
import com.java.travel.entity.ExReplyDetail;

public interface ExReplyService {
	int deleteByPrimaryKey(Integer REPLYID);

    int insert(ExReply record);

    int insertSelective(ExReply record);

    ExReply selectByPrimaryKey(Integer REPLYID);
    
    //ͨ�����۱�Ų�ѯ�ظ�
    List<ExReplyDetail> selectReplyByCommentId(Integer COMMENTID);

    int updateByPrimaryKeySelective(ExReply record);

    int updateByPrimaryKey(ExReply record);
}
