create table sep26_meat(
	m_id number(3) primary key,
	m_kind varchar2(10 char) not null,
	m_from varchar2(10 char) not null,
	m_price number(7) not null,
	m_introduce varchar2(100 char) not null
);
drop table sep26_meat;

create sequence sep26_meat_seq;

insert into sep26_meat values(sep26_meat_seq.nextval, 'loin','pig',100000,'this is the back of pig');
insert into sep26_meat values(sep26_meat_seq.nextval, 'RIB','Cow',200000,'this is the back of Cow');