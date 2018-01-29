package com.java.travel.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.travel.entity.ExUser;
import com.java.travel.mapper.ExUserMapper;
import com.java.travel.service.ExUserService;

@Service
public class ExUserServiceImpl implements ExUserService {

	@Resource
	private ExUserMapper exUserMapper;
	
	public int deleteByPrimaryKey(Integer USERID) {
		// TODO Auto-generated method stub
		return exUserMapper.deleteByPrimaryKey(USERID);
	}

	public int insert(ExUser record) {
		// TODO Auto-generated method stub
		return exUserMapper.insert(record);
	}

	public int insertSelective(ExUser record) {
		// TODO Auto-generated method stub
		return exUserMapper.insertSelective(record);
	}

	public ExUser selectByPrimaryKey(Integer USERID) {
		// TODO Auto-generated method stub
		return exUserMapper.selectByPrimaryKey(USERID);
	}

	public int updateByPrimaryKeySelective(ExUser record) {
		// TODO Auto-generated method stub
		return exUserMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ExUser record) {
		// TODO Auto-generated method stub
		return exUserMapper.updateByPrimaryKey(record);
	}

	public ExUser selectByNickName(String nickName) {
		// TODO Auto-generated method stub
		return exUserMapper.selectByNickName(nickName);
	}

}
