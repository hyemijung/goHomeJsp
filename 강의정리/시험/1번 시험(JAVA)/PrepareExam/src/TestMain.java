
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numArr = new int[10];
		int num = 0;

		System.out.println("10개의 난수를 생성합니다.");
		System.out.println("[숫자들 조회]");
		for (int i = 1; i <= 10; i++) {

			num = (int) (Math.random() * 100);
			System.out.print(" " + num + " ");

		}
		
		
		System.out.println();
		System.out.println("10개의 숫자들을 오름차순으로 정렬합니다");
		System.out.println("[숫자들 조회]");

		int temp = 0;
		
		
		for (int i = 0; i < numArr.length; i++) {
			for (int n = 0; n < numArr.length; n++) {
				if (numArr[i] < numArr[n]) {
					temp = numArr[i];
					numArr[i] = numArr[n];
					numArr[n] = temp;
				}
			}
		}

//		for (int i = 0; i < numArr.length; i++)
//		System.out.print(numArr[num] + " ");
	}

}
