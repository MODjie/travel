package com.java.travel.controller;

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

@Controller
public class UserController {
	@Resource
	private RegisterService registerService;
	@Resource
	private ExUserService exUserService;
	@Resource
	private ExprienceService exprienceService;
	/**
	 * ��ת����ҳ
	 * 
	 * @return
	 */
	@RequestMapping(value = "showHome", method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView modelAndView = new ModelAndView("home");
		//��ҳ
		PageHelper.startPage(1,5);
		//ȥ���ݿ��ѯ
		List<Exprience> currentExList = exprienceService.selectAllExprience();
		//����ѯ����Ϣ��װ��pageinfo��
		 PageInfo<Exprience> pageInfo =new PageInfo<Exprience>(currentExList);
		  System.out.println(pageInfo);
		List<Exprience> weekRankExList = null;
		ExUser currentUser = null;
		
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String nickName = (String) session.getAttribute("nickName");
		if (nickName != null) {
			currentUser = exUserService.selectByNickName(nickName);			
		} 
		modelAndView.addObject("currentUser", currentUser);
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("weekRankExList", weekRankExList);
		return modelAndView;
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
/*	@RequestMapping(value = "isLogin", method = RequestMethod.GET)
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
	}*/

	/**
	 * ͨ���ǳ��ж��Ƿ��Ѿ����ڴ��û�
	 * 
	 * @param nickName
	 * @return 1��ʾ�˺ſ��ã�-1��ʾ�û��Ѵ���
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
	 * ͨ���ֻ�����
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
	 * ��¼
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
			//session���û��ǳ�
			ExUser exUser;
			if (nickName.length()==11) {
				exUser = exUserService.selectByTelphoneNum(nickName);
			}else {
				exUser = exUserService.selectByNickName(nickName);
			}
			//���session�Ѵ��ڵ��û�������յ��û�����ͬ���򷵻�-4
			if (session.getAttribute("nickName")!=null && session.getAttribute("nickName").equals(exUser.getNICKNAME())) {
				return -4;
			}
			session.setAttribute("nickName", exUser.getNICKNAME());			
			return 1;
		} catch (UnknownAccountException ex) {// �û���û���ҵ���
			return -1;
		} catch (IncorrectCredentialsException ex) {// �û������벻ƥ�䡣
			return -2;
		} catch (AuthenticationException e) {//�����쳣
            return -3;
        }
	}
	/**
	 * �˳���¼
	 * @return
	 */
	@RequestMapping(value="logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/showHome";
	}
	
	/**
	 * ������֤���¼
	 * @param telphoneNum
	 * @return
	 *//*
	@RequestMapping(value = "codeLogin", method = RequestMethod.GET)
	@ResponseBody
	public int codeLogin(String telphoneNum) {		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(telphoneNum,"��֤��");
		try {
			subject.login(token);
			return 1;
		}  catch (Exception e) {
			return -1;
		}
	}*/
	
	/**
	 * ��ȡ������֤��
	 * @return
	 */
	@RequestMapping(value="getIdentifyCode",method=RequestMethod.GET)
	@ResponseBody
	public int getIdentifyCode(String tel) {
//		int num = IndustrySMS.execute(tel);
		return 1;
	}
	/**
	 * �޸�����
	 * @param telphoneNum
	 * @param password
	 * @return
	 */
	@RequestMapping(value="updatePassword",method=RequestMethod.PUT)
	@ResponseBody
	public int updatePassword(String telphoneNum,String password) {
		ExUser exUser = exUserService.selectByTelphoneNum(telphoneNum);
		exUser.setPASSWORD(password);
		int result = exUserService.updateByPrimaryKey(exUser);
		return result;
	}
}
