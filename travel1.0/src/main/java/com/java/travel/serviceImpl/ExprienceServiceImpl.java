package com.java.travel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.Exprience;
import com.java.travel.mapper.ExprienceMapper;
import com.java.travel.service.ExprienceService;

@Service
public class ExprienceServiceImpl implements ExprienceService{

	@Resource
	ExprienceMapper exprienceMapper;
	
	public int deleteByPrimaryKey(Integer EXPRIENCEID) {
		// TODO Auto-generated method stub
		return exprienceMapper.deleteByPrimaryKey(EXPRIENCEID);
	}

	public int insert(Exprience record) {
		// TODO Auto-generated method stub
		return exprienceMapper.insert(record);
	}

	public int insertSelective(Exprience record) {
		// TODO Auto-generated method stub
		return exprienceMapper.insertSelective(record);
	}

	public Exprience selectByPrimaryKey(Integer EXPRIENCEID) {
		// TODO Auto-generated method stub
		return exprienceMapper.selectByPrimaryKey(EXPRIENCEID);
	}

	public int updateByPrimaryKeySelective(Exprience record) {
		// TODO Auto-generated method stub
		return exprienceMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Exprience record) {
		// TODO Auto-generated method stub
		return exprienceMapper.updateByPrimaryKey(record);
	}

}
