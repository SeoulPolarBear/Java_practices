/**
 * 
 */

 //5.연산자
 // 산술 연산자: + - * / %

//거듭제곱
let num1 = (2 ** 3);
alert(num1);
 
 //우선순위
 // (*,/) > (+,-)
 
 //연산자를 줄여서 쓰는 것도 가능 O
 let num2 = 10;
 num2 = num2 + 5;
 num2 += 5;
 
 //증감 연산자
 let num3 = 20;
 num3++;
 document.write(num3);
 
 let result = num3++;// num3 를 변수에 저장하고 증가
 document.write(num3);
 
 result = ++num3;// num3 를 증가시키고 변수에 저장
 document.write(num3);
 
 //비교 연산자(JAVA때와 같음 !)
 // < > <= >= == !=
 
 //"10"과 10이 맞는지 확인
 //형변환이 자동으로 일어난다.
 document.write("10" == 10);//true (o)
 //형또한 반환해서 자료형이 다르면 false를 출력한다.
  document.write("10" === 10);//false (x)
 // -> ===, !== : 일치연산자 / 자료형까지도 비교를 해줌 / 꽤나 유용함
 
 //논리연산자
 // ||(or)
 // => 첫번째 true 값을 발견하면 즉시 멈춤
 
 // &&(and)
 // => 첫번째 값이 false 값이면 즉시 멈춤
 
 // ! (NOT)
 // true -> false, false -> true
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 