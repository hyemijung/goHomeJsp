package com.tg.edu;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.hello.HelloDao;

public class StudyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ScoreDto scoreDto = new ScoreDto();
//		Student student = new Student();
//		Student student2 = new Student();
//		
//		student.showStudent();
//		
//		student.name = "홍길동";
//		
//		student.showStudent();
//		student2.showStudent();
		
		
		// 의존 주입 방식
		
		ScoreDto scoreDto = new ScoreDto(100, 90);
		Student s = new Student(scoreDto);
		s.name = "홍길동";
		s.showStudent();
	
		
		
		// 위와 달리 아래는 spring-context.xml에서 생성자의 매개변수의 값을 설정하고 가져오는 형태다
		AbstractApplicationContext ctx =
				new ClassPathXmlApplicationContext("/spring-context.xml");
		
		ScoreDto scoreDto2 = ctx.getBean("scoreDto", ScoreDto.class);
				 
		Student s2 = new Student(scoreDto2);
		s2.name = "홍길동2";
		s2.showStudent();
	}

}
