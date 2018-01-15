package com.java.travel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.travel.entity.Exprience;
import com.java.travel.entity.Extype;
import com.java.travel.mapper.ExprienceMapper;
import com.java.travel.mapper.ExtypeMapper;
import com.java.travel.service.ExTypeService;
import com.java.travel.service.ExprienceService;
import com.java.travel.serviceImpl.ExprienceServiceImpl;

@Controller
public class ExprienceController {
	@Resource
	ExprienceService exService;
	@Resource
	ExTypeService exTypeService;
	
	/**
	 * 新增文章
	 * @param exTitle
	 * @param exType
	 * @param exContent
	 * @return
	 */
	@RequestMapping(value="exprienceEdit",method=RequestMethod.GET)
	public String exprienceEdit(String exTitle,String exType,String exContent,String exIsPublish) {
		
		int exTypeId = exTypeService.selectByName(exType).getEXTYPEID();
		
		Exprience exprience = new Exprience();
		exprience.setEXPRIENCEID(6);
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXTITLE(exTitle);
		exprience.setEXAUTHORNAME("有梦想的码农");
		exprience.setEXCONTENT(exContent);
		exprience.setEXCOVER("cover");
		exprience.setISPUBLISH(exIsPublish);
		exprience.setEXPUBLISHTIME(new Date());
		
		exService.insert(exprience);
		
		return "write_ex";
	}
}
