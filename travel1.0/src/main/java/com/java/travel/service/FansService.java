package com.java.travel.service;

import java.util.List;

import com.java.travel.entity.Fans;
import com.java.travel.entity.FansDetail;

public interface FansService {
	//根据myFansName和myname删除粉丝
    int deleteFansByName(String myFans,String myName);
    
	int deleteByPrimaryKey(Integer FANSID);

    int insert(Fans record);

    int insertSelective(Fans record);

    Fans selectByPrimaryKey(Integer FANSID);
    
    //根据用户昵称查找该用户的粉丝
    List<FansDetail> selectByNicknmae(String nickName);

    int updateByPrimaryKeySelective(Fans record);

    int updateByPrimaryKey(Fans record);
}
