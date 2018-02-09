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
	 * 新增文章
	 * 
	 * @param EXTYPE
	 * @param exprience
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "exprienceEdit", method = RequestMethod.POST)
	public ModelAndView exprienceEdit(String EXTYPE, Exprience exprience, String draftId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// 获取类型编号
		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();

		// 上传封面
		MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);
		String savePath = uploadUtil.upload("cover", "/images/cover/");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		// 获取用户名
		ExUser currentUser = getCurrentUser();
		String nickName = currentUser.getNICKNAME();
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME(nickName);
		exprience.setEXPUBLISHTIME(sdf.format(date));
		exprience.setEXCOVER(savePath);
		exprience.setCOMMENTNUM(0);

		// 预览、保存草稿、发布执行的是不一样的操作
		if (exprience.getISPUBLISH().equals("preview")) {
			mav.setViewName("preview");
		} else {
			if (draftId.equals("no")) {
				exService.insert(exprience);
				//发布成功后增加经验值
				int todayValue = currentUser.getTODAYVALUE();
				int dayLimt = currentUser.getDAYVALLIMIT();
				int growthValue = currentUser.getGROWTHVALUE();
				int normalLevel = currentUser.getNORMALLEVEL();
				int levelValue = 400 * normalLevel;
				if (todayValue<dayLimt) {
					currentUser.setGROWTHVALUE(growthValue+200);
					currentUser.setTODAYVALUE(todayValue+200);
					//重置当前成长值
					growthValue = currentUser.getGROWTHVALUE();
					//发送增加经验成功变量到post页面
					mav.addObject("levelUp","add");
					//如果当前成长值大于等于当前等级成长值上限，就升级
					if (growthValue>=levelValue) {
						currentUser.setNORMALLEVEL(normalLevel+1);
						//当前成长值清零
						currentUser.setGROWTHVALUE(0);
						//每日成长值上限提升当前等级成长值上限的20%
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
				mav.addObject("currentType", "草稿箱");
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
	 * 去见闻详情页
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
		// 获取当前用户
		ExUser currentUser = null;
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String nickName = (String) session.getAttribute("nickName");
		if (nickName != null) {
			currentUser = exUserService.selectByNickName(nickName);
		}
		// 获取作者的热门作品
		// 周排行数据
		List<Exprience> authroRankList = new ArrayList<Exprience>();		
		authroRankList = exService.authorRankExprience(authorName);

		// 评论分页
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
	 * 获取动态加载见闻内容
	 * 
	 * @param exPageNum
	 * @return
	 */
	@RequestMapping(value = "getAfterLoadEx", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Exprience> getAfterLoadEx(Integer exPageNum) {
		// 分页
		PageHelper.startPage(exPageNum, 5);
		// 去数据库查询
		List<Exprience> exList = exService.selectAllExprience();
		// 将查询的信息封装到pageinfo中
		PageInfo<Exprience> pageInfo = new PageInfo<Exprience>(exList);
		if (exPageNum > pageInfo.getPages()) {
			pageInfo.setList(null);
		}
		return pageInfo;
	}

	/**
	 * 获取动态加载的评论
	 * 
	 * @param exPageNum
	 * @param exprienceId
	 * @return
	 */
	@RequestMapping(value = "getAfterLoadCommentReply", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<ExCommentDetail> getAfterLoadCommentReply(Integer exPageNum, Integer exprienceId) {
		// 分页
		PageHelper.startPage(exPageNum, 5);
		// 去数据库查询
		List<ExCommentDetail> commentList = exCommentService.selectCommentsByExid(exprienceId);
		PageInfo<ExCommentDetail> pageInfo = new PageInfo<ExCommentDetail>(commentList);
		if (exPageNum > pageInfo.getPages()) {
			pageInfo.setList(null);
		}
		return pageInfo;
	}

	/**
	 * 添加评论并获取前五条
	 * 
	 * @param exprienceId
	 * @param commentContent
	 * @return
	 */
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<ExCommentDetail> comment(Integer exprienceId, String commentContent) {
		// 获取当前用户，即评论人昵称
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String commentAname = (String) session.getAttribute("nickName");
		// 获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String commentTime = sdf.format(date);

		ExComment comment = new ExComment();
		comment.setEXPRIENCEID(exprienceId);
		comment.setUSERANAME(commentAname);
		comment.setCOMMENTCONTENRT(commentContent);
		comment.setCOMMENTTIME(commentTime);

		int succesFlag = exCommentService.insert(comment);

		// 更新见闻的评论数
		if (succesFlag == 1) {
			Exprience exprience = exService.selectByPrimaryKey(exprienceId);
			exprience.setCOMMENTNUM(exprience.getCOMMENTNUM() + 1);
			exService.updateByPrimaryKey(exprience);
		}

		// 评论分页
		PageHelper.startPage(1, 5);
		List<ExCommentDetail> commentList = exCommentService.selectCommentsByExid(exprienceId);
		PageInfo<ExCommentDetail> pageInfo = new PageInfo<ExCommentDetail>(commentList);

		return pageInfo;
	}

	/**
	 * 添加回复并获取所有回复
	 * 
	 * @param commentId
	 * @param replyContent
	 * @param replyUserBName
	 * @return
	 */
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	@ResponseBody
	public List<ExReplyDetail> reply(Integer commentId, String replyContent, String replyUserBName) {

		// 获取当前用户，即回复人昵称
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String replyUserAname = (String) session.getAttribute("nickName");

		// 获取当前时间
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
	 * 通过评论ID获取回复
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
	 * 获取上周一到本周一评论数前5的exprience
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
	 * 获取当前用户
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
