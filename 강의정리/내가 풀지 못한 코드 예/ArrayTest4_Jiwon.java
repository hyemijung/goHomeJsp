
public class ArrayTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] firstNumArr = new int[5];
		int[] secondNumArr = new int[10];
		
		for (int i = 0; i < firstNumArr.length; i++) {
			firstNumArr[i] = i * 5;
			System.out.println("배열 " + firstNumArr.length + "개의 " + i + "번째 값: " + firstNumArr[i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < firstNumArr.length; i++) {
			secondNumArr[i] = firstNumArr[i];
			System.out.println("배열 10개의 " + i + "번째 값: " + secondNumArr[i]);
		}
		for (int i = 0; i < firstNumArr.length; i++) {
			secondNumArr[i + firstNumArr.length] = i + 5;
			System.out.println("배열 10개의 " + (i + 5) + "번째 값: " + secondNumArr[i + 5]);
		}
		
		
		
	}

}
