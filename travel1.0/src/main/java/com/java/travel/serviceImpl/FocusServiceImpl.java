package com.java.travel.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.Focus;
import com.java.travel.entity.FocusDetail;
import com.java.travel.mapper.FocusMapper;
import com.java.travel.service.FocusService;

@Service
public class FocusServiceImpl implements FocusService {

	@Resource
	private FocusMapper focusMapper;
	
	public int deleteByPrimaryKey(Integer FOCUSID) {
		// TODO Auto-generated method stub
		return focusMapper.deleteByPrimaryKey(FOCUSID);
	}

	public int insert(Focus record) {
		// TODO Auto-generated method stub
		return focusMapper.insert(record);
	}

	public int insertSelective(Focus record) {
		// TODO Auto-generated method stub
		return focusMapper.insertSelective(record);
	}

	public Focus selectByPrimaryKey(Integer FOCUSID) {
		// TODO Auto-generated method stub
		return focusMapper.selectByPrimaryKey(FOCUSID);
	}

	public int updateByPrimaryKeySelective(Focus record) {
		// TODO Auto-generated method stub
		return focusMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Focus record) {
		// TODO Auto-generated method stub
		return focusMapper.updateByPrimaryKey(record);
	}

	public List<FocusDetail> selectByNicknmae(String nickName) {
		// TODO Auto-generated method stub
		return focusMapper.selectByNicknmae(nickName);
	}

}
