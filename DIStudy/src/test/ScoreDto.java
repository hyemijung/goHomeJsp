package test;

public class ScoreDto {

	private int kor = 0;
	private int eng = 0;
	
	public ScoreDto() {
		super();
		
	}

	public ScoreDto(int kor, int eng) {
		super();
		this.kor = kor;
		this.eng = eng;
	}

	public int getKor() {  // 읽는것에는 가공처리해서는 안된다 -> () 안에 매개변수가 있어서는 안됨!!
		
		return kor;
	}

	public void setKor(int kor) { // set은 리턴하지말고 그래서 void, 
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "ScoreDto [kor=" + kor + ", eng=" + eng + "]";
	}
	
	
	
	
	
}
