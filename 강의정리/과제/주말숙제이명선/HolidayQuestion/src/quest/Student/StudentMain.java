package quest.Student;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] st = new Student[3];

		// 배열에 담았음
		for (int i = 0; i < st.length; i++) {
			st[i] = new Student();
		}

		// 학생정보 3명까지 입력하기

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

		System.out.println("Q.총점이 가장 높은 순서대로 출력하기");

		Student tmp = new Student();
		System.out.println(tmp);

		// 점수 내림차순 재배열
		//이걸 Student클래스에 넣으면 어떨까
		for (int i = 0; i < st.length - 1; i++) {
			if (st[i].scoreSum < st[i + 1].scoreSum) {
				tmp = st[i + 1];
				st[i + 1] = st[i];
				st[i] = tmp;

			}
		}
		// 재배열한것 출력하기
		//이걸 Student클래스에 넣으면 어떨까222
		for (int i = 0; i < st.length; i++) {
			System.out.println((i+1) + "등");
			st[i].studentInfo();
		}

	}

}
