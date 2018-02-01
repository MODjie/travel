package com.java.travel.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.travel.entity.Exprience;

import com.java.travel.service.ExTypeService;
import com.java.travel.service.ExprienceService;
import com.java.travel.util.MyFileUploadUtil;

@Controller
public class ExprienceController {
	@Resource
	ExprienceService exService;
	@Resource
	ExTypeService exTypeService;

	/**
	 * 新增文章
	 * @param EXTYPE
	 * @param exprience
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "exprienceEdit", method = RequestMethod.POST)
	public ModelAndView exprienceEdit(String EXTYPE, Exprience exprience, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//获取类型编号
		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();
		
		// 上传封面
		MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);		
		String savePath = uploadUtil.upload("cover","/images/cover/");

		//获取用户名
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String nickName = (String) session.getAttribute("nickName");
		exprience.setEXPRIENCEID(1);
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME(nickName);
		exprience.setEXPUBLISHTIME(new Date());
		exprience.setEXCOVER(savePath);
		exprience.setCOMMENTNUM(0);
		mav.addObject("exprience", exprience);
		//预览、保存草稿、发布执行的是不一样的操作
		if (exprience.getISPUBLISH().equals("preview")) {								
			mav.setViewName("preview");
		}else if (exprience.getISPUBLISH().equals("no")) {
			exService.insert(exprience);
			mav.setViewName("exprienceList");
		}else if (exprience.getISPUBLISH().equals("yes")) {
			exService.insert(exprience);
			mav.setViewName("post");
		}
		
		return mav;
	}
	
	/**
	 * 去见闻详情页
	 * @param exprience
	 * @return
	 */
	@RequestMapping(value="toPost",method=RequestMethod.GET)
	public ModelAndView toPost(int exprienceId) {
		ModelAndView modelAndView = new ModelAndView("post");
		Exprience exprience = exService.selectByPrimaryKey(exprienceId);
		modelAndView.addObject("exprience",exprience);
		return modelAndView;
	}
}
