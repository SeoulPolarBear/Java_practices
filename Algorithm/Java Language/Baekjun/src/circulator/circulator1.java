package circulator;
import java.util.*;
public class circulator1 {
	
	public int fibonacci(int N) {
		if(N == 0) {
			return 1;
		}
		else if(1<=N && N<=12) {
			return N * fibonacci(N-1);
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
			return 0;
		}
	}

	public static void main(String[] args) {

		Scanner n = new Scanner(System.in);
		int N = n.nextInt();
		circulator1 rec = new circulator1();
		System.out.println(rec.fibonacci(N));
//		recursive rec = new recursive();
//		System.out.println(rec.fibonacci(N));
	
	}
}
