--테이블 스페이스 : 이거 함부로 지우지 마세요!

--[테이블]을 만들어보자!
--테이블의 기본적인 구조
create table 테이블명(
	컬럼명 자료형 [옵션],--옵션 : 필요하면 넣는거!
	컬럼명 자료형,
	...
);

-- 자료형 (데이터 타입)
-- 크게 3가지의 타입으로 나눌 수 있음

-- 문자형
--		char(용량)
--			무조건 지정한 "용량"대로 저장
--			용량이 비어있다면 5 char 가능한데 3 char만 넣었으면 나머지 2char의 용량은 space로 용량을 매꿔준다.
--			처리 속도가 빠르다 !
--			글자수가 정해져 있다면 char 활용 O
--			ex) 성별, 주민번호, 핸드폰 번호,....



--		varchar2(용량) : 사용이유 동시성 제어 및 가변성 메모리를 가지고 있어서
--			정해진 용량만큼 데이터를 안 넣으면
--			그 용량을 조절해서 저장(용량 범위 안에서 자유자재로 사용 가능)
--			주력으로 사용!
--			용량을 조절하는 만큼 처리속도가 느리다!
--				ex) 이름, 주소, ...
---------------------------------------------------------------------------------------------------------------------
-- 문자형 용량
--		varchar2(5) 총 5byte 사용 가능

--			영어, 숫자, 띄어쓰기는 1byte
--			한글 한글자는 3byte
--			글자수 계산하기가 애매...
--		varchar2(5 char)
--			한글/영어 5글자 -> 최대 15byte 
--		=> 문자형 자료형을 쓸 때는 용량에 char를 넣어서 쓰자!

create table test(
	t_name varchar2(5)
);

create table test2(
	t_name varchar2(5 char)
);

insert into TEST values('가나다');
insert into Test2 values('가나다');

select * from test;
select * from test2;



drop table test cascade constraint purge;
drop table test2 cascade constraint purge;

--======================================================================================================================
-- 숫자형
--		NUMBER(P, S) : 십진수 기준
--		P : 정밀도(Percision)	/	S : 범위 (Scale)
--			P는 소수점 기준 모든 유효숫자를 의미한다.(즉, 소수점 포함 입력 값의 총 자릿수 이다.)
--			만약 P에 명시한 것보다 큰 숫자값을 입력하면 오류가 발생한다.
--			S가 양수면 소수점 이하, 음수면 소수점 이상(소수점 기준 왼쪽)
--			의 유효숫자 자릿수를 나타낸다.
--			S에 명시한 숫자 이상의 숫자를 입력하면, S에 명시한 숫자로 반올림 처리한다.(소수이므로)
--			S에 음수면 소수점 기준 왼쪽 자릿수에서 반올림한다.
--			P가 S보다 크면 S는 소수점 이하 유효숫자 자릿수를 나타낸다. (즉, P를 기준으로 표현을 해주는게 더 중요하다.)

--			값이 123.54인데 (즉, 정수 값들은 전부 반영이 되어야 한다.)
--			number(3)		-> 124(s쪽은 명시 않아서 0,p가 3) p가 3이라서 소수점 첫자리에서 반올림
--			number(3,2)		-> 오류! (p가 3이고 , 123.54는 유효 숫자가 다섯자리여서 오류, 유효 숫자가 p보다 크면 오류 발생 3.54) 
--			number(5,2)		-> 123.54
--			number(7,1)		-> 123.5 (s가 1이고, 소수점 둘째자리가 반올림 되서 5)
--			number(7,-1)	-> 120 ((123.54 -> 자릿수 : -2,-1,0|. 기준 |1,2,) s가 -1이고, 소수점 왼쪽 첫자리 3이 반올림 되어서 120)
select cast(123.53 as number(3,0)), cast(123.53 as number(3)) from dual; --새로운 table 만들어서 select

create table test3(
t_number number(4,1)
);

insert into test3 values(123.54);

select * from test3;


--		FLOAT(P) : Number의 하위타입 + 이진수 기준
create table testNum(
	t_num number(5),
	t_flo float(5)
);

insert into testNum values(12345,12345);
insert into testNum values(12345,667341234);
insert into testNum values(12345,66734123456712423451324632);
select * from testNum;

drop table testNum cascade constraint purge;

--5자리 10진수가 아닌, 5자리 2진수(ex : 10110)을 의미한다.
	--2진수를 10진수로 변경을 하려면 약 0.3정도를 곱하면 되는데,
	--5 * 0.3 = 1.5
	--결국 float(5)는 10진수로 실제로 보면 float(2)(1.5를 반올림해서 2가 되었음)
	--12345 중 앞의 두자리 12만 제대로 나오고, 나머지 345sms 0으로 채워진 형태
	-- => 사실상 오라클에서는 number형만 사용해도 되며,
	--	크기 설정에 있어서 p와 s를 적절히 조절하면 됨!***
	--------------------------------------------------------------------------------
-- 날짜
--		Date : 연도, 월, 일, 시, 분, 초까지 입력 가능
--		Timestamp : 연도, 월, 일, 시, 분, 초, 밀리초까지 입력이 가능
--
--		=>주력은 Date ! java에서 Date로 사용했기 때문
--		=> java.util.Date / java.sql.Date
	--------------------------------------------------------------------------------

















