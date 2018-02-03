package com.java.travel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.ExComment;
import com.java.travel.mapper.ExCommentMapper;
import com.java.travel.service.ExCommentService;

@Service
public class ExCommentServiceImpl implements ExCommentService {
	
	@Resource
	ExCommentMapper exCommentMapper;

	public int deleteByPrimaryKey(int COMMENTID) {
		// TODO Auto-generated method stub
		return exCommentMapper.deleteByPrimaryKey(COMMENTID);
	}

	public int insert(ExComment record) {
		// TODO Auto-generated method stub
		return exCommentMapper.insert(record);
	}

	public int insertSelective(ExComment record) {
		// TODO Auto-generated method stub
		return exCommentMapper.insertSelective(record);
	}

	public ExComment selectByPrimaryKey(int COMMENTID) {
		// TODO Auto-generated method stub
		return exCommentMapper.selectByPrimaryKey(COMMENTID);
	}

	public int updateByPrimaryKeySelective(ExComment record) {
		// TODO Auto-generated method stub
		return exCommentMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ExComment record) {
		// TODO Auto-generated method stub
		return exCommentMapper.updateByPrimaryKey(record);
	}

	public List<ExComment> selectCommentsByExid(int exprienceId) {
		// TODO Auto-generated method stub
		return exCommentMapper.selectCommentsByExid(exprienceId);
	}
	

}
