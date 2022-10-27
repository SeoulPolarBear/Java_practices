--계정생성, 권한부여, tablespace
--테이블, 행, 열, 스키마, 인스턴스, 도메인
--sql의 명령문 중 정의어(DDL)를 배우면서 테이블을 만들어와 봤고
--테이블 생성시 필요한 자료형(주력으로 사용한 것만)
-- 문자형 : varcha2 / 숫자형 : number / 날짜 : date
--	문자형 varchar2에 용량 입력할 때는 char를 넣어서 글자 단위로 넣을 수 있게 하자!
--	숫자형 number에 용량 입력할 때는 정밀도 / 범위 잘 조절해서 만들자!
-- 	날짜 date...는 조만간 볼 것!
--상당히 어려웠던 제약 조건 ! /not null, primary key, foreign key
--table의 구조를 수정하거나, 삭제해보면서 DDL 완료!

-- 과자 테이블을 만들건데
-- 과자 이름, 회사, 가격 정보를 넣고 싶다
-- 테이블 하나에 PK 하나 있었으면...! => 어디에 PK를 먹일지 생각해보면서!

--초코파이 -> 회사 : 오리온 / 롯데 => 과자이름 : 단일한 값이 될 수 없음 (PK x)
--회사 이름 : 한 회사에서 한가지 종류의 과자만 만드는 것은 아니니까(PK x)
--PK를 어디에
--번호값을 만들어서 여기에 PK를 주는 것도 한 방법!

create table snack(
s_code number(4) primary key,
s_name varchar2(10 char) not null,
s_company varchar2(10 char) not null,
s_price number(4) not null
);

-------------------------------------------------------------------------------------------
--그래서 오늘은 DML을 다뤄볼 것!
--DML은 데이터 조작어(Data manipulation Language)라고 하고,
--테이블에 데이터를 검색, 삽입, 수정, 삭제 하는데 사용되는 문장
--select, insert, update, delete 등이 있고,
--줄여서 CRUD (CREATE, READ,UPDATE,DELETE)라고 함
--여기서 C는 (insert)
--형태는
insert into 테이블명(컬럼명, 컬럼명, ...) values(값, 값, ...);

insert into snack(s_code,s_name,s_company,s_price) values(1000,'홈런볼','해태',1500);
--순서대로 넣어주면 컬럼명 생략 가능
insert into snack values(1000,'홈런볼','해태',1500);

--컬럼 순서 바꿔도 됨

insert into snack(s_code,s_price,s_name, s_company) values(1000,1500,'홈런볼','해태');

--컬럼에 값 안 넣기 - 오류 not null이기 때문에/not null이 없었으면 가능 했다, 지정해 주지 않은 값에 대해서 null이 들어감
insert into snack(s_code,s_price) values(1000,1500);

--테이블 지우고
drop table snack cascade constraint purge;
--다시 테이블 생성해서 값 5개정도 넣어 보자
insert into snack values(1000,'홈런볼','해태',1500);
insert into snack values(1001,'포카칩','오리온',1500);
insert into snack values(1002,'눈을 감자','오리온',1500);
insert into snack values(1003,'프링글스','켈로그',1500);
insert into snack values(1004,'치토스','프리토레이',1500);

select * from snack;

--그런데... 지금이야 5개 넣어서 일일히 과자들 번호값을 주면 됐는데
--과자의 종류가 엄청나게 많이 있다.

--과자 데이터 계속 넣다가 나중에 몇 번인지 잊어버리면...
--데이터를 만들때마다 과자의 번호가 자동으로 계산이 되었으면 좋겠다.

-- factory pattern이라고 해서 말 그대로 공장화 시스템 !
-- MySQL : autoincrement 옵션
-- 현재 우리가 사용하는 oracleDB : Sequence라는 것이 있음
-- 번호를 순서에 맞게 자동으로 생성해주는 건데
-- 테이블과는 무관하고, 단점으로는 insert에 실패해도 sequence 값은 무조건 올라간다.
-- 그리고 증가된 값(sequence 값)을 다시 내릴 수 없다.

-- sequence(table과는 무관한)생성
create sequence 시퀀스명();--간단한 시퀀스
create sequence snack_seq;--테이블명_seq로 보통 이름을 짓는다.

--구체적인 시퀀스
create sequence 시퀀스명
	increment by 1  -- 증가값 (1씩 증가)
	start with 1    -- 시작값
	minvalue 1      -- 최소값
	maxvalue 999    -- 최대값
	nocycle / cycle -- 최대값에 도달하면 시작 값부터 다시 반복할지 말지 결정
	nocashe / cashe -- 시퀀스를 미리 만들어 놓고 메모리에서 가져다 쓸지 말지
	noorder / order;-- 요청 순서대로 값을 생성할지 말지
	
--sequence 삭제

drop sequence 시퀀스명;
drop sequence snack_seq;

--sequnece 사용 : 시퀀스명.nextval
--기존에 있던 테이블 삭제했다가 다시 만들어서 값을 넣어 봅시다.!

insert into snack values(snack_seq.nextval,'포카칩','오리온',1500);
insert into snack values(snack_seq.nextval,'눈을 감자','오리온',1500);
insert into snack values(snack_seq.nextval,'프링글스','켈로그',1500);
insert into snack values(snack_seq.nextval,'치토스','프리토레이',1500);

