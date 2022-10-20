
public class PMain4 {
public static void main(String[] args) {
	String[] ss = {"ㅋㅋ", "ㅎㅎ", "ㅇㅇ","^_^"};
	//for-each 문(신형 for 문)
	//배열의 요소를 변경할 때는 사용 X
	//		:원본을 쓰는게 아닌 임시로 복사해다 쓰는 개념이라
	//		:원본에는 영향 X!
	//	순서의 조절 불가능, index 사용 불가
	//for(자료형 변수명 : 배열){내용;}
	for (String s2 : ss) {//배열 ss의 요소를 s2라는 그릇에 다 담음
		System.out.println(s2);//출력 (배열의 요소 순서대로)
	}
}
}
