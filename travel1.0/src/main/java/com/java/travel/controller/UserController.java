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
	 * ��һ�η�����վ��ת����ҳ
	 * 
	 * @return
	 */
	@RequestMapping(value = "showHome", method = RequestMethod.GET)
	public String showHome() {
		return "home";
	}

	/**
	 * ��ת���༭����
	 * 
	 * @return
	 */
	@RequestMapping(value = "writeEx", method = RequestMethod.GET)
	public String writeEx() {
		return "write_ex";
	}

	/**
	 * ע��
	 * 
	 * @param exUser
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ExUser register(ExUser exUser) {
		// �����û�Ĭ������
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
			list.add("�ѵ�¼");
		} else {
			list.add("δ��¼");
		}
		return list;
	}

	/**
	 * �ж��Ƿ��Ѿ����ڴ��û�
	 * 
	 * @param nickName
	 * @return 1��ʾ�˺ſ��ã�-1��ʾ�û��Ѵ���
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
	 * ��¼
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
		} catch (UnknownAccountException ex) {// �û���û���ҵ���
			return -1;
		} catch (IncorrectCredentialsException ex) {// �û������벻ƥ�䡣
			return -2;
		} catch (Exception e) {
			return -3;
		}
	}
	/**
	 * ��ȡ������֤��
	 * @return
	 */
	@RequestMapping(value="getIdentifyCode",method=RequestMethod.GET)
	@ResponseBody
	public int getIdentifyCode(String tel) {
		int num = IndustrySMS.execute(tel);
		return 1;
	}
}
