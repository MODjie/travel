package com.java.travel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.java.travel.entity.Exprience;

import com.java.travel.service.ExTypeService;
import com.java.travel.service.ExprienceService;

@Controller
public class ExprienceController {
	@Resource
	ExprienceService exService;
	@Resource
	ExTypeService exTypeService;

	/**
	 * 新增文章
	 * 
	 * @param EXTITLE
	 * @param exprience
	 * @return
	 */
	@RequestMapping(value = "exprienceEdit", method = RequestMethod.POST)
	public String exprienceEdit(String EXTYPE,Exprience exprience) {

		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();

		exprience.setEXPRIENCEID(6);
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME("有梦想的码农");
		exprience.setEXPUBLISHTIME(new Date());

		exService.insert(exprience);

		return "write_ex";
	}	
}
