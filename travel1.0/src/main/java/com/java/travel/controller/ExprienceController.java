package com.java.travel.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String exprienceEdit(String EXTYPE, Exprience exprience, HttpServletRequest request) {
		//获取类型编号
		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();

		// 上传封面
		MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);		
		String savePath = uploadUtil.getDefaultTargetPath("cover","/cover/");
		uploadUtil.upload("cover","/cover/");

		exprience.setEXPRIENCEID(6);
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME("有梦想的码农");
		exprience.setEXPUBLISHTIME(new Date());
		exprience.setEXCOVER(savePath);

		exService.insert(exprience);

		return "write_ex";
	}
}
