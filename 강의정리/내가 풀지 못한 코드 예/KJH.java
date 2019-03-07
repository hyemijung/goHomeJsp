
public class ForFlowEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//				
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j <= i; j++) {
//			
//				System.out.print("*");
//				
//			}
//			
//			System.out.println();
//			
//		}
//		
		String str = "";
		str = " ";

		for (int i = 1; i <= 5; i++) {

			for (int j = 0; j < (5 - i); j++) {

				System.out.print(str);
			}
			for (int j2 = 0; j2 < i; j2++) {

				System.out.print("*");

			}
			System.out.println();
		}

		System.out.println();

	}

}
