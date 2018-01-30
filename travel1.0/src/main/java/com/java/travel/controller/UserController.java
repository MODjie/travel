package com.java.travel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.travel.entity.ExUser;
import com.java.travel.service.ExUserService;
import com.java.travel.service.RegisterService;
import com.java.travel.util.IndustrySMS;

@Controller
public class UserController {
	@Resource
	RegisterService registerService;
	@Resource
	ExUserService exUserService;

	/**
	 * 第一次访问网站跳转到主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "showHome", method = RequestMethod.GET)
	public String showHome() {
		return "home";
	}

	/**
	 * 跳转到编辑界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "writeEx", method = RequestMethod.GET)
	public String writeEx() {
		return "write_ex";
	}

	/**
	 * 注册
	 * 
	 * @param exUser
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ExUser register(ExUser exUser) {
		// 设置用户默认属性
		exUser.setROLEID(1);
		exUser.setHEADADDRESS("images/head/defaultHead.png");
		exUser.setMOOD("一句话介绍下自己吧，让别人更了解你");
		exUser.setGROWTHVALUE(0);
		exUser.setTODAYVALUE(0);
		exUser.setNORMALLEVEL(1);
		exUser.setDAYVALLIMIT(1000);

		exUserService.insert(exUser);
		return exUser;
	}

	/**
	 * 判断是否有用户登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "isLogin", method = RequestMethod.GET)
	@ResponseBody
	public List<String> isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> list = new ArrayList<String>();
		String userName = (String) session.getAttribute("userName");
		if (userName != null) {
			list.add("已登录");
		} else {
			list.add("未登录");
		}
		return list;
	}

	/**
	 * 判断是否已经存在此用户
	 * 
	 * @param nickName
	 * @return 1表示账号可用，-1表示用户已存在
	 */
	@RequestMapping(value = "hasUser", method = RequestMethod.GET)
	@ResponseBody
	public int hasUser(String nickName) {
		ExUser exUser = exUserService.selectByNickName(nickName);
		if (exUser == null) {
			return 1;
		} else {
			return -1;
		}

	}
	/**
	 * 登录
	 * @param nickName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ResponseBody
	public int login(String nickName, String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(nickName, password);
		try {
			subject.login(token);
			return 1;
		} catch (UnknownAccountException ex) {// 用户名没有找到。
			return -1;
		} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配。
			return -2;
		} catch (Exception e) {
			return -3;
		}
	}
	/**
	 * 获取短信验证码
	 * @return
	 */
	@RequestMapping(value="getIdentifyCode",method=RequestMethod.GET)
	@ResponseBody
	public int getIdentifyCode(String tel) {
		int num = IndustrySMS.execute(tel);
		return 1;
	}
}
