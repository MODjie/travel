package com.java.travel.serviceImpl;

import java.util.List;

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

	public int updateByPrimaryKeyWithBLOBs(Exprience record) {
		// TODO Auto-generated method stub
		return exprienceMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public List<Exprience> selectAllExprience() {
		// TODO Auto-generated method stub
		return exprienceMapper.selectAllExprience();
	}

	public List<Exprience> selectExprienceByAuthorName(String authorName,String isPublish) {
		// TODO Auto-generated method stub
		return exprienceMapper.selectExprienceByAuthorName(authorName,isPublish);
	}

	public List<Exprience> selectExprienceByType(String authorName, int typeId,String isPublish) {
		// TODO Auto-generated method stub
		return exprienceMapper.selectExprienceByType(authorName, typeId,isPublish);
	}

}
