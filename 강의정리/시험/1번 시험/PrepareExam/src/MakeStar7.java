
public class MakeStar7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		별찍기(가로8 * 세로6)
		
		 for (int i = 0; i < 6; i++) { 
		      if (i == 0 || i == 5) { 
		        for (int j = 0; j < 8; j++) { 
		          System.out.print("*"); 
		       } 
		       System.out.println(); 
		    } 
		    else { 
		      for (int j = 0; j < 8; j++) { 
		        if (j == 0 || j == 7) System.out.print("*"); 
		        else System.out.print(" "); 
		     } 
		     System.out.println(); 
		  } 
		} 
		
	

		}
}

