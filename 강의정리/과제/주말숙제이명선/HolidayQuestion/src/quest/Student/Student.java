package quest.Student;

public class Student {

	protected String name = "";
	protected int javaScore = 0;
	protected int dbScore = 0;
	protected int dbScore2 = 0;
	protected int displayScore = 0;
	protected int scoreSum = 0;

//	StudentBasic(String name, int javaScore, int dbScore, int dbScore2, int displayScore){
//		this.name = name;
//		this.dbScore = dbScore;
//		this.dbScore2 = dbScore2;
//		this.displayScore = displayScore;
//	}

	void setName(String name) {
		this.name = name;

	}

	String getName() {
		return name;
	}
	
	void setJavaScore(int score) {
		this.javaScore = score;
	}
	
	int getJavaScore() {
		return javaScore;
	}

	void setdbScore(int score) {
		this.dbScore = score;
	}

	int getdbScore() {
		return dbScore;
	}

	void setdb2Score(int score) {
		this.dbScore2 = score;
	}

	int getdb2Score() {
		return dbScore2;
	}

	void setdisplayScore(int score) {
		this.displayScore = score;
	}

	int getdisplayScore() {
		return displayScore;
	}
	
	void setScoreSum() {
		this.scoreSum = javaScore + dbScore + dbScore2 + displayScore;
	}
	
	
	//가공된 데이터 한꺼번에 출력
	void studentInfo() {
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + scoreSum + "점");
		System.out.println("자바 점수 : " + javaScore + "점");
		System.out.println("db구현 점수 : " + dbScore + "점");
		System.out.println("db활용 점수 : " + dbScore2 + "점");
		System.out.println("화면단 점수 : " + displayScore + "점");
		System.out.println();
	} 

}
