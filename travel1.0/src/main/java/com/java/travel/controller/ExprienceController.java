package com.java.travel.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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
	 * ��������
	 * @param EXTYPE
	 * @param exprience
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "exprienceEdit", method = RequestMethod.POST)
	public ModelAndView exprienceEdit(String EXTYPE, Exprience exprience, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//��ȡ���ͱ��
		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();

		// �ϴ�����
		MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);		
		String savePath = uploadUtil.upload("cover","/images/cover/");

		exprience.setEXPRIENCEID(1);
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME("���������ũ");
		exprience.setEXPUBLISHTIME(new Date());
		exprience.setEXCOVER(savePath);
		exprience.setCOMMENTNUM(0);
		mav.addObject("exprience", exprience);
		//Ԥ��������ݸ塢����ִ�е��ǲ�һ���Ĳ���
		if (exprience.getISPUBLISH().equals("preview")) {								
			mav.setViewName("preview");
		}else if (exprience.getISPUBLISH().equals("no")) {
			exService.insert(exprience);
			mav.setViewName("write_ex");
		}else if (exprience.getISPUBLISH().equals("yes")) {
			exService.insert(exprience);
			mav.setViewName("post");
		}
		
		return mav;
	}
		
}
