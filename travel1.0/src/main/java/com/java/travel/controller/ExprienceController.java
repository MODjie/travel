package com.java.travel.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.travel.entity.ExComment;
import com.java.travel.entity.ExCommentDetail;
import com.java.travel.entity.ExReply;
import com.java.travel.entity.ExReplyDetail;
import com.java.travel.entity.ExUser;
import com.java.travel.entity.Exprience;
import com.java.travel.service.ExCommentService;
import com.java.travel.service.ExReplyService;
import com.java.travel.service.ExTypeService;
import com.java.travel.service.ExUserService;
import com.java.travel.service.ExprienceService;
import com.java.travel.util.DateUtil;
import com.java.travel.util.MyFileUploadUtil;

@Controller
public class ExprienceController {
	@Resource
	private ExprienceService exService;
	@Resource
	private ExTypeService exTypeService;
	@Resource
	private ExUserService exUserService;
	@Resource
	private ExCommentService exCommentService;
	@Resource
	private ExReplyService exReplyService;
	/**
	 * ��������
	 * 
	 * @param EXTYPE
	 * @param exprience
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "exprienceEdit", method = RequestMethod.POST)
	public ModelAndView exprienceEdit(String EXTYPE, Exprience exprience, String draftId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// ��ȡ���ͱ��
		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();

		// �ϴ�����
		MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);
		String savePath = uploadUtil.upload("cover", "/images/cover/");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		// ��ȡ�û���
		ExUser currentUser = getCurrentUser();
		String nickName = currentUser.getNICKNAME();
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME(nickName);
		exprience.setEXPUBLISHTIME(sdf.format(date));
		exprience.setEXCOVER(savePath);
		exprience.setCOMMENTNUM(0);

		// Ԥ��������ݸ塢����ִ�е��ǲ�һ���Ĳ���
		if (exprience.getISPUBLISH().equals("preview")) {
			mav.setViewName("preview");
		} else {
			if (draftId.equals("no")) {
				exService.insert(exprience);
				//�����ɹ������Ӿ���ֵ
				int todayValue = currentUser.getTODAYVALUE();
				int dayLimt = currentUser.getDAYVALLIMIT();
				int growthValue = currentUser.getGROWTHVALUE();
				int normalLevel = currentUser.getNORMALLEVEL();
				int levelValue = 400 * normalLevel;
				if (todayValue<dayLimt) {
					currentUser.setGROWTHVALUE(growthValue+200);
					currentUser.setTODAYVALUE(todayValue+200);
					//���õ�ǰ�ɳ�ֵ
					growthValue = currentUser.getGROWTHVALUE();
					//�������Ӿ���ɹ�������postҳ��
					mav.addObject("levelUp","add");
					//�����ǰ�ɳ�ֵ���ڵ��ڵ�ǰ�ȼ��ɳ�ֵ���ޣ�������
					if (growthValue>=levelValue) {
						currentUser.setNORMALLEVEL(normalLevel+1);
						//��ǰ�ɳ�ֵ����
						currentUser.setGROWTHVALUE(0);
						//ÿ�ճɳ�ֵ����������ǰ�ȼ��ɳ�ֵ���޵�20%
						currentUser.setDAYVALLIMIT(dayLimt+(int)(levelValue*0.2/200)*200);
						mav.addObject("levelUp","yes");
					}
					exUserService.updateByPrimaryKey(currentUser);					
				}				
			} else {
				exprience.setEXPRIENCEID(Integer.valueOf(draftId));
				exService.updateByPrimaryKey(exprience);
			}
			if (exprience.getISPUBLISH().equals("no")) {
				mav.addObject("currentUser", currentUser);
				mav.addObject("currentType", "�ݸ���");
				mav.setViewName("exprienceList");
			} else if (exprience.getISPUBLISH().equals("yes")) {
				ExUser author = exUserService.selectByNickName(nickName);
				mav.addObject("author", author);
				mav.setViewName("post");
			}
		}
		mav.addObject("exprience", exprience);
		return mav;
	}

	/**
	 * ȥ��������ҳ
	 * 
	 * @param exprience
	 * @return
	 */
	@RequestMapping(value = "toPost", method = RequestMethod.GET)
	public ModelAndView toPost(Integer exprienceId) {
		ModelAndView modelAndView = new ModelAndView("post");
		Exprience exprience = exService.selectByPrimaryKey(exprienceId);
		String authorName = exprience.getEXAUTHORNAME();
		ExUser author = exUserService.selectByNickName(authorName);
		// ��ȡ��ǰ�û�
		ExUser currentUser = null;
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String nickName = (String) session.getAttribute("nickName");
		if (nickName != null) {
			currentUser = exUserService.selectByNickName(nickName);
		}
		// ��ȡ���ߵ�������Ʒ
		// ����������
		List<Exprience> authroRankList = new ArrayList<Exprience>();		
		authroRankList = exService.authorRankExprience(authorName);

		// ���۷�ҳ
		PageHelper.startPage(1, 5);
		List<ExCommentDetail> commentList = exCommentService.selectCommentsByExid(exprienceId);
		PageInfo<ExCommentDetail> pageInfo = new PageInfo<ExCommentDetail>(commentList);
		if (commentList.size() == 0) {
			pageInfo.setList(null);
		}

		modelAndView.addObject("exprience", exprience);
		modelAndView.addObject("author", author);
		modelAndView.addObject("currentUser", currentUser);
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("authroRankList", authroRankList);
		
		return modelAndView;
	}

