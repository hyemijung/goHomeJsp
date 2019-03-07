import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MakeStar6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	별문자로 도형만들기(별 찍기)

//		앞에 공백을 찍어주고 별을 찍어주는 것

//	^^^^^    j<5   (j<5-i)
//	^^^^*    j<4
//	^^^**    j<3
//	^^***    j<2
//	^****    j<1

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < (5 - i); j++) { // for (int j = 4; s > 1; s--)샘코드
				System.out.print("^");
			}

			for (int n = 0; n < i; n++) {
				System.out.print("*");
			}
			System.out.println();
		}

//System.out.println("----");

//System.out.print("-");
//System.out.print("-");
//System.out.print("-");
//System.out.print("-");
//
//
//System.out.println();
//
//System.out.print("-");
//System.out.print("-");
//System.out.print("-");
//
//System.out.println();
//
//System.out.print("-");
//System.out.print("-");
//
//System.out.println();
//
//System.out.print("-");
//
//
//
	}

}
