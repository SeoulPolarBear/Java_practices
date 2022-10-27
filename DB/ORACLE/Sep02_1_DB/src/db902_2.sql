--JOIN
-- 하나의 명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능
-- 마치 하나의 테이블인 것처럼 보여줌

create table tb1 (name varchar2(10 char), age number(3));
create table tb2 (name varchar2(10 char), age number(3));

insert into tb1 values('김수학',30);
insert into tb1 values('박수학',31);
insert into tb1 values('차수학',35);
insert into tb1 values('오수학',39);

insert into tb1 values('안컴공',45);
insert into tb1 values('한컴공',50);

insert into tb2 values('안컴공',40);
insert into tb2 values('한컴공',55);
insert into tb2 values('박컴공',50);
insert into tb2 values('하컴공',44);

insert into tb2 values('김수학',35);
insert into tb2 values('박수학',40);

------------------------------------------------------------------------------------------------------
-- cross join : 별도의 조건 없이 두 테이블간의 가능한 모든 결과를 조회(모든 경우의 수)
--사실상 안쓴다.
select * from tb1,tb2;
select * from tb1 cross join tb2;

--inner join : 조건에 해당하는 값만 나옴
select * from tb1 inner join tb2 on tb1.name = tb2.name;
select * from tb1 A, tb2 B where A.name = B.name;		--EQUI 조인(동등 조인)
select * from tb1 join tb2 using (name);				--EQUI 조인 JOIN ~ USING(조인대상컬럼명)
select * from tb1 natural join tb2; 					--자연 조인, 조건절 없이 양쪽에 같은 이름을 가진 동일한 컬럼만을 조회

--outer join : outer join을 사용하는 이유는 기준 테이블의 데이터가 모두 조회(누락 없이) 되고,
--				대상 테이블에 데이터가 있는 경우 해당 컬럼의 값을 가져오기 위해서!
--	(+)를 이용한 outer join : null이 출력되는 테이블의 컬럼 (+) 기호 추가

-- left outer join : 왼쪽 테이블에 값이 있을 시 오른쪽 테이블이 조건에 맞지 않아도 나옴
--						(조건에 맞지 않으면 null로 메꿈)
--						Right 보다는 Left를 더 많이 씀(왼쪽 테이블을 기준으로 두는 경향 O)
select * from tb1 left outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name = tb2.name(+);


--right outer join : 오른쪽 테이블에 값이 있을 시 왼쪽 테이블이 조건에 맞지 않아도 나옴
--						(조건에 맞지 않으면 null로 메꿈)
select * from tb1 right outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name(+) = tb2.name;

--full outer join : 한쪽 테이블에 값이 있을 시, 다른 쪽 테이블이 조건에 맞지 않아도 나옴
--						(조건에 맞지 않으면 null로 메꿈)
select * from tb1 full outer join tb2 on tb1.name = tb2.name;

--self join ** 헷갈림
--하나의 테이블 내에 있는 컬럼끼리 연결하는 조인이 필요한 경우
--단어 그대로의 뜻 처럼 스스로 JOIN한다는거!

--한 웹사이트에 회원이 5명이 있고, 관리자가 2명이 있다.
--회원의 이름은 각각 회원1~5, 관리자의 이름은 관리자1,2
--회원의 아이디는 각각 member1~5, 관리자의 아이디는 manager1, 2
--회원 1~3번은 관리자 1이 관리 / 나머지 회원은 관리자 2가 관리

create table sep02_member(
	m_id varchar2(10 char) primary key,
	m_name varchar2(10 char) not null,
	m_manager varchar2(10 char) --관리자들은 관리를 안받으니 제약 조건 X
);

insert into sep02_member values('member1', '회원1', 'manager1');
insert into sep02_member values('member2', '회원2', 'manager1');
insert into sep02_member values('member3', '회원3', 'manager1');
insert into sep02_member values('member4', '회원4', 'manager2');
insert into sep02_member values('member5', '회원5', 'manager2');
insert into sep02_member values('manager1', '관리자1', null);
insert into sep02_member values('manager2', '관리자2', null);

select * from sep02_member;

-- 각 관리자가 어떤 회원을 관리하는지 알고 싶음
--select *
--	from sep02_member A join sep02_member B on A.m_id = B.m_id; 

	select A.M_ID, A.m_name, b.m_id
	from sep02_member A inner join sep02_member B on A.m_id = B.m_manager; 
	-- 같은 테이블이지만 셀프조인을 하기 위해
	-- 테이블에 별칭을 넣어서 구분해줌
	-- 계정 ID와 관리자 계정이 같은 
	-- 값들을 연결해서
	-- 관리하는 회원 ID 값을 가져올 수 있게!
																










