package com.java.travel.service;

import com.java.travel.entity.Register;

public interface RegisterService {
	 int deleteByPrimaryKey(Short REGISTERID);

	    int insert(Register record);

	    int insertSelective(Register record);

	    Register selectByPrimaryKey(Short REGISTERID);

	    int updateByPrimaryKeySelective(Register record);

	    int updateByPrimaryKey(Register record);
}
