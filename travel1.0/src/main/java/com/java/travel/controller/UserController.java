package com.java.travel.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.travel.entity.ExUser;
import com.java.travel.entity.Exprience;
import com.java.travel.service.ExUserService;
import com.java.travel.service.ExprienceService;
import com.java.travel.service.RegisterService;
import com.java.travel.util.DateUtil;

@Controller
public class UserController {
	@Resource
	private RegisterService registerService;
	@Resource
	private ExUserService exUserService;
	@Resource
	private ExprienceService exprienceService;

	/**
	 * 跳转到主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "showHome", method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView modelAndView = new ModelAndView("home");
		// 分页
		PageHelper.startPage(1, 5);
		// 去数据库查询
		List<Exprience> currentExList = exprienceService.selectAllExprience();
		// 将查询的信息封装到pageinfo中
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(currentExList);
		ExUser currentUser = null;

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String nickName = (String) session.getAttribute("nickName");
		if (nickName != null) {
			currentUser = exUserService.selectByNickName(nickName);
		}
		
		//周排行数据
		List<Exprience> rankList = new ArrayList<Exprience>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String lastWeekMonday = sdf.format(DateUtil.getLastWeekMonday(date))+" 08:00:00";
		String thisWeekMonday = sdf.format(DateUtil.getThisWeekMonday(date))+" 08:00:00";
		rankList = exprienceService.weekRankExprience(thisWeekMonday, lastWeekMonday);
		
		modelAndView.addObject("currentUser", currentUser);
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("rankList", rankList);
		return modelAndView;
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

		// 获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String registerTime = sdf.format(date);
		
		// 设置用户默认属性
		exUser.setROLEID(1);
		exUser.setHEADADDRESS("images/head/defaultHead.png");
		exUser.setMOOD("一句话介绍下自己吧，让别人更了解你。。。");
		exUser.setGROWTHVALUE(0);
		exUser.setTODAYVALUE(0);
		exUser.setNORMALLEVEL(1);
		exUser.setDAYVALLIMIT(1000);
		exUser.setREGISTERTIME(registerTime);
		
		exUserService.insert(exUser);
		return exUser;
	}

	/**
	 * 跳转到编辑界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "writeEx", method = RequestMethod.GET)
	public ModelAndView writeEx() {
		ModelAndView modelAndView = new ModelAndView("write_ex");
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String nickName = (String) session.getAttribute("nickName");
		ExUser currentUser = exUserService.selectByNickName(nickName);
		modelAndView.addObject("currentUser",currentUser);
		return modelAndView;
	}
	
	/**
	 * 判断是否有用户登录
	 * 
	 * @param request
	 * @return
	 */
	/*
	 * @RequestMapping(value = "isLogin", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public List<String> isLogin(HttpServletRequest request) {
	 * HttpSession session = request.getSession(); List<String> list = new
	 * ArrayList<String>(); String userName = (String)
	 * session.getAttribute("userName"); if (userName != null) { list.add("已登录"); }
	 * else { list.add("未登录"); } return list; }
	 */

	/**
	 * 通过昵称判断是否已经存在此用户
	 * 
	 * @param nickName
	 * @return 1表示账号可用，-1表示用户已存在
	 */
	@RequestMapping(value = "hasUserByNickName", method = RequestMethod.GET)
	@ResponseBody
	public int hasUserByNickName(String nickName) {
		ExUser exUser = exUserService.selectByNickName(nickName);
		if (exUser == null) {
			return 1;
		} else {
			return -1;
		}

	}

	/**
	 * 查找手机号是否被使用
	 * 
	 * @param telphoneNum
	 * @return
	 */
	@RequestMapping(value = "hasUserByTel", method = RequestMethod.GET)
	@ResponseBody
	public int hasUserByTel(String telphoneNum) {
		ExUser exUser = exUserService.selectByTelphoneNum(telphoneNum);
		if (exUser == null) {
			return 1;
		} else {
			return -1;
		}

	}

	/**
	 * 登录
	 * 
	 * @param nickName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ResponseBody
	public int login(String nickName, String password) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		UsernamePasswordToken token = new UsernamePasswordToken(nickName, password);
		try {
			subject.login(token);
			// session绑定用户昵称
			ExUser exUser;
			if (nickName.length() == 11) {
				exUser = exUserService.selectByTelphoneNum(nickName);
			} else {
				exUser = exUserService.selectByNickName(nickName);
			}
			// 如果session已存在的用户名与接收的用户名相同，则返回-4
			if (session.getAttribute("nickName") != null
					&& session.getAttribute("nickName").equals(exUser.getNICKNAME())) {
				return -4;
			}
			session.setAttribute("nickName", exUser.getNICKNAME());
			return 1;
		} catch (UnknownAccountException ex) {// 用户名没有找到。
			return -1;
		} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配。
			return -2;
		} catch (AuthenticationException e) {// 其他异常
			return -3;
		}
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/showHome";
	}

	/**
	 * 短信验证码登录
	 * 
	 * @param telphoneNum
	 * @return
	 *//*
		 * @RequestMapping(value = "codeLogin", method = RequestMethod.GET)
		 * 
		 * @ResponseBody public int codeLogin(String telphoneNum) { Subject subject =
		 * SecurityUtils.getSubject(); UsernamePasswordToken token = new
		 * UsernamePasswordToken(telphoneNum,"验证码"); try { subject.login(token); return
		 * 1; } catch (Exception e) { return -1; } }
		 */

	/**
	 * 获取短信验证码
	 * 
	 * @return
	 */
	@RequestMapping(value = "getIdentifyCode", method = RequestMethod.GET)
	@ResponseBody
	public int getIdentifyCode(String tel) {
		// int num = IndustrySMS.execute(tel);
		return 1;
	}

	/**
	 * 忘记密码
	 * 
	 * @param telphoneNum
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "forgetPassword", method = RequestMethod.PUT)
	@ResponseBody
	public int forgetPassword(String telphoneNum, String password) {
		ExUser exUser = exUserService.selectByTelphoneNum(telphoneNum);
		exUser.setPASSWORD(password);
		int result = exUserService.updateByPrimaryKey(exUser);
		return result;
	}
}
