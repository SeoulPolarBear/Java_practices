-- � Ư���� �Ĵ翡 ���� ���̺�
-- �Ĵ� ����(ü���� ����), ���� ����, �¼� ��
create table sep06_restaurant(
	r_location varchar2(20 char) primary key,
	r_owner varchar2(20 char) not null,
	r_seat number(4) not null
);

insert into sep06_restaurant values('�Ǳ�', 'Lim', 1000);
insert into sep06_restaurant values('����', 'Kim', 2000);
insert into sep06_restaurant values('������', 'Han', 500);
insert into sep06_restaurant values('����', 'Ahn', 800);


drop table sep06_restaurant;
drop table sep06_book;

-- ���� ���̺�
-- ������ �̸�, ���� �ð�, ������ ��ȭ��ȣ, ���� ����
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

insert into sep06_book values(sep06_book_seq.nextval,'��浿',to_date('2022-09-07 18:00','YYYY-MM-DD HH24:MI'),'010-1111-2222','�Ǳ�');
insert into sep06_book values(sep06_book_seq.nextval,'ȫ�浿',to_date('2022-09-08 18:00','YYYY-MM-DD HH24:MI'),'010-1234-2234','����');
insert into sep06_book values(sep06_book_seq.nextval,'���浿',to_date('2022-09-09 18:00','YYYY-MM-DD HH24:MI'),'010-1333-2211','����');
insert into sep06_book values(sep06_book_seq.nextval,'���浿',to_date('2022-09-10 18:00','YYYY-MM-DD HH24:MI'),'010-5555-2233','������');
insert into sep06_book values(sep06_book_seq.nextval,'�ڱ浿',to_date('2022-09-10 19:00','YYYY-MM-DD HH24:MI'),'010-1547-2123','������');
insert into sep06_book values(sep06_book_seq.nextval,'�ѱ浿',to_date('2022-09-9 20:00','YYYY-MM-DD HH24:MI'),'010-9503-3593','����');


insert into sep06_book values(sep06_book_seq.nextval,'��浿',to_date('2022-10-07 18:00','YYYY-MM-DD HH24:MI'),'010-1111-2222','�Ǳ�');
insert into sep06_book values(sep06_book_seq.nextval,'ȫ�浿',to_date('2022-10-08 18:00','YYYY-MM-DD HH24:MI'),'010-1234-2234','����');
insert into sep06_book values(sep06_book_seq.nextval,'���浿',to_date('2022-10-09 18:00','YYYY-MM-DD HH24:MI'),'010-1333-2211','����');
insert into sep06_book values(sep06_book_seq.nextval,'���浿',to_date('2022-10-10 18:00','YYYY-MM-DD HH24:MI'),'010-5555-2233','������');
insert into sep06_book values(sep06_book_seq.nextval,'�ڱ浿',to_date('2022-10-10 19:00','YYYY-MM-DD HH24:MI'),'010-1547-2123','������');
insert into sep06_book values(sep06_book_seq.nextval,'�ѱ浿',to_date('2022-10-9 20:00','YYYY-MM-DD HH24:MI'),'010-9503-3593','����');

select * from Sep06_book;
select * from Sep06_restaurant;


