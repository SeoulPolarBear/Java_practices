
public class result {	
	
		static int grade = 201611587;
		static int CODE;
	public static void main(String[] args) {
		CODE = ( (grade % 10000) * 3897 + (grade / 100000)*(grade/ 100000) ) % 10000;
	System.out.println(CODE);
		
	}

}
