package tg.exam;

import java.util.Scanner;

public class ExamMainOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1번 문제 정사각형 모양을 출력하기 - 사용자의 숫자 입력에 따라 높이와 넓이가 같은 정사각형을 출력

		
// 사용자의 입력을 받기 위한 스캐너 생성
		Scanner scan = new Scanner(System.in);

//사용자 입력을 받기전 사용자에게 입력이 필요함을 알리는 안내문		
		System.out.println("정사각형의 길이를 입력해주세요");

//사용자 입력단계 
		int num = scan.nextInt();

//반복문을 통한 실행과 출력
		for (int i = 1; i <= num; i++) { // 문자찍기의 실행횟수
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (int n = 0; n < num - i; n++) {
				System.out.print("?");
			}

			System.out.println();
		}

	}

}
