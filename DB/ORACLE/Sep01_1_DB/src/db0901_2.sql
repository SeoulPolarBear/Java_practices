-- 1. 음료테이블과 카페테이블을 만들기
-- 음료테이블 : 음료이름 / 가격 / 판매하는 카페의 이름
-- 카페테이블 : 카페이름 / 지역 / 좌석수 
-- [조건] 각 테이블에서 커피 이름, 카페 이름은 고유한 값을 갖는다.

-- 2. 조건에 맞는 테이블을 생성
-- A카페는 서울에 위치하고, 좌석 100석,
-- 	(아메리카노, 2000원), (라떼, 3000원), (녹차, 2500원) 를 판매
-- B카페는 판교에 위치하고, 좌석 80석,
--	(홍차, 2500원), (스무디, 3000원), (에스프레소, 4000원) 을 판매

create table sep01_cafe (
	c_name varchar2(15) primary key,
	c_location varchar2(15) not null,
	c_seat_number number(3) not null
);

create table sep01_beverage (
	b_name varchar2(15) primary key,
	b_price number(5) not null,
	b_seller varchar2(15) not null
	);
	

insert into sep01_cafe values ('A', '서울', 100);
insert into sep01_cafe values ('B', '판교', 80);

insert into sep01_beverage values('아메리카노', 2000, 'A'); 
insert into sep01_beverage values('라떼', 3000, 'A'); 
insert into sep01_beverage values('녹차', 2500, 'A');

insert into sep01_beverage values('홍차', 2500, 'B'); 
insert into sep01_beverage values('스무디', 3000, 'B'); 
insert into sep01_beverage values('에스프레소', 4000, 'B'); 

select * from sep01_beverage;
select * from sep01_cafe;
drop table sep01_beverage cascade constraint purge; 
drop table sep01_cafe cascade constraint purge; 

-- 3. 쿼리문 작성
--	평균가격보다 비싼 음료는 몇 종류?
--	제일 싼 음료를 파는 카페의 이름?
--	서울에 있는 카페에서 만드는 음료의 평균가?
--	좌석이 90석 이상인 카페에서 파는 음료의 이름?
--	평균가 이하인 음료의 이름? 
--	가장 비싼 음료를 파는 카페는 어디에 있는지?

-- 평균보다 비싼 것 종류
select count(*) from sep01_beverage where b_price > (
	select avg(b_price) from sep01_beverage	
);

-- 제일 싼거 파는 카페
select c_name from sep01_cafe where c_name = (
	select b_seller from sep01_beverage where b_price = (
		select min(b_price) from sep01_beverage
	)
); 

-- 서울 카페 음료 가격 평균
select avg(b_price) from sep01_beverage where b_seller in (
	select c_name from sep01_cafe where c_location = '서울'	
);

-- 90석 이상 카페 음료 이름
select b_name from sep01_beverage where b_seller in (
	select c_name from sep01_cafe where c_seat_number >= 90	
);

-- 평균가 이하 음료 이름
select b_name from sep01_beverage where b_price <= (
	select avg(b_price) from sep01_beverage	
);

-- 가장 비싼 음료를 파는 카페 위치
select c_location from sep01_cafe where c_name = (
	select b_seller from sep01_beverage	where b_price = (
		select max(b_price) from sep01_beverage
	)
);
