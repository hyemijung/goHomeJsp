package com.tg.edu;

public class EduDao {

	public Student getStudent() {  // 이름을 불러올때는 매개변수가 없어야 된다 
		
		Student student = new Student();
		
		student.setName("박성욱");
															// TDD 의 최소단위
		return student;
		
	}
	
	public int getTotalScore() {  // 성적의 합산을 불러오자
		
		ScoreDto scoreDto = new ScoreDto();
		
		scoreDto.setEng(70);
		scoreDto.setKor(80);
		
		int result = scoreDto.getEng() + scoreDto.getKor();
		
		return result;
	}
	
	
	
	
	
}
