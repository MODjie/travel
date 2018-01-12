package com.java.travel.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.travel.entity.ClobTest;
import com.java.travel.mapper.ClobTestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JunitTest1 {
	
	@Resource
	ClobTestMapper clob;
	@Test	
	public void test1() {
		clob.insert(new ClobTest(1,"ssss"));
	}
}
