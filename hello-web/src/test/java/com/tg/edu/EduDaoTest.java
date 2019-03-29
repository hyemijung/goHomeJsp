package com.tg.edu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 클래스명은 동일한 클래스Test로 한다(구별가능하도록 Test만 뒤에 붙여주는것)

//@RunWith(SpringJunit4ClassRunner.class)
//@ContextConfigration("file:src/main/webapp/WEB-INF/spring/*.xml")
public class EduDaoTest { 
	
	private AbstractApplicationContext ctx;
	
	@Before    // 항상 이곳이 수행된후에 메서드가 수행된다
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
	}
		
	@Test
	// 메서드 명명규칙
	// public void test메서드명() - 매개변수없는 메서드 // 메서드명 앞에 test를 붙여준다
	public void testGetStudent() {   // 테스트를 위한 메서드이므로 리턴타입도 없는 void고 매개변수도 없다, 하나의 메인같은 느낌

//		AbstractApplicationContext ctx = 
//				new ClassPathXmlApplicationContext("/spring-context.xml");
		
		// 테스트부터 구현하고 TDD를 만들러 간다
		EduDao eduDao = ctx.getBean("eduDao", EduDao.class);
		
//		Assert.assertEquals("박성욱", eduDao.getStudent().getName());
		
//		Assert.assertTrue(eduDao.getStudent().getName().equals("박성욱1"));
		
//		Assert.assertNull(eduDao); // eduDao는 null 이 아니므로 failures 에 표시됨
		Assert.assertNotNull(eduDao);   //
		
	}

	@Test
	@Ignore
	public void testGetTotalScore() {
		
//		AbstractApplicationContext ctx = 
//				new ClassPathXmlApplicationContext("/spring-context.xml");
		
		EduDao eduDao = ctx.getBean("eduDao", EduDao.class);
			
		
//		Assert.assertEquals(150, eduDao.getTotalScore());
		
		
		Assert.assertFalse(200 < eduDao.getTotalScore());  // 이런식으로 비교도 가능
		Assert.assertTrue(200 > eduDao.getTotalScore());  // 이런식으로 비교도 가능
//		Assert.assertNull(eduDao);   // null이 아니므로 Failure Trace에 뜬다
//		Assert.assertNotNull(eduDao);
		
	}
	
	
	
}
