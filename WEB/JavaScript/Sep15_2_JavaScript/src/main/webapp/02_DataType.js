/**
 * 
 */
//2. 자료형
//String
 
let name1 = "polarbear";
let name2 = 'polarbear';
let name3 = `polarbear`;// backtick이라고 한다.

let message1 = "I'm a boy.";
let message2 = 'I\'m a boy.';// 작은 따옴표를 사용시 \ 역슬래시를 넣으면
							// '를 특수문자로 인식함
							
//문자열 내부에 변수를 표현할 때 사용하면 좋은 backtick !!
//	${변수명}을 넣어서 표현함 (backtick에서 밖에 사용할 수 없다.)
let message3 = `My name is ${name1}`;
let message4 = "My name is ${name1}";
document.write(message3 + `<br>`);
//${name1이 그대로 노출 됨}
document.write(message4 + '<br>');

//계산 (표현식)도 사용가능 O
document.write(`9 + 10 = ${9 + 10}<br>`);


//숫자형 Number (정수 / 실수)
let age = 100;
let height = 187.3;

//역시나 사칙연산이 가능 O
document.write(1 + 2 + "<br>");
document.write(1 - 2 + "<br>");
document.write(1 * 2 + "<br>");
document.write(1 / 2 + "<br>");
document.write(1 % 2 + "<br>");

let a = 1 / 0;
document.write(a + "<br>");
// 결과 : Infinity


let b = name1 / 2;
document.write(b + "<br>");
// 결과 : NaN(Not a Number)

//글자끼리 이어주기도 가능 O
let aa = "나는" ;
let bb = "입니다.";

document.write(aa + name1 + bb + "<br>");
document.write(aa + name1 + "살" + bb + "<br>");

// 논리형 Boolean
let c = true;	//참
let d = false;	//거짓

document.write((name1 == "polarbear") + "<br>");
document.write((age < 20) + "<br>");

//null, undefined
let e;
let f =null;
document.write(e + "<br>");// undefined : 값이 항당되지 않은 상태
document.write(f + "<br>");// null : 존재하지 않는 값

//typeof 연산자 : 변수의 자료형을 알아낼 때 사용
//직접 코드를 짰으면 당연히 이 연산자는 쓸모 X
//다른 개발자가 코드를 짰을 때, 변수에 대한 데이터타입(자료형)을
//알아야 할 때
// or API를 통해서 받아온 데이터의 자료형을 알아내서 다른 방식으로
//처리해야 할 때 자주 사용

document.write(typeof name1 + "<br>");
document.write(typeof age + "<br>");
document.write(typeof c + "<br>");
document.write(typeof e + "<br>");
document.write(typeof f + "<br>");// 결과 : Object 버그 때문
















