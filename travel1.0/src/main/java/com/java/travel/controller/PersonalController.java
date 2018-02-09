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
import com.java.travel.entity.Extype;
import com.java.travel.service.ExTypeService;
import com.java.travel.service.ExUserService;
import com.java.travel.service.ExprienceService;
import com.java.travel.util.MyFileUploadUtil;

@Controller
public class PersonalController {

	@Resource
	private ExUserService exUserService;
	@Resource
	private ExprienceService exprienceService;
	@Resource
	private ExTypeService exTypeService;

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
	public ModelAndView toUserInfo(String authorName) {
		ModelAndView modelAndView = new ModelAndView("userinfo");
		ExUser currentUser = getCurrentUser();
		modelAndView.addObject("currentUser", currentUser);
		if(authorName!=""){
			ExUser author = exUserService.selectByNickName(authorName);
			modelAndView.addObject("author", author);
		}
		
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
	public ModelAndView exprienceList(String currentType,String nickName) {
		ModelAndView modelAndView = new ModelAndView("exprienceList");
		ExUser currentUser = getCurrentUser();
		//�жϲ鿴��ǰ�û����ǲ鿴����
		if (nickName!=null) {
			ExUser author = exUserService.selectByNickName(nickName);
			modelAndView.addObject("author", author);
		}else {
			
			nickName = currentUser.getNICKNAME();
		}
		modelAndView.addObject("currentUser", currentUser);

		PageHelper.startPage(1, 6);
		List<Exprience> myExpriences = exprienceService.selectExprienceByAuthorName(nickName, "yes");
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(myExpriences);
		
		if (pageInfo.getSize()==0) {
			pageInfo.setList(null);
		}
		
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("currentType", currentType);
		return modelAndView;
	}

	/**
	 * ��̬�����ҵ�ȫ������
	 * 
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "getMyAfterLoadEx", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Exprience> getMyAfterLoadEx(Integer exPageNum,String selectType,String authorName) {
		ExUser currentUser = getCurrentUser();
		if (authorName=="") {
			authorName=currentUser.getNICKNAME();
		}
		List<Exprience> myExpriences = null;			
		PageHelper.startPage(exPageNum, 6);	
		if (selectType.equals("ȫ��")) {			
			myExpriences = exprienceService.selectExprienceByAuthorName(authorName, "yes");
		} else if (selectType.equals("�ݸ���")) {
			myExpriences = exprienceService.selectExprienceByAuthorName(authorName, "no");
		} else {
		}
		
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(myExpriences);
		// ���û�������ˣ��򷵻�null
		if (exPageNum > pageInfo.getPages()) {
			pageInfo.setList(null);
		}
		return pageInfo;
	}

	/**
	 * ͨ��exprienceidɾ������
	 * 
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
	 * ��ת���༭����
	 * 
	 * @return
	 */
	@RequestMapping(value = "editDraft", method = RequestMethod.GET)
	public ModelAndView editDraft(Integer exprienceId) {
		ModelAndView modelAndView = new ModelAndView("write_ex");
		Exprience draft = exprienceService.selectByPrimaryKey(exprienceId);
		ExUser currentUser = getCurrentUser();
		modelAndView.addObject("currentUser",currentUser);
		modelAndView.addObject("draft",draft);
		
		Extype extype =exTypeService.selectByPrimaryKey(draft.getEXTYPEID());
		String typeName =extype.getTYPENAME();
		modelAndView.addObject("typeName",typeName);
		return modelAndView;
	}
	
	/**
	 * �����ҵļ���
	 * @param selectType
	 * @return
	 */
	@RequestMapping(value = "selectMyExByType", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Exprience> selectMyExByType(String selectType,String authorName) {
		List<Exprience> exprienceList = null;
		ExUser currentUser = getCurrentUser();
		if (authorName=="") {
			authorName = currentUser.getNICKNAME();
		}
		PageHelper.startPage(1, 6);				
		if (selectType.equals("ȫ��")) {
			exprienceList = exprienceService.selectExprienceByAuthorName(authorName, "yes");
		} else if (selectType.equals("�ݸ���")) {
			exprienceList = exprienceService.selectExprienceByAuthorName(authorName, "no");
		} else {
			Extype type  = exTypeService.selectByName(selectType);
			exprienceList = exprienceService.selectExprienceByType(authorName, type.getEXTYPEID(),"yes");
		}
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(exprienceList);

		if (pageInfo.getSize()==0) {
			pageInfo.setList(null);
		}
		
		return pageInfo;
	}

	/**
	 * ��ת����עҳ��
	 * @param authorName
	 * @return
	 */
	@RequestMapping(value="toFocus",method=RequestMethod.GET)
	public ModelAndView toFocus(String authorName) {
		ModelAndView modelAndView = new ModelAndView("focus");
		ExUser currentUser = getCurrentUser();
		
		if (authorName!=null) {
			ExUser author = exUserService.selectByNickName(authorName);
			modelAndView.addObject("author", author);
		}
		
		modelAndView.addObject("currentUser",currentUser);		
		return modelAndView;
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
