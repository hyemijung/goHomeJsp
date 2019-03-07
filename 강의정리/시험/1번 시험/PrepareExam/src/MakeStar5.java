import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MakeStar5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	별문자로 도형만들기(별 찍기)

//		앞에 공백을 찍어주고 별을 찍어주는 것
		
//           ^ 표시만 생각(j<i)
//	*****     
//	^****     
//	^^***     
//	^^^**     
//	^^^^*     

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("^");
			}
			for (int n = 0; n < 5-i ; n++) {
				System.out.print("*");
			}
			
			
			System.out.println();
		}

		
		
		
		
//		System.out.println();
//		
//		System.out.print("^");
//		
//		System.out.println();
//		
//		System.out.print("^");
//		System.out.print("^");
//		
//		System.out.println();
//		
//		System.out.print("^");
//		System.out.print("^");
//		System.out.print("^");
//		
//		System.out.println();
//		
//		System.out.print("^");
//		System.out.print("^");
//		System.out.print("^");
//		System.out.print("^");
//		
		
		
	}

}
