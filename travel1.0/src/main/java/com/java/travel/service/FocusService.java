package com.java.travel.service;

import java.util.List;

import com.java.travel.entity.Focus;
import com.java.travel.entity.FocusDetail;

public interface FocusService {
	int deleteByPrimaryKey(Integer FOCUSID);

    //根据myfocus和myname删除关注
    int deleteFocusByName(String myFocus,String myName);
	
    int insert(Focus record);

    int insertSelective(Focus record);

    Focus selectByPrimaryKey(Integer FOCUSID);
    
  //根据用户昵称查找该用户所专注的人
    List<FocusDetail> selectByNicknmae(String nickName);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
}
