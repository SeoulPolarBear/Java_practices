/**
 * 
 */
//논리연산자, 비교연산자, 일치연산자 결과값으로 나온 true, false를 가지고
//6. 조건문
//		어떤 조건에 따라서 이후에 실행이 달라지게 하는...

//if문(Java와 같다.)
//	if절 괄호안에 조건을 따져서 true라면 실행하게끔!
//	if - else if - else 

// switch-case
// case가 다양할 때, 보다 간결하게 나타낼 수 있다.라는 장점이 있다.
let fruit = prompt("과일을 입력하세요");

switch(fruit){
	case "사과":
	alert("100원");
	break;

	case "바나나":
	alert("200원");
	break;

	case "키위":
	alert("300원");
	break;

	case "멜론":
	case "수박":
	alert("500원");
	break;
}