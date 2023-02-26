package circulator;
import java.util.*;
public class fibonacci5 {
	
	public int Fn(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else if(2<=n && n<=20) {
			return Fn(n-1)+Fn(n-2);
		}
		else {
			return 0;
		}
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		fibonacci5 fin = new fibonacci5();
		System.out.println(fin.Fn(k));
	}

}
