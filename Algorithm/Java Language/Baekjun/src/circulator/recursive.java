package circulator;

public class recursive {
	int n;
	
	public recursive() {
	}
	
	public int fibonacci(int n) {
		if(n == 0) {
			return 1;
		}
		else if(1<=n && n<=12) {
			return n * fibonacci(n-1);
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
			return 0;
		}
	}
}
