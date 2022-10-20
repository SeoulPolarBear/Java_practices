//배열(Array)	"[]"  변수 1 : data n
//배열 : 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
//		배열 속에 각각의 data를 요소라고 부른다.
//		요소마다 붙여진 일련 번호가 있는데 각 요소를 구별하는데 사용한다.(인덱스(Index)) : 시작은 0부터!!
//

//배열 생성 방법
//		자료형[] 변수명;	//배열을 선언
//		변수명 = new 자료형[배열의 길이 갯수];	//배열 생성
//		=> 자료형[] 변수명 = new 자료형[배열의 길이 갯수];

public class AMain1 {
	public static void main(String[] args) {
		int[] eng = new int[3];
		eng[0] = 100;
		eng[1] = 70;
		eng[2] = 50;
		for (int i : eng) {// for(A : B) list B에 있는 값들을 꺼내서 하나하나 A에 넣겠다.
			System.out.println(i);
		}

		int[] math = new int[] { 10, 20, 30 };

		for (int i = 0; i < math.length; i++) {
			System.out.println(math[i]);
		}
		int[] kor = { 20, 40, 60 };// 약식
		for (int i : kor) {
			System.out.println(i);

		}

		// 3번째 약식을 못쓰는 경우가 있기 때문에 2번째 방식도 알아두는 것이 좋다.

		int a = 10;
		int[] b = { 10, 20 };
		System.out.println(a);
		System.out.println(b);// [I@2a139a55 : 참조형 번지 값(주소 값)
		// b[2] = 200;//에러가 발생할 수 밖에 없다. 이유 : outOfBounds(지정된 범위에 들어가지 않았기 때문에) 고정되어 있다.

		int[][] score = { { 50, 30 }, 
							{ 30, 50 }, 
							{ 100, 80 } };
		for (int[] is : score) {
			for (int is2 : is) {
				System.out.println(is2);
			}
		}
		System.out.println(score[1][0]);//국어점수

	}
}
