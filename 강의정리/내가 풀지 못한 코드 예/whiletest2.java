
public class ForFlowTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 0;
		int mul = 0;

		num = 2;

		while (num <= 9) {

			mul = 1;
			System.out.println(num + "단");

			while (mul <= 9) {

				System.out.println(num + " * " + mul + " = " + (num * mul));
				mul++;

			}

			num++;
			System.out.println();

		}

	}

}
