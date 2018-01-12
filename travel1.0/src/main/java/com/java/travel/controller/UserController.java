package com.java.travel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	/**
	 * 第一次访问网站跳转到主页
	 * @return
	 */
	@RequestMapping(value="showHome",method=RequestMethod.GET)
	public String showHome() {
		return "home";
	}
	
	/**
	 * 如果未登录就弹出注册窗口，否则跳转到编辑见闻界面
	 */
	/*@RequestMapping(value="write")
	public ModelAndView writeEx(String currentPage , HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		System.out.println(userName);		 
		if (userName!=null) {
			String loginRequest = "请登录";
			modelAndView.addObject("loginRequest",loginRequest);
			modelAndView.setViewName(currentPage);
		}else {
			
			modelAndView.setViewName("write_ex");
		}
		return modelAndView;
	}*/
	/**
	 * 跳转到编辑界面
	 * @return
	 */
	@RequestMapping(value="writeEx",method=RequestMethod.GET)
	public String writeEx() {	
		return "write_ex";
	}
}
