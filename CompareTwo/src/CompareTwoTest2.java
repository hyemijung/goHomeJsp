
import java.util.Scanner;

public class CompareTwoTest2 {

   public static void main(String[] args) {

      int num1 = 0;
      int num2 = 0;
      String game = "";
      Scanner scan = new Scanner(System.in);

      System.out.println("두개의 숫자를 입력하는 프로그램 입니다.");

      while (true) {

         System.out.println("게임을 시작하시겠습니까? \n시작을 원하시면 소문자로'y'를" + " 종료를 원하시면 소문자로'exit'를 입력해주세요");
         game = scan.nextLine();

         if (game.equals("y")) {

            System.out.println("첫번째 숫자를 입력해주세요.");
            num1 = Integer.parseInt(scan.nextLine());

            System.out.println("2번째 숫자를 입력해 주세요.");
            num2 = Integer.parseInt(scan.nextLine());

            if (num1 > num2) {
               System.out.println("첫번째 숫자가 더 큽니다. 값은:" + num1);
            } else if (num1 < num2) {

               System.out.println("두번째 숫자가 더 큽니다. 값은 :" + num2);

            } else {
               System.out.println("값이 같습니다.");
            }

            System.out.println();
            
         } else if (game.equals("exit")) {
            
            break;
         } else {
            System.out.println("잘못 입력하였습니다.\n게임을 할맘이 없으면 'exit'를 입력해주세요");
            System.out.println();
         }

      }

      System.out.println("프로그램을 종료합니다.");

   }
}