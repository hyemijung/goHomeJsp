package com.tg.edu;

public class Student {

	// 그냥 방식?
//	String name;
//	ScoreDto scoreDto; //이렇게 만든 그자체가 의존관계이다 (has 관계의 방식)
//	// 외부의 클래스를 가지고 올때부터 의존관계를 쓰겠다는 의미
//	// 앞으로 Student 가 만들어지면 ScoreDto가 무조건 있어야 한다
//	
//	public Student() {
//		scoreDto = new ScoreDto(100, 90); // 내부에서 new하는 방법은 좋지않다
//	}
//	
//	public void showStudent() {
//		System.out.println("이름은 " + name);
//		String str = scoreDto.toString();
//		
//		System.out.println(str);
//	}

	
	// 의존 주입형 방식
	String name;
	ScoreDto scoreDto; //이렇게 만든 그자체가 의존관계이다 (has 관계의 방식)
	// 외부의 클래스를 가지고 올때부터 의존관계를 쓰겠다는 의미
	// 앞으로 Student 가 만들어지면 ScoreDto가 무조건 있어야 한다
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(ScoreDto scoreDto) {  // 생성자 주입(이게 규칙 spring쓸려면)
		this.scoreDto = scoreDto;
	}
	
	

	public void setScore(ScoreDto scoreDto) { // setter주입(이게 규칙 spring쓸려면)
		this.scoreDto = scoreDto;
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScoreDto getScoreDto() {
		return scoreDto;
	}

	public void setScoreDto(ScoreDto scoreDto) {
		this.scoreDto = scoreDto;
	}

	public void showStudent() {
		System.out.println("이름은 " + name);
		String str = scoreDto.toString();
		
		System.out.println(str);
	}
	
}
