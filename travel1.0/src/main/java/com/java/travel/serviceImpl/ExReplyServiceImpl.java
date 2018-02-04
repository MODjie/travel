package com.java.travel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.ExReply;
import com.java.travel.entity.ExReplyDetail;
import com.java.travel.mapper.ExReplyMapper;
import com.java.travel.service.ExReplyService;

@Service
public class ExReplyServiceImpl implements ExReplyService {

	@Resource
	ExReplyMapper exReplyMapper;
	
	public int deleteByPrimaryKey(Integer REPLYID) {
		// TODO Auto-generated method stub
		return exReplyMapper.deleteByPrimaryKey(REPLYID);
	}

	public int insert(ExReply record) {
		// TODO Auto-generated method stub
		return exReplyMapper.insert(record);
	}

	public int insertSelective(ExReply record) {
		// TODO Auto-generated method stub
		return exReplyMapper.insertSelective(record);
	}

	public ExReply selectByPrimaryKey(Integer REPLYID) {
		// TODO Auto-generated method stub
		return exReplyMapper.selectByPrimaryKey(REPLYID);
	}

	public int updateByPrimaryKeySelective(ExReply record) {
		// TODO Auto-generated method stub
		return exReplyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ExReply record) {
		// TODO Auto-generated method stub
		return exReplyMapper.updateByPrimaryKey(record);
	}

	public List<ExReplyDetail> selectReplyByCommentId(Integer COMMENTID) {
		// TODO Auto-generated method stub
		return exReplyMapper.selectReplyByCommentId(COMMENTID);
	}

}
