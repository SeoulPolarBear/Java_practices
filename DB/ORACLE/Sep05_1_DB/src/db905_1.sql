-- ����, 3000g, 10000��, Ȩ�÷���, �Ǳ���, 1000��, ������ 500��
-- ��, 500g, 5000��, Ȩ�÷���, ������, 500��, ������ 300��
-- ����, 2000g, 5000��, �̸�Ʈ, ������, 800��, ������ 800��
-- ��Ʈ �����Ͱ� �������� �ű⼭ �Ĵ� ���ǵ� �������Բ�.
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

insert into sep05_market values (sep05_market_seq.nextval, 'Ȩ�÷���', '�Ǳ�', 1000, 500);
insert into sep05_market values (sep05_market_seq.nextval, 'Ȩ�÷���', '����', 500, 300);
insert into sep05_market values (sep05_market_seq.nextval, '�̸�Ʈ', '����', 800, 800);

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

insert into sep05_product values (sep05_product_seq.nextval, '����', 3000, 10000, 1);
insert into sep05_product values (sep05_product_seq.nextval, '��', 500, 5000, 2);
insert into sep05_product values (sep05_product_seq.nextval, '����', 2000, 5000, 3);

select * from sep05_product;

---------------------------------------------------------------------------------------------
-- create table - DBA �� ����
-- drop table	- DBA �� ����
-- create sequence	-DBA�� ����
-- ���� �ϳ��� ������ ��� ����
-- ȸ�簡�� �����ڿ� ������ �˷��� -> ���� �۾��� ������ ���� ��
---------------------------------------------------------------------------------------------
-- C - insert
--			sequence���, ��¥ ����ְ�, ...
-- R - select
--			���� ��κ��� �ð��� �Ҿ���
-- U - update
update ���̺��
	set �÷��� = ��, �÷��� = ��, ... -- �ٲ� ����
	where ����;
---------------------------------------------------------------------------------------------
select * from sep05_market;
select * from sep05_product;
	
	
-- ���� ��¥��
update sep05_product
	set p_price = 0
	where p_name = '��';
	
-- ���߸� �����Ư����߷� �̸� ����
update sep05_product
	set p_name = '�����Ư�����'
	where p_name = '����';
	
-- ��� ��Ʈ�� ������ 30% ���̱�
update sep05_market
	set m_parking = m_parking * 0.7;
	
-- Ȩ�÷��� �Ǳ����� ��ǰ ���� 10% ����
-- update sep05_product
--	set p_price = p_price * 0.9
--	where p_m_no = 1;
-- // �̰� ��¥�� �Ʒ� �� ó�� ��� ��.
	
update sep05_product
	set p_price = p_price * 0.9
	where p_m_no = (
		select m_no
		from sep05_market
		where m_name = 'Ȩ�÷���' and m_location = '�Ǳ�'
	);
	
-- ���� ��� ��ǰ 10% ����
update sep05_product
	set p_price = p_price * 0.9
	where p_price = (
		select max(p_price) from sep05_product
		);
----------------------------------------------------------------------------------------
-- D - delete
delete from ���̺��
	where ���ǽ�;
	
-- �� ����
delete from sep05_product
	where p_name = '��';
	
-- ���� ���� ���� ��ǰ �� ����
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
-- Ȩ�÷��� �������� ����
delete from sep05_market
	where m_name = 'Ȩ�÷���' and m_location = '����';
-- Ȩ�÷��� �������� �������µ�, �� �ȿ� �ִ� ��ǰ���� ��� ����...?
-- �׳� �ΰų� / ���� ���� / ����ΰų�
-- ������ ���... ���߿� ������Ʈ�� �����鳢�� �� �����ؾ�...!
----------------------------------------------------------------------------------------
-- ������Ʈ > ���� > �α��� > �Խñ�(��) > Ż��
delete from ����
	where id = 'xxx';
-- xxx�� ���� ����� - ���߿� �ٸ� ����� xxx�� �����ϰ� �Ǹ�...?
----------------------------------------------------------------------------------------



