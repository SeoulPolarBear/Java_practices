-- 어떤 특정한 식당에 대한 테이블
-- 식당 지점(체인점 지역), 식장 주인, 좌석 수
create table sep06_restaurant(
	r_location varchar2(20 char) primary key,
	r_owner varchar2(20 char) not null,
	r_seat number(4) not null
);

insert into sep06_restaurant values('판교', 'Lim', 1000);
insert into sep06_restaurant values('강남', 'Kim', 2000);
insert into sep06_restaurant values('광나루', 'Han', 500);
insert into sep06_restaurant values('수서', 'Ahn', 800);


drop table sep06_restaurant;
drop table sep06_book;

-- 예약 테이블
-- 예약자 이름, 예약 시간, 예약자 전화번호, 예약 지점
create table sep06_book(
	b_no number(4) primary key,
	b_name varchar2(20 char) not null,
	b_time date not null,
	b_phone_number varchar2(20 char) not null,
	b_r_location varchar2(20 char) not null,
	constraint FK_key foreign key(b_r_location)
	references sep06_restaurant(r_location) 
	on delete cascade
);

create sequence sep06_book_seq;

insert into sep06_book values(sep06_book_seq.nextval,'김길동',to_date('2022-09-07 18:00','YYYY-MM-DD HH24:MI'),'010-1111-2222','판교');
insert into sep06_book values(sep06_book_seq.nextval,'홍길동',to_date('2022-09-08 18:00','YYYY-MM-DD HH24:MI'),'010-1234-2234','강남');
insert into sep06_book values(sep06_book_seq.nextval,'지길동',to_date('2022-09-09 18:00','YYYY-MM-DD HH24:MI'),'010-1333-2211','수서');
insert into sep06_book values(sep06_book_seq.nextval,'강길동',to_date('2022-09-10 18:00','YYYY-MM-DD HH24:MI'),'010-5555-2233','광나루');
insert into sep06_book values(sep06_book_seq.nextval,'박길동',to_date('2022-09-10 19:00','YYYY-MM-DD HH24:MI'),'010-1547-2123','광나루');
insert into sep06_book values(sep06_book_seq.nextval,'한길동',to_date('2022-09-9 20:00','YYYY-MM-DD HH24:MI'),'010-9503-3593','수서');


insert into sep06_book values(sep06_book_seq.nextval,'김길동',to_date('2022-10-07 18:00','YYYY-MM-DD HH24:MI'),'010-1111-2222','판교');
insert into sep06_book values(sep06_book_seq.nextval,'홍길동',to_date('2022-10-08 18:00','YYYY-MM-DD HH24:MI'),'010-1234-2234','강남');
insert into sep06_book values(sep06_book_seq.nextval,'지길동',to_date('2022-10-09 18:00','YYYY-MM-DD HH24:MI'),'010-1333-2211','수서');
insert into sep06_book values(sep06_book_seq.nextval,'강길동',to_date('2022-10-10 18:00','YYYY-MM-DD HH24:MI'),'010-5555-2233','광나루');
insert into sep06_book values(sep06_book_seq.nextval,'박길동',to_date('2022-10-10 19:00','YYYY-MM-DD HH24:MI'),'010-1547-2123','광나루');
insert into sep06_book values(sep06_book_seq.nextval,'한길동',to_date('2022-10-9 20:00','YYYY-MM-DD HH24:MI'),'010-9503-3593','수서');

select * from Sep06_book;
select * from Sep06_restaurant;


