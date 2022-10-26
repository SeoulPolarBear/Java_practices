create table aug29_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null,
	c_kcal number(3) not null,
	c_start date not null
);

insert into aug29_coffee values('아메리카노', 3000, 15, sysdate);
select * from aug29_coffee;

--DDL 에서 Create문을 다룰 수 있게 되었음!
--이제 비교적 쉬운 alter/ drop/ truncate를 보자!

-- 1. 데이터 타입 변경 / 컬럼의 크기(용량) 변경
--alter [table명] modify [변경할 컬럼명] [데이터타입(용량)];
--도메인 무결성 제약 조건 때문에 발생하는 에러
alter table aug29_coffee modify c_name number(10);--에러 값이 들어 있는 상태에서 domain을 변경하려고 했기 때문이다.
alter table aug29_coffee modify c_name varchar2(2 char);--에러 용량이 넘어서 값이 존재하기 때문에

-- 주의사항 : 데이터타입을 변경할 때는 해당 컬럼의 값을 모두 지워야 변경이 가능하다.
-- 그렇지 않으면 오류가 발생!
-- 컬럼의 용량을 줄일 경우 해당 커럼의 용량을 조회해서 변경할 길이보다
-- 큰 값이 있는지 확인하고 => 그 값을 변경하면 된다.

--2. 컬럼명 변경
alter table [테이블명] rename column [기존 컬럼명] to [바꿀 컬럼명];

alter table aug29_coffee rename column c_name to c_name2;

select * from aug29_coffee;

--3. 컬럼 추가
alter table [테이블명] add [컬럼명] [데이터타입] [제약조건(생략가능)];
truncate table aug29_coffee;
alter table aug29_coffee add c_taste varchar2(20 char) not null;-- 단 not null을 넣을려면 기존에 data가 없어야 한다.
insert into aug29_coffee values('아메리카노', 3000, 15, sysdate, '조금의 산미');


--4. 컬럼 삭제
alter table [테이블명] drop [컬럼명];
alter table aug29_coffee drop column c_taste;
------------------------------------------------------------------------------------------------------------------
--테이블 내의 내용 지우기
truncate table [테이블명];
truncate table aug29_coffee;
--테이블에 있는 데이터를 삭제하지만, 테이블의 구조 자체는 삭제하지 않음

--테이블 삭제시(휴지통에 넣기)
drop table [테이블명] cascade constraint;
drop table aug29_coffee cascade constraint;

--휴지통에 있는 테이블을 복원
flashback table [테이블명] to before drop;
flashback table aug29_coffee to before drop;

--휴지통 비우기
purge recyclebin;

--휴지통에 넣기 + 비우기 => 테이블 완전 삭제 (휴지통에 저장되지 않음)

drop table [테이블명] cascade constraint purge;
drop table aug29_coffee cascade constraint purge;
--------------------------------------------------------------------------------------------------------------------
--DDL : 사실상 신입한테 맡기지 않음!
-- 경력있는 DBA들이 테이블을 만들어서 CRUD정도만 하게끔 할 것



