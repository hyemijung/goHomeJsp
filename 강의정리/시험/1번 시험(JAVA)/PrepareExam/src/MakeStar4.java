import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MakeStar4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	별문자로 도형만들기(별 찍기)

//	*****  i=0, j<5  (j<5-i)
//	****   i=1, j<4
//	***    i=3, j<3
//	**     i=4, j<2
//	*      i=5, j<1

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print("*");
			}
		System.out.println();
		}
		
		

		

	}

}
