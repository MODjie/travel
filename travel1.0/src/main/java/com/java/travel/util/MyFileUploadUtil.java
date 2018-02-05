package com.java.travel.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * ���ļ��ϴ�������ʹ��˵��
 *  һ�������ܶ���ʹ��
 * MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);
 * MultipartFile file = uploadUtil.getFile(inputFileName);
 * String fileName = uploadUtil.getRandomName(file);
 * String savePath = uploadUtil.getTargetPath(fileDir,fileName);
 * 1��ͨ��request����ʵ����
 * 2��ͨ���ϴ��ļ��Ŀؼ�name��inputFileName����ϴ��ļ�
 * 3��ͨ����õ��ļ�file���������ļ���
 * 4��ͨ��Ŀ���ļ���fileDir���ļ���fileName��ñ���·��
 * 5������upload(MultipartFile file,String savePath);
 * ������Ĭ�ϵı��淽ʽʹ��
 * MyFileUploadUtil uploadUtil = new MyFileUploadUtil(request);		
 * String savePath = uploadUtil.getDefaultTargetPath(inputFileName,fileDir);
 * uploadUtil.upload("cover","/cover/");
 * 1��ͨ��request����ʵ����
 * 2������upload(String inputFileName,String fileDir);���ص��ǵ�ַ 
 * @author ��С��
 * 2018��1��16��23:19:42
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
	 * �ϴ�ͼƬ
	 * 
	 * @param savePath ���·��
	 */
	public void upload(MultipartFile file,String savePath) {
		// 3���õ�Ŀ��·��(�������Ĳ���savePath)

		// 4������Ŀ���ļ�
		File destFile = new File(savePath);
		// 5�����ļ��ϴ���Ŀ��·��
		try {
			// ֱ��ʹ�÷�װ�õ� copyInputStreamToFile ʵ���ļ����ϴ�����
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �ϴ�ͼƬ�������أ�ֻҪ�����������������Ϳ���
	 * @param inputFileName �ϴ��ļ��ؼ���name
	 * @param fileDir Ŀ���ļ���
	 * @return String ���ر�������·��
	 */
	public String upload(String inputFileName,String fileDir) {
		MultipartFile file = this.getFile(inputFileName);
		String fileName = this.getRandomName(file);
		String savePath = this.getTargetPath(fileDir,fileName);
		this.upload(file, savePath);
		//��ȡ���·��
		String readPath = request.getContextPath()+fileDir+fileName;
		return readPath;
	}
	
	/**
	 * ��ȡ���·������ȡͼƬʱ����þ���·���Ƕ�������
	 * @param fileDir
	 * @param fileName
	 * @return
	 */
	public String getReadPath(String fileDir, String fileName) {
		String readPath = request.getContextPath()+fileDir+fileName;
		return readPath;
	}
	
	/**
	 * �ļ����Ŀ��·��������·����
	 * 
	 * @param fileDir Ŀ���ļ���
	 * @param fileName ��ŵ��ļ�����
	 * @return
	 */
	public String getTargetPath(String fileDir, String fileName) {
		String targetPath = request.getSession().getServletContext().getRealPath(fileDir) + fileName;		
		return targetPath;
	}
	
	
	/**
	 * �õ����ϴ����ļ�
	 * @param inputFileName �ϴ��ļ��ؼ���name
	 * @return
	 */
	public MultipartFile getFile(String inputFileName) {
		// 1����requestתΪMultipartHttpServletRequest
		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		// 2���õ��ϴ��ļ�
		MultipartFile file = req.getFile(inputFileName);
		return file;
	}
	
	/**
	 * ���������ļ���
	 * @param file ǰ̨�ϴ����ļ�
	 * @return
	 */
	public String getRandomName(MultipartFile file) {		
		//��ȡԭʼ�ļ���
		String preName = file.getOriginalFilename();
		//��ȡ��չ��
		preName = preName.substring(preName.lastIndexOf("."));
		Random random = new Random();
		String fileName =random.nextInt(10000) + System.currentTimeMillis() + preName;
		return fileName;
	}
}

