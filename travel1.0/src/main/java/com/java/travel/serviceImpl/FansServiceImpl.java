package com.java.travel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.Fans;
import com.java.travel.mapper.FansMapper;
import com.java.travel.service.FansService;

@Service
public class FansServiceImpl implements FansService {

	@Resource
	private FansMapper fansMapper;
	
	public int deleteByPrimaryKey(Integer FANSID) {
		// TODO Auto-generated method stub
		return fansMapper.deleteByPrimaryKey(FANSID);
	}

	public int insert(Fans record) {
		// TODO Auto-generated method stub
		return fansMapper.insert(record);
	}

	public int insertSelective(Fans record) {
		// TODO Auto-generated method stub
		return fansMapper.insertSelective(record);
	}

	public Fans selectByPrimaryKey(Integer FANSID) {
		// TODO Auto-generated method stub
		return fansMapper.selectByPrimaryKey(FANSID);
	}

	public int updateByPrimaryKeySelective(Fans record) {
		// TODO Auto-generated method stub
		return fansMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Fans record) {
		// TODO Auto-generated method stub
		return fansMapper.updateByPrimaryKey(record);
	}

	

}
