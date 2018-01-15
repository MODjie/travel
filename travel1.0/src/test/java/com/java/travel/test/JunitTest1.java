package com.java.travel.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.travel.mapper.ExtypeMapper;
import com.java.travel.service.ExTypeService;
import com.java.travel.serviceImpl.ExTypeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JunitTest1 {
	@Resource
	ExTypeService exTypeService;
	@Test	
	public void test1() {
		System.out.println(exTypeService.selectByName("见闻"));
	}
	
	@Test
	public void test2() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		try {
			Date currentTime = df.parse(df.format(new Date()));
			System.out.println(currentTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		System.out.println(new Date());
	}
}
