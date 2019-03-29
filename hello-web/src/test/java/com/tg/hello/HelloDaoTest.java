package com.tg.hello;

import org.junit.Assert;
import org.junit.Test;    // 이 메서드는 Junit을 실행한다고 @Test 어노테이션 했기때문에 가능한것
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloDaoTest {

	@Test								// Test 어노테이션
	public void testAddTwoNumber() {  //public, 꼭 void 타입, 매개변수 따위는 없다 
										// 메서드명 앞에 test를 붙여준다
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("/spring-context.xml");

		HelloDao helloDao = ctx.getBean("helloDao", HelloDao.class);

//		int result = helloDao.addTwoNumber(10, 30);
		
//		System.out.println(result);  // 실제 HelloDaa.java에서 실행됨(F3눌르면 간다)
		
//		Assert.assertEquals(expected, actual); (기대되는 값, 실제 값)
//		Assert.assertEquals(10, result);
		Assert.assertEquals(40, helloDao.addTwoNumber(10, 30)); //이제 이런 형태로 사용하게 된다!이유는 나중에
	}

	@Test
	public void subTwoNumber() {
		
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("/spring-context.xml");

		HelloDao helloDao = ctx.getBean("helloDao", HelloDao.class);

//		helloDao.subTwoNumber(10, 1);
		
		Assert.assertEquals(9, helloDao.subTwoNumber(10, 1));;
		
	}
	
	
}
