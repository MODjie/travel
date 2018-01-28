package com.java.travel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
	
	/**
	 * ��һ�η�����վ��ת����ҳ
	 * @return
	 */
	@RequestMapping(value="showHome",method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}
	
	/**
	 * ���δ��¼�͵���ע�ᴰ�ڣ�������ת���༭���Ž���
	 */
	/*@RequestMapping(value="write")
	public ModelAndView writeEx(String currentPage , HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		System.out.println(userName);		 
		if (userName!=null) {
			String loginRequest = "���¼";
			modelAndView.addObject("loginRequest",loginRequest);
			modelAndView.setViewName(currentPage);
		}else {
			
			modelAndView.setViewName("write_ex");
		}
		return modelAndView;
	}*/
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
	 */
	@RequestMapping(value="register", method=RequestMethod.POST)
	public void register() {
		//����user��ͼ������register��user������
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
		System.out.println(userName);
		if (userName != null) {
			list.add("�ѵ�¼");			
		}else {
			list.add("δ��¼");
		}
		return list;
	}
}
