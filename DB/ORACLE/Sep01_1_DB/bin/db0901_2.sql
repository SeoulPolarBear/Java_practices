-- 1. �������̺�� ī�����̺��� �����
-- �������̺� : �����̸� / ���� / �Ǹ��ϴ� ī���� �̸�
-- ī�����̺� : ī���̸� / ���� / �¼��� 
-- [����] �� ���̺��� Ŀ�� �̸�, ī�� �̸��� ������ ���� ���´�.

-- 2. ���ǿ� �´� ���̺��� ����
-- Aī��� ���￡ ��ġ�ϰ�, �¼� 100��,
-- 	(�Ƹ޸�ī��, 2000��), (��, 3000��), (����, 2500��) �� �Ǹ�
-- Bī��� �Ǳ��� ��ġ�ϰ�, �¼� 80��,
--	(ȫ��, 2500��), (������, 3000��), (����������, 4000��) �� �Ǹ�

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
	

insert into sep01_cafe values ('A', '����', 100);
insert into sep01_cafe values ('B', '�Ǳ�', 80);

insert into sep01_beverage values('�Ƹ޸�ī��', 2000, 'A'); 
insert into sep01_beverage values('��', 3000, 'A'); 
insert into sep01_beverage values('����', 2500, 'A');

insert into sep01_beverage values('ȫ��', 2500, 'B'); 
insert into sep01_beverage values('������', 3000, 'B'); 
insert into sep01_beverage values('����������', 4000, 'B'); 

select * from sep01_beverage;
select * from sep01_cafe;
drop table sep01_beverage cascade constraint purge; 
drop table sep01_cafe cascade constraint purge; 

-- 3. ������ �ۼ�
--	��հ��ݺ��� ��� ����� �� ����?
--	���� �� ���Ḧ �Ĵ� ī���� �̸�?
--	���￡ �ִ� ī�信�� ����� ������ ��հ�?
--	�¼��� 90�� �̻��� ī�信�� �Ĵ� ������ �̸�?
--	��հ� ������ ������ �̸�? 
--	���� ��� ���Ḧ �Ĵ� ī��� ��� �ִ���?

-- ��պ��� ��� �� ����
select count(*) from sep01_beverage where b_price > (
	select avg(b_price) from sep01_beverage	
);

-- ���� �Ѱ� �Ĵ� ī��
select c_name from sep01_cafe where c_name = (
	select b_seller from sep01_beverage where b_price = (
		select min(b_price) from sep01_beverage
	)
); 

-- ���� ī�� ���� ���� ���
select avg(b_price) from sep01_beverage where b_seller in (
	select c_name from sep01_cafe where c_location = '����'	
);

-- 90�� �̻� ī�� ���� �̸�
select b_name from sep01_beverage where b_seller in (
	select c_name from sep01_cafe where c_seat_number >= 90	
);

-- ��հ� ���� ���� �̸�
select b_name from sep01_beverage where b_price <= (
	select avg(b_price) from sep01_beverage	
);

-- ���� ��� ���Ḧ �Ĵ� ī�� ��ġ
select c_location from sep01_cafe where c_name = (
	select b_seller from sep01_beverage	where b_price = (
		select max(b_price) from sep01_beverage
	)
);
