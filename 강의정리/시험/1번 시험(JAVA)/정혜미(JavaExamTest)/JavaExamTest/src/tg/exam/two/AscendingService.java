package tg.exam.two;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class AscendingService {

//임의의 정수 10개가 들어가기 위한 배열생성
	int[] numArr = new int[10];
	int num = 0;

//10개 배열에 들어갈 10개의 난수 생성을 위한 for문과 Math.random사용		
	public void numbersCreate() {

		System.out.println("10개의 난수를 생성합니다.");
		System.out.println("[숫자들 조회]");

		for (int i = 1; i <= 10; i++) { // 10개의 배열에 난수 넣기

			num = (int) (Math.random() * 100); // 1~99 까지의 난수 생성
			System.out.print(" " + num + ", ");

		}
	}

// 10개의 배열에 들어간 임의의 정수 10개를 오름차순으로 정렬하는 메서드
	public void numbersAscending() {

		System.out.println();
		System.out.println("10개의 숫자들을 오름차순으로 정렬합니다");
		System.out.println("[숫자들 조회]");

		int temp = 0;

		for (int i = 0; i < numArr.length; i++) {
			for (int n = 0; n < numArr.length; n++) {
				if (numArr[i] < numArr[n]) {
					temp = numArr[i];
					numArr[i] = numArr[n];
					numArr[n] = temp;
				}
			}
		}
	}

// 10개의 배열에 들어간 임의의 정수 10개를 조회하는 메서드
	public void numbersPrint() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(numArr[i] + " ");
		}
		System.out.println();
	}

}