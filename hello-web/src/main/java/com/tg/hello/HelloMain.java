package com.tg.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		
//		HelloDao dao = new HelloDao();
//
//		int result = dao.addTwoNumber(3, 5);
//		
//		System.out.println(result);
		
		
		AbstractApplicationContext ctx =
				new ClassPathXmlApplicationContext("/spring-context.xml");
		
		HelloDao dao = ctx.getBean("helloDao", HelloDao.class);

		int result = dao.addTwoNumber(5, 57);
		
		System.out.println(result);
	}
	
}
