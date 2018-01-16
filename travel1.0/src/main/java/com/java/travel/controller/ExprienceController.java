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
	 * ��������
	 * 
	 * @param EXTITLE
	 * @param exprience
	 * @return
	 */
	@RequestMapping(value = "exprienceEdit", method = RequestMethod.POST)
	public String exprienceEdit(String EXTYPE, Exprience exprience, HttpServletRequest request) {
		//��ȡ���ͱ��
		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();

		// �ϴ�����
		// 1����requestתΪMultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// 2���õ��ϴ��ļ�
		MultipartFile file = req.getFile("cover");
		// �õ��ļ��������file.getName() �õ��ļ���file.getOriginalFilename()
		// 3���õ�Ŀ��·��
		String path = request.getRealPath("/cover") + "\\" + file.getOriginalFilename();
		// 4������Ŀ���ļ�
		File destFile = new File(path);
		System.out.println(path);
		// 5�����ļ��ϴ���Ŀ��·��
		try {
			// ֱ��ʹ�÷�װ�õ� copyInputStreamToFile ʵ���ļ����ϴ�����
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		exprience.setEXPRIENCEID(6);
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME("���������ũ");
		exprience.setEXPUBLISHTIME(new Date());
		exprience.setEXCOVER(path);

		exService.insert(exprience);

		return "write_ex";
	}
}
