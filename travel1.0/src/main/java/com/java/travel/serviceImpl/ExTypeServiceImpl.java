package com.java.travel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.Extype;
import com.java.travel.mapper.ExtypeMapper;
import com.java.travel.service.ExTypeService;

@Service
public class ExTypeServiceImpl implements ExTypeService{
	
	@Resource
	ExtypeMapper extypeMapper;
	
	public int deleteByPrimaryKey(Integer EXTYPEID) {
		// TODO Auto-generated method stub
		return extypeMapper.deleteByPrimaryKey(EXTYPEID);
	}

	public int insert(Extype record) {
		// TODO Auto-generated method stub
		return extypeMapper.insert(record);
	}

	public int insertSelective(Extype record) {
		// TODO Auto-generated method stub
		return extypeMapper.insertSelective(record);
	}

	public Extype selectByPrimaryKey(Integer EXTYPEID) {
		// TODO Auto-generated method stub
		return extypeMapper.selectByPrimaryKey(EXTYPEID);
	}

	public Extype selectByName(String typeName) {
		// TODO Auto-generated method stub
		System.out.println(extypeMapper.selectByName(typeName));
		return extypeMapper.selectByName(typeName);
	}

	public int updateByPrimaryKeySelective(Extype record) {
		// TODO Auto-generated method stub
		return extypeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Extype record) {
		// TODO Auto-generated method stub
		return extypeMapper.updateByPrimaryKey(record);
	}

}
