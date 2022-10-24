//계산기
// 정수 2개를 넣으면 그 합을 출력하는 기능
// 
public class SMain2 {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.sum(3, 4);
		calculator.sum(1,3,4);
		Calculator.sum(30, 50);// static -> 메모리를 덜 쓰고 해결 ( 위에보다)
		//Calculator.sum(0, 0, 2); 오류 : 클래스 함수 이므로 static에 없으므로
		
		//같은 맥락으로 Java의 내장 클래스 중 하나인 Math
		//이거 또한 객체를 만들지 않고 사용한 경우!
		System.out.println(Math.PI);
	}

}
