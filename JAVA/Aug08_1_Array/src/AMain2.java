
public class AMain2 {
	public static void main(String[] args) throws InterruptedException {
		//String[] args의 정체는...?
		//외부에서 값을 받아오기 위해서 사용하는 파라미터
		//args는 변수명이기 때문에 꼭 args가 아니어도 되지만
		//파라미터인 String[] args 자체를 뺴서는 안된다.
		//저장한 폴더에서 cmd 실행
		
		
		for (String arg: args) {
			System.out.println(arg);
		}
		Thread.sleep(1000);
	}
}
