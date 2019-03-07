package tg.exam;

import tg.exam.two.AscendingService;

public class ExamMainTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//2번 문제 임의의 숫자들 오름차순으로 정렬하기 
		 AscendingService ascending = new AscendingService();
		 
		 ascending.numbersCreate();
		 ascending.numbersPrint();
		 
		 ascending.numbersAscending();
		 ascending.numbersPrint();
		
		
	}

}
