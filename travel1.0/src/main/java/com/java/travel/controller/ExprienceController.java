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
	public String exprienceEdit(String EXTYPE, Exprience exprience, HttpServletRequest request) {
		//获取类型编号
		int exTypeId = exTypeService.selectByName(EXTYPE).getEXTYPEID();

		// 上传封面
		// 1、将request转为MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// 2、得到上传文件
		MultipartFile file = req.getFile("cover");
		// 得到文件域的名字file.getName() 得到文件名file.getOriginalFilename()
		// 3、得到目标路径
		String path = request.getRealPath("/cover") + "\\" + file.getOriginalFilename();
		// 4、创建目标文件
		File destFile = new File(path);
		System.out.println(path);
		// 5、将文件上传到目标路径
		try {
			// 直接使用封装好的 copyInputStreamToFile 实现文件的上传功能
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		exprience.setEXPRIENCEID(6);
		exprience.setEXTYPEID(exTypeId);
		exprience.setEXAUTHORNAME("有梦想的码农");
		exprience.setEXPUBLISHTIME(new Date());
		exprience.setEXCOVER(path);

		exService.insert(exprience);

		return "write_ex";
	}
}
