package com.java.travel.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 本文件上传工具类使用说明
 *  一、各功能独立使用
 * MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);
 * MultipartFile file = uploadUtil.getFile(inputFileName);
 * String fileName = uploadUtil.getRandomName(file);
 * String savePath = uploadUtil.getTargetPath(fileDir,fileName);
 * 1、通过request参数实例化
 * 2、通过上传文件的控件name：inputFileName获得上传文件
 * 3、通过获得的文件file获得随机的文件名
 * 4、通过目标文件夹fileDir和文件名fileName获得保存路径
 * 5、调用upload(MultipartFile file,String savePath);
 * 二、用默认的保存方式使用
 * MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);		
 * String savePath = uploadUtil.getDefaultTargetPath(inputFileName,fileDir);
 * uploadUtil.upload("cover","/cover/");
 * 1、通过request参数实例化
 * 2、调用upload(String inputFileName,String fileDir);返回的是地址 
 * @author 刘小杰
 * 2018年1月16日23:19:42
 */
public class MyFileUploadUtil {
	private HttpServletRequest request;

	public MyFileUploadUtil(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		this.request = request;
	}

	public MyFileUploadUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 上传图片
	 * 
	 * @param savePath 存放路径
	 */
	public void upload(MultipartFile file,String savePath) {
		// 3、得到目标路径(传进来的参数savePath)

		// 4、创建目标文件
		File destFile = new File(savePath);
		// 5、将文件上传到目标路径
		try {
			// 直接使用封装好的 copyInputStreamToFile 实现文件的上传功能
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 上传图片方法重载，只要传入以下两个参数就可以
	 * @param inputFileName 上传文件控件的name
	 * @param fileDir 目标文件夹
	 * @return String 返回保存的相对路径
	 */
	public String upload(String inputFileName,String fileDir) {
		MultipartFile file = this.getFile(inputFileName);
		String fileName = this.getRandomName(file);
		String savePath = this.getTargetPath(fileDir,fileName);
		this.upload(file, savePath);
		//获取相对路径
		String readPath = request.getContextPath()+fileDir+fileName;
		return readPath;
	}
	
	/**
	 * 获取相对路径，读取图片时如果用绝对路径是读不到的
	 * @param fileDir
	 * @param fileName
	 * @return
	 */
	public String getReadPath(String fileDir, String fileName) {
		String readPath = request.getContextPath()+fileDir+fileName;
		return readPath;
	}
	
	/**
	 * 文件存放目标路径（绝对路径）
	 * 
	 * @param fileDir 目标文件夹
	 * @param fileName 存放的文件名称
	 * @return
	 */
	public String getTargetPath(String fileDir, String fileName) {
		String targetPath = request.getSession().getServletContext().getRealPath(fileDir) + fileName;		
		return targetPath;
	}
	
	
	/**
	 * 得到表单上传的文件
	 * @param inputFileName 上传文件控件的name
	 * @return
	 */
	public MultipartFile getFile(String inputFileName) {
		// 1、将request转为MultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// 2、得到上传文件
		MultipartFile file = req.getFile(inputFileName);
		return file;
	}
	
	/**
	 * 获得随机的文件名
	 * @param file 前台上传的文件
	 * @return
	 */
	public String getRandomName(MultipartFile file) {		
		//获取原始文件名
		String preName = file.getOriginalFilename();
		//获取拓展名
		preName = preName.substring(preName.lastIndexOf("."));
		Random random = new Random();
		String fileName =random.nextInt(10000) + System.currentTimeMillis() + preName;
		return fileName;
	}
}

