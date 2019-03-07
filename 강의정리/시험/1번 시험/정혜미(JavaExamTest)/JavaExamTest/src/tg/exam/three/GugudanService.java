package tg.exam.three;

public class GugudanService {

// 인스턴스 변수	
	int num = 0;
	int num2 = 0;

// 보고 싶은 단(숫자) 하나를 입력하면 관련된 단이 출력되는 메서드
	void showGugudan(int num) {

		System.out.println("    " + num + "단");

		for (int i = 1; i <= 9; i++) {

			for (int n = num; n <= num + 1; n++) {
				if (n == num)

					System.out.print(n + " * " + i + " = " + (n * i) + "\t");
			}
			System.out.println();
		}

	}

// 보고 싶은 단(숫자, 숫자) 두 개를 입력하면 지정된 숫자 사이의 단이 출력되는 메서드

	void showGugudan(int num, int num2) {

		for (int i = 1; i <= 9; i++) {

			for (int n = num; n <= num + num2; n++) {

				if (n >= num && n <= num2)

					System.out.print(n + " * " + i + " = " + (n * i) + "\t");
			}

			System.out.println();

		}

	}

}
