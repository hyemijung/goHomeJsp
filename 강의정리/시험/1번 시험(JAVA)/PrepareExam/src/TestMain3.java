
public class TestMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 0;
//		int 7= 0;
/// 보고 싶은 단(숫자) 하나를 입력하면 관련된 단이 출력되는 메서드	
		num = -700;

		System.out.println("    " + num + "단");

		for (int i = 1; i <= 9; i++) {

			for (int n = num; n <= num + 1; n++) {
				if (n == num)

					System.out.print(n + " * " + i + " = " + (n * i) + "\t");
			}
			System.out.println();
		}

	}

}
