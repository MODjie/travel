package com.java.travel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.Register;
import com.java.travel.mapper.RegisterMapper;
import com.java.travel.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Resource
	private RegisterMapper registerMapper;
	
	public int deleteByPrimaryKey(Integer REGISTERID) {
		// TODO Auto-generated method stub		
		return registerMapper.deleteByPrimaryKey(REGISTERID);
	}

	public int insert(Register record) {
		// TODO Auto-generated method stub
		return registerMapper.insert(record);
	}

	public int insertSelective(Register record) {
		// TODO Auto-generated method stub
		return registerMapper.insertSelective(record);
	}

	public Register selectByPrimaryKey(Integer REGISTERID) {
		// TODO Auto-generated method stub
		return registerMapper.selectByPrimaryKey(REGISTERID);
	}

	public int updateByPrimaryKeySelective(Register record) {
		// TODO Auto-generated method stub
		return registerMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Register record) {
		// TODO Auto-generated method stub
		return registerMapper.updateByPrimaryKey(record);
	}

}
