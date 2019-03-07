import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MakeStar3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	별문자로 도형만들기(별 찍기)

//	*        i=0, j<1
//	**       i=1, j<2
//	***      i=2, j<3
//	****     i=3, j<4
//	*****    i=4, j<5

		for (int i = 0; i < 5; i++) {
			for (int n = 0; n < i+1
					; n++) {
			 System.out.print("*");
		}
		System.out.println();
		}
		
		
//		for (int n = 0; n < 1; n++) {
//			System.out.print("*");
//		}
//		System.out.println();
//		
//		for (int n = 0; n < 2; n++) {
//			System.out.print("*");
//		}
//		System.out.println();
//		
//		for (int n = 0; n < 3; n++) {
//			System.out.print("*");
//		}
//		System.out.println();
//		
//		for (int n = 0; n < 4; n++) {
//			System.out.print("*");
//		}
//		System.out.println();
//		
//		for (int n = 0; n < 5; n++) {
//			System.out.print("*");
//		}
//		System.out.println();
	}

}
