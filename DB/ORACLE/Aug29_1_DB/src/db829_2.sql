--[옵션]
--제약조건(constraint) 이라고 부름
--데이터 무결성을 보장하기 위한 용도 
--데이터 무결성 : 데이터베이스에 저장된 데이터와 일관성과 정확성을 지키는 것

	--	1. 도메인 무결성 제약 조건(Domain Constraint)
		--	테이블 내의 튜플들이 각 속성의 도메인에 지정된 값만 가져야 한다는 조건
			--데이터 타입(type), 널(null / not null), 기본값(default), 체크(check) 등을 활용해서 지정
			
	--	2. 개체 (기본키와 엔티티) 무결성 제약조건
	--		기본키 제약(Primary key Constraint)이라고도 함
	--		개체(entity) : 사람, 장소, 사물, 사건 등과 같이 독립적으로 존재하면서, 고유하게 식별이 가능한 단위
	--				즉, 모든 record들(튜플들)을 개체라고 생각하면 되겠다. 개체(속성1, 속성2, ...)
	--				아무리 많은 개체가 있어도, 내가 원하는 '유일한' 개체를 발견할 수 있어야 한다!				
	--				테이블은 기본키를 지정하고 , Null값을 가져서는 안되며,
	--				테이블내에 오직 하나의 값만 존재해야 한다는 조건.
	
	--	3. 참조(외래키) 무결성 제약조건
--			외래키 제약(Foreign key constraint)이라고도 하며,
--			테이블 간의 참조 관계를 선언하는 제약 조건
--			참조 받는 테이블의 외래키는 참조하는 테이블의 기본키와 동일해야 하며,
--			참조 받는 테이블의 값이 변경 될 때, 참조하는 테이블의 제약을 받는 것.

------------------------------------------------------------------------------------------------------------------------------
--1. Not Null : NULL은 값이 비어있다는 뜻!
--				=> 0이나 띄어쓰기도 아닌 정말 값을 넣지 않은 상태
--				NULL을 허용하지 않는다.
--					=> 필수적으로 입력해야 할 컬럼에 설정한다.
--					=> 가장 많이 사용되는 제약 조건!!
--				: 테이블을 만들 때 가급적 값이 들어가게 해줬으면 좋겠음~

-- 제약조건명을 따로 부여하지 않는 경우(Oracle이 자동으로 부여)
create table example1(
	col1 varchar2(10),
	col2 varchar2(10 char) not null-- is는 생략이 가능하다.	
);

--Constraint 키워드를 사용해서 제약조건명을 따로 부여하는 경우
create table example2(
	col1 varchar2(10 char),
	col2 varchar2(10 char)
	constraint col2_notnull not null
);

create table example2_1(
	col1 varchar2(10 char),
	col2 varchar2(10 char)
	constraint col2_1_notnull not null
);

--2. Unique : 단어 뜻 그대로 해당 컬럼에 들어가는 값이 전체 테이블에서 유일해야 한다는 조건
--			Not Null과 함께 사용이 가능하지만, Unique는 많이 사용되지는 않는다.
create table example3(
	col1 varchar2(10 char) unique,
	col2 varchar2(10 char) unique not null,
	col3 varchar2(10 char),
	constraint col3_unique unique(col3)
);

--select * from all_tables;

--3. Primary Key(기본 키) : NULL을 허용하지 않고, 중복된 데이터를 허용하지 않는다
--		(Not NULL + Unique => primary key) 따라서 primary key를 사용하면 not null 사용하지 않아도 된다.
--		데이터의 특정 조건을 검색하거나 수정 등의 작업을 할 때 기본 키로 구분한다.
--		ID, 주민등록번호, 회원 번호, 글 번호 등
--		일반적으로 테이블에는 1개의 기본키를 무조건 가졌으면 좋겠음!

create table example4(
	col1 varchar2(10 char) primary key,
	col2 varchar2(10 char) not null,
	col3 varchar2(10 char) not null
);
--여러 컬럼을 묶을 때 constraint 키워드를 사용 + 하지만 PK는 가급적 하나였으면...!
create table example5(
	col1 varchar2(10 char),
	col2 varchar2(10 char) not null,
	col3 varchar2(10 char) not null,
	constraint PK_example5 primary key(col1, col2)
);

--** 진짜 어려움
-- 4. Foreign Key(외래 키) : 다른 테이블의 특정 컬럼을 조회해서 동일한 데이터가 있는 경우에만 입력이 허용된다.
--			참조하는 테이블은 PK나 Unique로 지정된 컬럼만을 FK로 지정할 수 있다.
--			외래키 설정을 위해서는 참조받는 컬럼이 먼저 생성되어야 하고,
--			외래키를 심을 테이블이 그 이후에 생성이 되어야 한다.

--외래키를 심을 테이블의 형식
create table example6(
	컬럼명 자료형,
	constraint FK명 foreign key(컬럼명)
	references 대상테이블명(대상테이블의 기본키 or 고유키) 
	on delete set null || on delete  cascade
	--참조받는 테이블에서 행 부분을 지웠을 때 
	--이 테이블에서 연결되어 있는 행에 대해서
	--on delete set null : Null값을 먹일지
	--on delete  cascade 그 행도 같이 지울지에 대한 옵션
	
	-- 참고로 cascade 하면 그 record가 전부 지워진다.
	
	--이때 update를 할 시 오류가 발생한다. 즉, on update는 존재 하지 않는다.
	--따라서 값은 고정이 되어있게 되고 값은 불변이 되어버린다.
	--따라서 table을 새로 만드는 불편함을 가지고 있다.
);

create table example6(
	ex6_id varchar2(10 char) primary key
);

insert into example6 values('10');
insert into example6 values('20');
insert into example6 values('30');

select * from example6;

create table example7(
ex7_id varchar2(10 char),
constraint fk_ex7 foreign key(ex7_id) references example6(ex6_id) on delete cascade
--,constraint pk_ex7 primary key(ex7_id)
);


insert into example7 values('10');
insert into example7 values('20');
insert into example7 values('30');
insert into example7 values('40');

delete from example6 where ex6_id = '10';

delete from example6 where ex6_id = '40';

drop table example7;

select * from example7;

--drop table example1 cascade constraint purge; 
--drop table example2 cascade constraint purge; 
--drop table example2_1 cascade constraint purge; 
--drop table example3 cascade constraint purge; 
--drop table example4 cascade constraint purge; 
--drop table example5 cascade constraint purge; 
--drop table person cascade constraint purge; 
--drop table test3 cascade constraint purge; 
---------------------------------------------------------------------------------------------------------
--5. Check : 데이터의 값의 범위나 조건을 설정해서 조건에 해당하는 데이터만 허용한다.
create table example8(
	col1 number(3) constraint ex8_check check (col1 between 1 and 9)
);

drop table example8 cascade constraint purge;

--6. default : 아무런 데이터를 입력하지 않은 경우 지정한 데이터가 자동으로 입력됨
create table example9(
	col1 number(4) default 999 
);

insert into example9 values(default);
insert into example9 values();-- 이건 안됨
insert into example9 values(null);
insert into example9 values(0);
insert into example9 values(11);

select * from example9;












