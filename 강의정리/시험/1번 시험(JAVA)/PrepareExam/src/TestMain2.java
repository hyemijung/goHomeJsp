
public class TestMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 0;
		int num2 = 0;
// 보고 싶은 단(숫자, 숫자) 두 개를 입력하면 지정된 숫자 사이의 단이 출력되는 메서드

		num = 2;
		num2 = 5;

//		System.out.println("    " + num + "단");

		
		
		
		
		for (int n = num; n <= num + num2; n++) {
			System.out.print("    " + num + "단");
			System.out.print("    " + num2 + "단");
			if (n >= num && n <= num2) {
				
			}
			
		}
		
				
		

		System.out.println();
		
		for (int i = 1; i <= 9; i++) {

			for (int n = num; n <= num + num2; n++) {

				if (n >= num && n <= num2)

					System.out.print(n + " * " + i + " = " + (n * i) + "\t");
			}

			System.out.println();

		}

//		for (int n = 4; n <= 4; n++) {
//			System.out.println("    " + 4 + "단");
//
//		}
//
//		for (int i = 1; i <= 9; i++) {
//			for (int n = num; n <= 7; n++) {
//				if (n >= num && n <= 7)
//
//					System.out.print(num + " * " + i + " = " + (num * i) + "\t");
//			}
//			System.out.println();
//		}

	}

}
