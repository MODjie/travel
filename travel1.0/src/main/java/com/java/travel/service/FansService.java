package com.java.travel.service;

import java.util.List;

import com.java.travel.entity.Fans;
import com.java.travel.entity.FansDetail;

public interface FansService {
	//����myFansName��mynameɾ����˿
    int deleteFansByName(String myFans,String myName);
    
	int deleteByPrimaryKey(Integer FANSID);

    int insert(Fans record);

    int insertSelective(Fans record);

    Fans selectByPrimaryKey(Integer FANSID);
    
    //�����û��ǳƲ��Ҹ��û��ķ�˿
    List<FansDetail> selectByNicknmae(String nickName);

    int updateByPrimaryKeySelective(Fans record);

    int updateByPrimaryKey(Fans record);
}
