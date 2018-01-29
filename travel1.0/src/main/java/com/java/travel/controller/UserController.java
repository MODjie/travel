package com.java.travel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.travel.entity.ExUser;
import com.java.travel.service.ExUserService;
import com.java.travel.service.RegisterService;

@Controller
public class UserController {
	@Resource
	RegisterService registerService;
	@Resource
	ExUserService exUserService;
	/**
	 * ��һ�η�����վ��ת����ҳ
	 * @return
	 */
	@RequestMapping(value="showHome",method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}
		
	/**
	 * ��ת���༭����
	 * @return
	 */
	@RequestMapping(value="writeEx",method=RequestMethod.GET)
	public String writeEx() {	
		return "write_ex";
	}
	
	/**
	 * ע��
	 * @param exUser
	 * @return
	 */
	@RequestMapping(value="register", method=RequestMethod.POST)
	@ResponseBody
	public ExUser register(ExUser exUser) {
		//�����û�Ĭ������
		exUser.setROLEID(1);
		exUser.setHEADADDRESS("images/head/defaultHead.png");
		exUser.setMOOD("һ�仰�������Լ��ɣ��ñ��˸��˽���");
		exUser.setGROWTHVALUE(0);
		exUser.setTODAYVALUE(0);
		exUser.setNORMALLEVEL(1);
		exUser.setDAYVALLIMIT(1000);
		
		exUserService.insert(exUser);
		return exUser;
	}
	/**
	 * �ж��Ƿ����û���¼
	 * @param request
	 * @return
	 */
	@RequestMapping(value="isLogin",method=RequestMethod.GET)
	@ResponseBody
	public List<String> isLogin(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		List<String> list = new ArrayList<String>();
		String userName = (String) session.getAttribute("userName");
		if (userName != null) {
			list.add("�ѵ�¼");			
		}else {
			list.add("δ��¼");
		}
		return list;
	}
	/**
	 * �ж��Ƿ��Ѿ����ڴ��û�
	 * @param nickName
	 * @return 1��ʾ�˺ſ��ã�-1��ʾ�û��Ѵ���
	 */
	@RequestMapping(value="hasUser",method=RequestMethod.GET)
	@ResponseBody
	public int hasUser(String nickName) {
		ExUser exUser = exUserService.selectByNickName(nickName);
		if (exUser==null) {
			return 1;
		}else {
			return-1;
		}
		
	}
}
