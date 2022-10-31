/**
 * 
 */
 
 //4. 형 변환
 // String() -> 문자형으로 변환
 //Number() -> 숫자형으로 변환
 //Boolean() -> 논리형으로 변환
 
 //형 변환은 왜 필요할까요 ~ ?
 //	자료형이 다른 두 변수를 계산했을 때, 원하는 결과가 나오지 않을 수 있음...
 // 수학, 영어점수를 입력 받아서 평균 점수를 출력해주는 프로그램
 // 출력 (document.write)
 
let math  = prompt("수학 점수를 입력하세요.")
let English  = prompt("영어 점수를 입력하세요.")
//자동형 변환
// "80" + "90" = "8090"
//숫자형이 아니더라도 표현식(+,-,*,/)을 활용했을 때 숫자형으로 변환할 수 있다면
//자동으로 형 변환이 되어서 계산이 됨
//'자동 형 변환'이라고 함

//자동 형변환이 좋아보이지만
//원인을 찾기 힘든 에러를 발생시킬 여지도 충분히 있음...
//	=> 항상 의도를 가지고 원하는 타입(자료형)으로 변환해서 사용하는 것이 좋다.
//		'명시적 형 변환'
let sum = math + English;
let avg = sum / 2;
 document.write(avg + "<br>");
 document.write(math + "<br>");
 document.write(English + "<br>");
 
 
 document.write("String() <br>");
 document.write(
	String(3) + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(null) + "<br>",
	String(undefined) + "<br>"
);

//Number() : N은 대문자 ! / 괄호안의 값을 숫자형으로 바꿔줌
document.write("Number() <br>");
document.write(
	Number("1234") + "<br>",
	Number("asdfa") + "<br>",
	String(true) + "<br>",
	String(false) + "<br>",
	String(undefined) + "<br>"
);
 
 //Boolean() : B는 대문자 / 괄호안의 값을 논리형으로 바꿔줌
 //false를 알아두면...
 //	-숫자 0
 //	-빈 문자열("")	/	띄어쓰기 X
 //	-null
 //	-undefined
 //	-NaN
 //이외에는 모두 true가 됨!
 
 //주의사항 -> 딱히 설명이 없어서... 인지해두시는게 좋겠어요...
Number(null);//	0
Number(undefined);//	NaN


let a = Number(prompt("asdf"));
document.write(a + "<br>");//확인(""), 취소(null) 모두 0 
 
 
 
 
 
 
 
 
 
 
 
 
 
 