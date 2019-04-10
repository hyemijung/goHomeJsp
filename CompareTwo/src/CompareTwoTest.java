import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CompareTwoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1;
		int num2;
		
		System.out.println("이 프로그램은 입력하신 두수를 비교하여 큰 수를 출력하는 프로그램입니다");

		Scanner scan = new Scanner(System.in);

		System.out.println("첫번째 수를 입력해주세요");
		num1 = scan.nextInt();
		System.out.println("입력하신 첫번째 수는" + num1 +"입니다");
		System.out.println();
		
		System.out.println("두번째 수를 입력해주세요");
		num2 = scan.nextInt();
		System.out.println("입력하신 두번째 수는" + num2 +"입니다");
		System.out.println();
		
		System.out.println("이제 부터 입력하신 두 수를 비교하겠습니다");
		System.out.println("입력하신 두수의 값이 같을 경우에는 두수를 한꺼번에 보여드리겠습니다");

				
		System.out.println("두수를 비교하는 중입니다...");
		System.out.println();
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (num1 > num2) {
					System.out.println("입력하신 두 숫자 중 더 큰수는 첫번째 입력하신 수인 " + num1 + "입니다");
				} else if (num1 < num2) {
					System.out.println("입력하신 두 숫자 중 더 큰수는 두번째 입력하신 수인 " + num2 + "입니다");
				} else if (num1 == num2) {
					System.out.println("입력하신 두 숫자의 크기가 같습니다.");
					System.out.println("입력하신 두 수는 " + "첫번째 수 = 두번째 수 = " + num1 + "입니다");
				}
					
			}
		};
		
		timer.schedule(task, 4000);
		
		
		
	}

}
