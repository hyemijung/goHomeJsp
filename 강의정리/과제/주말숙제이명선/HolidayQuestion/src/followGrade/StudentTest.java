package followGrade;

public class StudentTest {

	public static void main(String[] args) {
		
//	학생 3명의 정보를 담기위한 Student타입의 3개짜리 배열을 생성
		Student[] st = new  Student[3];
		
//		이 과정이 없다면?
//		for (int i = 0; i < st.length; i++) {
//			st[i] = new Student();			
//		}
		
		st[0].setName("김준혁");
		st[0].setJavaScore(73);
		st[0].setdbScore(84);
		st[0].setdb2Score(63);
		st[0].setdisplayScore(73);
		st[0].setScoreSum();

		st[1].setName("김충현");
		st[1].setJavaScore(100);
		st[1].setdbScore(84);
		st[1].setdb2Score(58);
		st[1].setdisplayScore(85);
		st[1].setScoreSum();

		st[2].setName("박강인");
		st[2].setJavaScore(36);
		st[2].setdbScore(74);
		st[2].setdb2Score(96);
		st[2].setdisplayScore(30);
		st[2].setScoreSum();
		
		// 잘 입력되었는지 확인차 출력

		// getter 쓰기보단 한번에 출력하는게 보기 편해서
		// 일단 getter도 만들어놓긴 했음
		st[0].studentInfo();
		st[1].studentInfo();
		st[2].studentInfo();

		
		
	}
	
	
}
