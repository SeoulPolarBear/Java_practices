-- 배추, 3000g, 10000원, 홈플러스, 판교점, 1000평, 주차장 500석
-- 무, 500g, 5000원, 홈플러스, 강남점, 500평, 주차장 300석
-- 배추, 2000g, 5000원, 이마트, 서초점, 800평, 주차장 800석
-- 마트 데이터가 없어지면 거기서 파는 물건도 없어지게끔.
-----------------------------------------------------------------------

create table sep05_market (
	m_no number(4) primary key,
	m_name varchar2(10 char) not null,
	m_location varchar2(5 char) not null,
	m_land number(5) not null,
	m_parking number(4) not null
)
create sequence sep05_market_seq;
drop sequence m_no_seq;

insert into sep05_market values (sep05_market_seq.nextval, '홈플러스', '판교', 1000, 500);
insert into sep05_market values (sep05_market_seq.nextval, '홈플러스', '강남', 500, 300);
insert into sep05_market values (sep05_market_seq.nextval, '이마트', '서초', 800, 800);

select * from sep05_market;
----------------------------------------------------------------------------------------------
create table sep05_product (
	p_no number(4) primary key,
	p_name varchar2(10 char) not null,
	p_weight number(4) not null,
	p_price number(5) not null,
	p_m_no number(3) not null, 
	constraint fk_sep05_product foreign key(p_m_no)
		references sep05_market(m_no)
		on delete cascade
);
create sequence sep05_product_seq;
drop sequence v_no_seq;

insert into sep05_product values (sep05_product_seq.nextval, '배추', 3000, 10000, 1);
insert into sep05_product values (sep05_product_seq.nextval, '무', 500, 5000, 2);
insert into sep05_product values (sep05_product_seq.nextval, '배추', 2000, 5000, 3);

select * from sep05_product;

---------------------------------------------------------------------------------------------
-- create table - DBA 의 역할
-- drop table	- DBA 의 역할
-- create sequence	-DBA의 역할
-- 계정 하나로 여러명 사용 가능
-- 회사가면 개발자용 계정을 알려줌 -> 위의 작업들 권한은 없을 듯
---------------------------------------------------------------------------------------------
-- C - insert
--			sequence사용, 날짜 집어넣고, ...
-- R - select
--			거의 대부분의 시간을 할애함
-- U - update
update 테이블명
	set 컬럼명 = 값, 컬럼명 = 값, ... -- 바꿀 내용
	where 조건;
---------------------------------------------------------------------------------------------
select * from sep05_market;
select * from sep05_product;
	
	
-- 무를 공짜로
update sep05_product
	set p_price = 0
	where p_name = '무';
	
-- 배추를 김장용특대배추로 이름 수정
update sep05_product
	set p_name = '김장용특대배추'
	where p_name = '배추';
	
-- 모든 마트의 주차장 30% 줄이기
update sep05_market
	set m_parking = m_parking * 0.7;
	
-- 홈플러스 판교점의 상품 가격 10% 할인
-- update sep05_product
--	set p_price = p_price * 0.9
--	where p_m_no = 1;
-- // 이건 가짜고 아래 것 처럼 써야 함.
	
update sep05_product
	set p_price = p_price * 0.9
	where p_m_no = (
		select m_no
		from sep05_market
		where m_name = '홈플러스' and m_location = '판교'
	);
	
-- 제일 비싼 상품 10% 할인
update sep05_product
	set p_price = p_price * 0.9
	where p_price = (
		select max(p_price) from sep05_product
		);
----------------------------------------------------------------------------------------
-- D - delete
delete from 테이블명
	where 조건식;
	
-- 무 삭제
delete from sep05_product
	where p_name = '무';
	
-- 가장 좁은 매장 상품 다 삭제
delete from sep05_product
	where p_m_no in (
	select m_no 
		from sep05_market
		where m_land in (
			select min(m_land) 
				from sep05_market
	)
);
----------------------------------------------------------------------------------------
-- 홈플러스 강남점이 폐점
delete from sep05_market
	where m_name = '홈플러스' and m_location = '강남';
-- 홈플러스 강남점이 없어지는데, 그 안에 있던 상품들은 어떻게 할지...?
-- 그냥 두거나 / 같이 삭제 / 비워두거나
-- 정답이 없어서... 나중에 프로젝트시 팀원들끼리 잘 상의해야...!
----------------------------------------------------------------------------------------
-- 웹사이트 > 가입 > 로그인 > 게시글(욕) > 탈퇴
delete from 계정
	where id = 'xxx';
-- xxx의 글은 남기기 - 나중에 다른 사람이 xxx로 가입하게 되면...?
----------------------------------------------------------------------------------------



