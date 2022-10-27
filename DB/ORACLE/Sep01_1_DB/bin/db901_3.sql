-- select [distinct] [컬럼명], [컬럼명 as 별칭 혹은 컬럼명 별칭], [연산자], [통계함수], ...
-- from [테이블명]
-- where [조건식]
-- group by [그룹 대상 컬럼명]
-- having [함수 포함 조건식]
-- order by [정렬 대상 컬럼명 asc / desc ]
--------------------------------------------------------------------------------------------------
-- 요식업 프랜차이즈

-- 홍콩반점 판교점은 홍길동이 운영하고 100석
-- 홍콩반점 종로점은 김길동이 운영하고 80석
-- 한신포차 강남점은 홍길동이 운영하고 150석
-- 부천포차 부천점은 최길동이 운영하고 130석

create table sep01_franchise(
	f_no number(3) primary key,
	f_name varchar2(10 char) not null,
	f_location varchar2(10 char) not null,
	f_ceo number(3) not null,					-- 사장님 번호
	f_seat number(3) not null
);
create sequence sep01_franchise_seq;

insert into sep01_franchise values(sep01_franchise_seq.nextval, '홍콩반점', '판교', 1, 100);
insert into sep01_franchise values(sep01_franchise_seq.nextval, '홍콩반점', '종로', 2, 80);
insert into sep01_franchise values(sep01_franchise_seq.nextval, '한신포차', '강남', 3, 150);
insert into sep01_franchise values(sep01_franchise_seq.nextval, '부천포차', '부천', 4, 130);
insert into sep01_franchise values(sep01_franchise_seq.nextval, '북경반점', '이천', 4, 110);

select * from sep01_franchise;
--------------------------------------------------------------------------------------------
-- 홍길동, 1990-03-01일생, 남자
-- 김길동, 1992-02-01일생, 여자
-- 홍길동, 1991-12-12일생, 여자
-- 최길동, 1989-09-01일생, 남자

create table sep01_ceo(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_birthday date not null,
	c_gender char(2 char) not null
);

create sequence sep01_ceo_seq;

insert into sep01_ceo values(sep01_ceo_seq.nextval, '홍길동', to_date('1990-03-01', 'YYYY-MM-DD'), '남자');
insert into sep01_ceo values(sep01_ceo_seq.nextval, '김길동', to_date('1992-02-01', 'YYYY-MM-DD'), '여자');
insert into sep01_ceo values(sep01_ceo_seq.nextval, '홍길동', to_date('1991-12-12', 'YYYY-MM-DD'), '여자');
insert into sep01_ceo values(sep01_ceo_seq.nextval, '최길동', to_date('1989-09-01', 'YYYY-MM-DD'), '남자');

select * from sep01_ceo;

--------------------------------------------------------------------------------------------
-- 짜장면, 5000원, 홍콩반점 판교점(100명)에서 파는
-- 불닭발, 12000원, 한신포차 강남점(150명)에서 파는
--	... 매장당 메뉴 5개정도!

create table sep01_menu(
	m_no number(2) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null,
	m_f_no number(3) not null,
	constraint FK_menu foreign key(m_f_no) 
	references sep01_franchise(f_no) on delete cascade
);
--drop table sep01_menu cascade constraint purge;
create sequence sep01_menu_seq;

insert into sep01_menu values(sep01_menu_seq.nextval, '짜장면', 6000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '탕수육', 15000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '우육면', 7000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '짬뽕', 7000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '유산슬', 30000, 1);

insert into sep01_menu values(sep01_menu_seq.nextval, '난자완스', 30000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '양꼬치', 15000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '마라탕', 10000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '마라상궈', 35000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '양 갈비', 28000, 2);

insert into sep01_menu values(sep01_menu_seq.nextval, '오코노미야끼', 10000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, '타코야끼', 5000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, '어묵탕', 9000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, '스끼다시', 50000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, '가라아게', 15000, 3);

insert into sep01_menu values(sep01_menu_seq.nextval, '불닭발', 8000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '국물 떡볶이', 8000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '닭똥집', 12000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '꼼장어구이', 18000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '족발', 40000, 4);


insert into sep01_menu values(sep01_menu_seq.nextval, '스페셜 회 세트', 50000, 3);

select * from sep01_menu;



