
public class FMain3 {
	
	
	public static void test(int q) {//test의 지역변수
		// 이때 가지고 온 q는 main에서 q를 복사해 와서 사용한다.
		System.out.println(q);//10 test의 지역변수
		q = 20;
		System.out.println(q);//20 test의 지역변수
	}
	
public static void main(String[] args) {
	
	int q = 10;// main 함수 지역변수 yellow
	System.out.println(q);//10 main 함수 지역변수 yellow
	test(q);			
	System.out.println(q);//10 main 함수 지역변수 yellow
	
}
}
