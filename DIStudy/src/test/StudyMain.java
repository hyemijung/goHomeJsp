package test;

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
	
		
		ScoreDto scoreDto2 = new ScoreDto(10, 20);
		Student s2 = new Student(scoreDto2);
		s2.name = "홍길동2";
		s2.showStudent();
	}

}
