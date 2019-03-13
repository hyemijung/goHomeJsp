import java.util.ArrayList;
import java.util.List;

public class ForExpendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numList = new ArrayList<Integer>();
		
		for (int i = 0; i < 5 ; i++) {
			numList.add(i+1);
		}
	
		
		
		for (Integer num : numList) {
			System.out.println(num);
		}
	}

}