select *from  snack;

drop sequence snack_seq;
drop table snack cascade constraint purge;

--이제 다시 테이블이랑 시퀀스 지워주고, 테이블 다시 만들때 속성 추가! (유통기한 Date)

create table snack(
s_code number(4) primary key,
s_name varchar2(10 char) not null,
s_company varchar2(10 char) not null,
s_price number(4) not null,
s_exp date not null
);

create sequence snack_seq;

--현재 시간 날짜 --------------------------------------------------------------------------
select sysdate from dual;
insert into snack values(snack_seq.nextval, '새콤달콤 딸기맛', '크라운', 500, sysdate);

select * from snack;

--특정시간 / 날짜 -----------------------------------------------------------------------------
--		내장함수 - to_date('값','패턴')
--		패턴(대문자) - YYYY, MM, DD, AM/PM, HH(12시간), HH24(추천), MI(분), SS(초)

insert into snack values(snack_seq.nextval, '새콤달콤 딸기맛', '크라운', 500, 
to_date('2023-10-4 14','YYYY-MM-DD HH24'));

--이제 막 값들을 넣어 주자


insert into snack values(snack_seq.nextval, '오징어집', '농심', 1500, 
to_date('2023-11-23 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '꼬깔콘 군옥수수맛', '롯데', 1500, 
to_date('2023-2-10 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '오 감자 오리지널', '오리온', 1500, 
to_date('2023-3-22 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '콘초 헤이즐넛 초코', '크라운', 1500, 
to_date('2022-12-24 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '콘칩 군옥수수맛', '크라운', 1500, 
to_date('2023-10-22 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '허니버터칩', '해태', 1600, 
to_date('2023-8-14 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '감자깡', '농심', 1400, 
to_date('2022-12-4 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '고구마깡', '농심', 1400, 
to_date('2022-12-4 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '닭다리 불바베큐', '농심', 1200, 
to_date('2022-12-25 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '매운 새우깡', '농심', 1300, 
to_date('2023-4-28 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '바나나킥', '농심', 1700, 
to_date('2023-6-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '알새우칩', '농심', 1500, 
to_date('2023-9-14 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'포카칩','오리온',1500,to_date('2023-12-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'눈을 감자','오리온',2500,to_date('2023-11-10 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'프링글스','켈로그',1500,to_date('2023-5-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'치토스','프리토레이',1500,to_date('2023-6-30 14','YYYY-MM-DD HH24'));

insert into snack values(snack_seq.nextval,'포카칩 대용량','오리온',3000,to_date('2023-12-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'눈을 감자 대용량','오리온',3000,to_date('2023-11-10 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'프링글스 미국맛','켈로그',3000,to_date('2023-5-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'치토스 대용량','프리토레이',3000,to_date('2023-6-30 14','YYYY-MM-DD HH24'));

--====================================================================================================================================================
--R(Read)
select [distinct] [컬럼명], [컬럼명 as 별칭 || 컬럼명 별칭], [연산자 사용], [통계함수],...
from [테이블명]
where [조건식]
group by [조건식]
having [함수 포함 조건]
order by [정렬대상 ASC/DESC(오름차순 / 내림차순)] --기본값은 오름차순

--과자테이블 전체 조회
-- '*' : 테이블 내의 모든 컬럼을 가져온다.
select * from snack;
----------------------------중복 제거 후 select------------------------------------------------
select distinct s_company from snack;


----------------------------컬럼명 as 별칭 || 커럼명 별칭 select-------------------------------
--별칭 같은 경우에는... select문 안에서 숫자 계산이 가능한데(+,-,*,/)
select s_company / 100 from snack;
--컬럼명 자체가 s_price/100으로 나옴
--실제 프로그래밍 언어와 연동하다보면 컬럼명을 이용해서 값을 불러오는 경우가 있는데,
--별칭이라는 것을 써서 헷갈림을 방지하는 용도로 사용

--AS를 써서 하는 법
select s_price / 100 as s_percent from snack;
--컬럼명 띄어쓰기하고 바로 별칭쓰는 법
select s_price / 100 s_percent from snack;


----------------------------연산자 사용 select------------------------------------------------
--연산자! (산술연산자)
--Dual 테이블
--1. 오라클 자체에서 제공해주는 더미테이블
--2. 간단하게 함수를 이용해서 계산 결과 값을 확인 할 때 사용하는 테이블
select 1 + '3' as result from dual;
--4가 나옴!
--대부분 다른 언어들 같은 경우에는 '문자 우선' 13이라는 결과가 나오는데
--오라클에서는 반대로 '숫자 우선'
--오라클내에서는 연산자가 숫자만 연산 해줌
select 1 + 'a' from dual; --에러 (숫자로 바꿀 수 없다는 에러 'invalid number')
select 'a' + 'b' from dual;--에러 (숫자로 바꿀 수 없다는 에러 'invalid number')
select 'b' from dual;--결과 b
--문자를 더해주기 위한 연산자가 따로 있는데
--바로 ||
select 1||'a' as result from dual;












