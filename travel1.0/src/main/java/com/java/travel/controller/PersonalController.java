package com.java.travel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.travel.entity.ExUser;
import com.java.travel.entity.Exprience;
import com.java.travel.service.ExUserService;
import com.java.travel.service.ExprienceService;
import com.java.travel.util.MyFileUploadUtil;

@Controller
public class PersonalController {

	@Resource
	private ExUserService exUserService;
	@Resource
	private ExprienceService exprienceService;

	/**
	 * ��ת������������ҳ
	 * 
	 * @return
	 */
	@RequestMapping(value = "personal", method = RequestMethod.GET)
	public ModelAndView personal() {
		ModelAndView modelAndView = new ModelAndView("personal");
		ExUser currentUser = getCurrentUser();
		String currentTime = getCurrentTime();
		int totalDay = getTotalDay(currentTime, currentUser.getREGISTERTIME());
		;
		modelAndView.addObject("currentUser", currentUser);
		modelAndView.addObject("currentTime", currentTime);
		modelAndView.addObject("totalDay", totalDay);
		return modelAndView;
	}

	/**
	 * �ϴ�ͷ��
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "uploadHead", method = RequestMethod.POST)
	@ResponseBody
	public ExUser updateHead(HttpServletRequest request, @RequestParam MultipartFile myHead) {

		MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);

		String fileName = uploadUtil.getRandomName(myHead);
		String savePath = uploadUtil.getTargetPath("/images/userhead/", fileName);
		uploadUtil.upload(myHead, savePath);
		String readPath = uploadUtil.getReadPath("/images/userhead/", fileName);

		// �޸��û�ͷ��
		ExUser currentUser = getCurrentUser();
		currentUser.setHEADADDRESS(readPath);
		exUserService.updateByPrimaryKey(currentUser);

		return currentUser;
	}

	/**
	 * �޸ĸ���ǩ��
	 * 
	 * @param moodText
	 * @return
	 */
	@RequestMapping(value = "updataMood", method = RequestMethod.PUT)
	@ResponseBody
	public int updateMood(String moodText) {
		ExUser currentUser = getCurrentUser();
		currentUser.setMOOD(moodText);
		int successFlag = exUserService.updateByPrimaryKey(currentUser);
		return successFlag;
	}

	/**
	 * ��ת���޸���Ϣ����
	 * 
	 * @return
	 */
	@RequestMapping(value = "toUserInfo", method = RequestMethod.GET)
	public ModelAndView toUserInfo() {
		ModelAndView modelAndView = new ModelAndView("userinfo");
		ExUser currentUser = getCurrentUser();
		modelAndView.addObject("currentUser", currentUser);
		return modelAndView;
	}

	/**
	 * �޸���Ϣ
	 * 
	 * @param exUser
	 * @return
	 */
	@RequestMapping(value = "updateUserInfo", method = RequestMethod.PUT)
	@ResponseBody
	public ExUser updateUserInfo(ExUser exUser) {
		ExUser currentUser = getCurrentUser();
		currentUser.setAGE(exUser.getAGE());
		currentUser.setSEX(exUser.getSEX());
		currentUser.setPROVINCE(exUser.getPROVINCE());
		currentUser.setCITY(exUser.getCITY());
		currentUser.setCOUNTY(exUser.getCOUNTY());
		currentUser.setEMAIL(exUser.getEMAIL());

		exUserService.updateByPrimaryKey(currentUser);
		return currentUser;
	}

	/**
	 * �޸�����
	 * 
	 * @param PASSWORD
	 * @return
	 */
	@RequestMapping(value = "updatePassword", method = RequestMethod.PUT)
	@ResponseBody
	public int updatePassword(String PASSWORD) {
		ExUser currentUser = getCurrentUser();
		currentUser.setPASSWORD(PASSWORD);
		int succesFlag = exUserService.updateByPrimaryKey(currentUser);
		return succesFlag;
	}

	/**
	 * ��ת�����Ź���
	 * 
	 * @return
	 */
	@RequestMapping(value = "exprienceList", method = RequestMethod.GET)
	public ModelAndView exprienceList() {
		ModelAndView modelAndView = new ModelAndView("exprienceList");
		ExUser currentUser = getCurrentUser();
		modelAndView.addObject("currentUser", currentUser);

		PageHelper.startPage(1, 6);
		List<Exprience> myExpriences = exprienceService.selectExprienceByAuthorName(currentUser.getNICKNAME());
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(myExpriences);
		modelAndView.addObject("pageInfo", pageInfo);
		return modelAndView;
	}
	/**
	 * ��̬�����ҵ�ȫ������
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "getMyAfterLoadEx", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Exprience> getMyAfterLoadEx(Integer exPageNum) {
		ExUser currentUser = getCurrentUser();
		PageHelper.startPage(exPageNum, 6);
		List<Exprience> myExpriences = exprienceService.selectExprienceByAuthorName(currentUser.getNICKNAME());
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(myExpriences);
		//���û�������ˣ��򷵻�null
		if (exPageNum > pageInfo.getPages()) {
			pageInfo.setList(null);
		}
		return pageInfo;
	}
	
	/**
	 * ͨ��exprienceidɾ������
	 * @param exprienceId
	 * @param exPageNum
	 * @return
	 */
	@RequestMapping(value = "deleteMyExprience", method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteMyExprience(Integer exprienceId) {
		int successFlag = exprienceService.deleteByPrimaryKey(exprienceId);
		return successFlag;
	}
	
	/**
	 * ��ȡ��ǰ�û�
	 * 
	 * @return
	 */
	private ExUser getCurrentUser() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String nickName = (String) session.getAttribute("nickName");
		ExUser currentUser = exUserService.selectByNickName(nickName);
		return currentUser;
	}

	/**
	 * ��ȡ��ǰ����
	 * 
	 * @return
	 */
	private String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentTime = sdf.format(date);
		return currentTime;
	}

	/**
	 * ��ȡע����������������
	 * 
	 * @param currentTime
	 * @param registerTime
	 * @return
	 */
	private int getTotalDay(String currentTime, String registerTime) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time1 = null;
		Date time2 = null;
		try {
			time1 = sdf.parse(currentTime);
			time2 = sdf.parse(registerTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long intervalMilli = time1.getTime() - time2.getTime();
		int totalDay = (int) (intervalMilli / (24 * 60 * 60 * 1000));

		return totalDay;
	}
}
