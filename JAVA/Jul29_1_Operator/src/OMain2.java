
public class OMain2 {
	public static void main(String[] args) {
		//프로그래밍 언어들마다 기본자료형 : 아무런 처리를 안 하고 값만 있을 때, 어떤 자료형으로 인식을 하는지...
		//java의 경우 : 정수 : int, 실수 : double(java 한정), 다른 언어들은 대부분 float 사용
		//문자열 : String
		//논리 : boolean
		
		//형 변환(type casting)
		// 자료형을 바꾸는 행위
		// Java가 자체적으로 자동형 변환
		/**
		 * 자동형 변환이 안되는 이유 -> eclipse가 처리
		 * (자료형) 값;
		 * 
		 * 형변환의 대표적인 예로는 float
		 * 자료형을 공부하면서 Java는 기본적으로 실수형 자료형을 double로 사용한다.
		 * 만약에 float를 사용한다면 어떻게 될까? 
		 * */
		
		float f = 1.234F;
		float f1 = (float) 1.234;
		//datatype name = (datatype) value;
		double d = 9;// 이것도 형 변환이 된 것이다.
		
	}
}
