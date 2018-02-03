package com.java.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.travel.entity.ExComment;

public interface ExCommentService {
	int deleteByPrimaryKey(int COMMENTID);

	int insert(ExComment record);

	int insertSelective(ExComment record);

	ExComment selectByPrimaryKey(int COMMENTID);

	//根据见闻id查找评论
	List<ExComment> selectCommentsByExid(int exprienceId);

	int updateByPrimaryKeySelective(ExComment record);

	int updateByPrimaryKey(ExComment record);
}