	/**
	 * ��ȡ��̬���ؼ�������
	 * 
	 * @param exPageNum
	 * @return
	 */
	@RequestMapping(value = "getAfterLoadEx", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Exprience> getAfterLoadEx(Integer exPageNum) {
		// ��ҳ
		PageHelper.startPage(exPageNum, 5);
		// ȥ���ݿ��ѯ
		List<Exprience> exList = exService.selectAllExprience();
		// ����ѯ����Ϣ��װ��pageinfo��
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(exList);
		if (exPageNum > pageInfo.getPages()) {
			pageInfo.setList(null);
		}
		return pageInfo;
	}

	/**
	 * ��ȡ��̬���ص�����
	 * 
	 * @param exPageNum
	 * @param exprienceId
	 * @return
	 */
	@RequestMapping(value = "getAfterLoadCommentReply", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<ExCommentDetail> getAfterLoadCommentReply(Integer exPageNum, Integer exprienceId) {
		// ��ҳ
		PageHelper.startPage(exPageNum, 5);
		// ȥ���ݿ��ѯ
		List<ExCommentDetail> commentList = exCommentService.selectCommentsByExid(exprienceId);
		PageInfo<ExCommentDetail> pageInfo = new PageInfo<ExCommentDetail>(commentList);
		if (exPageNum > pageInfo.getPages()) {
			pageInfo.setList(null);
		}
		return pageInfo;
	}

	/**
	 * ������۲���ȡǰ����
	 * 
	 * @param exprienceId
	 * @param commentContent
	 * @return
	 */
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<ExCommentDetail> comment(Integer exprienceId, String commentContent) {
		// ��ȡ��ǰ�û������������ǳ�
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String commentAname = (String) session.getAttribute("nickName");
		// ��ȡ��ǰʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String commentTime = sdf.format(date);

		ExComment comment = new ExComment();
		comment.setEXPRIENCEID(exprienceId);
		comment.setUSERANAME(commentAname);
		comment.setCOMMENTCONTENRT(commentContent);
		comment.setCOMMENTTIME(commentTime);

		int succesFlag = exCommentService.insert(comment);

		// ���¼��ŵ�������
		if (succesFlag == 1) {
			Exprience exprience = exService.selectByPrimaryKey(exprienceId);
			exprience.setCOMMENTNUM(exprience.getCOMMENTNUM() + 1);
			exService.updateByPrimaryKey(exprience);
		}

		// ���۷�ҳ
		PageHelper.startPage(1, 5);
		List<ExCommentDetail> commentList = exCommentService.selectCommentsByExid(exprienceId);
		PageInfo<ExCommentDetail> pageInfo = new PageInfo<ExCommentDetail>(commentList);

		return pageInfo;
	}

	/**
	 * ��ӻظ�����ȡ���лظ�
	 * 
	 * @param commentId
	 * @param replyContent
	 * @param replyUserBName
	 * @return
	 */
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	@ResponseBody
	public List<ExReplyDetail> reply(Integer commentId, String replyContent, String replyUserBName) {

		// ��ȡ��ǰ�û������ظ����ǳ�
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String replyUserAname = (String) session.getAttribute("nickName");

		// ��ȡ��ǰʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String replyTime = sdf.format(date);

		ExReply exReply = new ExReply();
		exReply.setCOMMENTID(commentId);
		exReply.setREPLYCONTENT(replyContent);
		exReply.setREPLYTIME(replyTime);
		exReply.setREPLYUSERANAME(replyUserAname);
		exReply.setREPLYUSERBNAME(replyUserBName);

		exReplyService.insert(exReply);

		List<ExReplyDetail> replyList = exReplyService.selectReplyByCommentId(commentId);

		return replyList;
	}

	/**
	 * ͨ������ID��ȡ�ظ�
	 * 
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	@ResponseBody
	public List<ExReplyDetail> reply(Integer commentId) {

		List<ExReplyDetail> replyList = exReplyService.selectReplyByCommentId(commentId);

		return replyList;
	}

	/**
	 * ��ȡ����һ������һ������ǰ5��exprience
	 * 
	 * @return
	 */
	/*
	 * @RequestMapping(value = "weekRankExprience", method = RequestMethod.GET)
	 * public List<Exprience> weekRankExprience() {
	 * 
	 * return rankList; }
	 */
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
}
