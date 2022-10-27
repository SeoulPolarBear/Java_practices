-- ���̺��� �����͸� �˻�, ����, ����, �����ϴµ� ����ϴ� ������
-- ������ ���۾� (DML) �߿��� �����͸� �ִ� ��ɾ��� INSERT��
-- �����͸� �˻� or ��ȸ�� �� �ִ� ��ɾ��� SELECT�� ������ ������.

-- insert into [���̺��] values(��, ��, ... (������ ���缭)) �� ����!
-- insert�� �ϸ鼭 primary key�� �� �� ���� ��Ȳ��
-- ���������� ���� ��ȣ���� ����� ������� primary key�� �����
-- �� ������ ��ȣ������ ����µ� �־ �Ź� �ϳ��ϳ� ������ �� ���� ������
-- ��ȣ������ ���� ����!!! SEQUENCE ��� ����� Ȱ������ !
-- ���̺��̶� �����ϰ�, �������� INSERT�� �����ϴ���, SEQUENCE�� ���� ������ �ö󰣴ٴ� �� !!

-- �� ������ �����͸� �˻��� �� �ִ� SELECT (���� ��)
-- *************ȸ�� ���� ���� ���� ����ϰ� ��, ���� �߿��� �κ��̶�� ��.******************
-- select [distinct] [�÷���], [�÷��� as ��Ī] Ȥ�� �׳� [�÷��� ��Ī], [������ ���], [����Լ�], ...
-- from [���̺��]
-- where [���ǽ�]
-- group by [�׷���]
-- having [�Լ� ���� ����]
-- order by [���Ĵ�� ASC/DESC]

-- distinct�� �ߺ��� �������ִ� ���� !
-- �÷��� ��Ī�ο��ϴ� ��� : AS�� ���̰ų� �ƴϸ� ���⸸ �ϰų�
-- ������ �ø��� ù��° ��������� (+, -, *, /), �ٷ� �̾ ���ڸ� �̾�ٿ��ִ� ������ '||'
-- DUAL �������̺��� �̿��ؼ� ������ �����Լ�(�����Լ�, �����Լ�, ��¥�Լ�, ����Լ�, NULL�����Լ�)
-- ��ü ������ �� ���ǿ� �´� �����͸� ã���ִ� WHERE��(���ǽ�) �� �ٷ�鼭
-- ������ �ø��� �ι�° �񱳿�����(=, !=, >, <, >=, <=)
-- ������ �ø��� ����° ���迬���� AND�� BETWEEN�� ���� !
--					���ӵ��� ���� ������ �޾ƿ� �� ����ϴ� IN, OR
--					�� �ݴ�Ǵ� ���� �޾ƿ� �� ����ϴ� NOT
--					�̶� NOT�� ��ġ�� IN �� !!!
-- ������ �ø��� �׹�° ���Ͽ����� : ���ڿ��� �����ϴ� �˻�
--		LIKE '%����%' �� ���� / LIKE ��� = (��ȣ)�� ����ϸ� �ȵǴ� ���� !
--			=> ��ȣ�� ����ϸ� ������ ���� �״�� �ν��ع����� ������ !
-- ������ �ø��� ������ ���տ�����
-- 		UNION / UNION ALL (������)
--			: �ߺ��Ǵ� ���� �����ϰ� ��� / �ߺ��Ǵ��� ��� ���
--		INTERSECT (������)
--			: ���� �� ����Ǵ� �� ���
--		MINUS (������)
--			: �տ� �ִ� SELECT�� �߿��� �ڿ� �ִ� SELECT������ ���� �� ���
-- ������ �����鼭 �������� �켱���� (������ �ֿ켱 ����)
--		��ȣ > �񱳿����� > NOT > AND > OR

-- WHERE ���ǽ� ���°�
-- �������δ� GROUP BY : �׷����� ��� �����Ͽ� �ϳ��� ����� ��Ÿ���� �� !
--		ROLLUP ������ : �÷��� ���� �Ұ�(Subtotal)�� �������
-- �� ������ HAVING���� WHERE��
--		: HAVING���� �׷��� ����� ���� / WHERE���� ������ ����ؼ� ����� ����
-- ���������� ������ ���ִ� ORDER BY 
--		: �������� ASC(�⺻���̶� ��� ���ص� ��) / �������� DESC
------------------------------------------------------------------------
-- *** �������� (SubQuery)
-- SELECT�� �ȿ� �ٽ� SELECT���� ����ϴ� ��� !
-- �ϳ��� SQL�� �ȿ� �ٸ� SQL���� ��ø�� ���ǹ��� ����.
-- �ٸ� ���̺��� ������ �����ͷ� ���� ���̺� �ִ� ������ ã�ų� ������ �� �����
-- ���� �����Ͱ� �뷮�� �� �����͸� ��� ���ļ� �����ϴ� JOIN���� 
-- �ʿ��� �����͸� ã�Ƽ� �������ִ� SUBQUERY�� ������ �� ����

-- �� ���� (main query, �ܺ� ����)�� �μ� ���� (subquery, ���� ����)�� ������.

--	 <main query>						 <sub query>
select s_name, s_price
	from SNACK
									where s_price < (
										select avg(s_price)
										from SNACK
);
-- ��հ����� ������ ���� ������ �̸��� ���� ������ ��ȸ�� ��
-- �� ���� ���̶��... �κ����� ������ �����غ��� ���ݴ� �������� ��������,
-- ���ǿ� �°� �� ã�� �� ���� !

-- ���������� where������ ���������� ����� ���� ���� �ݵ�� �񱳿����ڸ� ����ؾ� �� !
-- ��ȣ ���� !
-- where�� ���� select���� �� �Ұ�ȣ�� ������� �� ! �ȳ����� ���� ����

-- ���ڵ� �� �ְ�
-- ���� ��� ���� �̸�, ������, ����
-- ���� �� ���ڴ� ��𿡼� ���峪��?
-- ��հ����� ��� ���ڴ� �� ����?
-- ��������� ���� ���� ���� ������ ��ü ����

-- �ְ�
select max(s_price) from SNACK;

-- �ְ� ������ ����
select s_name, s_company, s_price 
	from snack
	where s_price = (
		select max(s_price) 
		from SNACK
);
			
-- ���� �� ���ڴ� ��𿡼�?
select distinct s_company
	from snack
	where s_price =(
		select min(s_price)
		from snack
);
		
-- ��հ����� ��� ���ڴ� �� ����?
select count(*) || '����' "��պ��� ��� ����"
	from snack
	where s_price > (
		select avg(s_price)
		from snack
);

-- ��������� ���� ���� ���� ������ ��ü ����
-- date���� max �Լ� �̿� ����.
select *
	from snack
	where s_exp = (
		select max(s_exp)
		from snack
);
-----------------------------------------------------------------------------------
-- ���� ȸ�� ���̺��� ����ǵ�, ȸ���̸�, �ּ�, ���� �� ���� ������ ������ּ���
-- ���� ���̺� ���缭 ������ �ֱ�!
select * from SNACK;

create table aug30_maker (
	m_name varchar2(10 char) primary key,
	m_address varchar2(30 char) not null,
	m_employ_number number(5)
);

insert into aug30_maker values ('�Ե�', '�λ�', 4573);
insert into aug30_maker values ('����', '����', 1557);
insert into aug30_maker values ('ũ���', '��õ', 1307);
insert into aug30_maker values ('������', '����', 1373);
insert into aug30_maker values ('������ǰ', '��õ', 1126);

drop table aug30_maker cascade constraint purge;

select * from aug30_maker;
----------------------------------------------------------------------------------------
-- ���� �� ���� ���� ȸ�翡�� ����� �����̸�, ����
-- ���� ��� ���ڸ� ����� ȸ��� ��� �ִ���
-- ��õ�� �ִ� ȸ�翡�� ����� ������ ��հ�
-- ��հ� �̻��� ���ڸ� ����� ȸ���� �̸�, ��ġ

-- ���� ���� ȸ�簡 ����� ����, ���� (���� �ٸ� �� ���̺��� �����Ϸ��� ������� �ʿ�! -> ȸ���� �̸�)
select s_name, s_price from SNACK where s_company = (
	select m_name from aug30_maker where m_employ_number = (
		select min(m_employ_number) from AUG30_MAKER
	)
);

-- ���� ��� ���ڸ� ����� ȸ���� ��ġ?
select m_address from aug30_maker where m_name in (
	select s_company from snack where s_price = (
		select max(s_price) from snack
	)
);

-- ��õ�� �ִ� ȸ�翡�� ����� ������ ��հ�
select avg(s_price) from snack where s_company = (
	select m_name from aug30_maker where m_address = '��õ'
);		

-- ��� �̻��� ����� ȸ���� �̸�, ��ġ
--select m_name, m_address from aug30_maker where m_name = (
--	select distinct s_maker from aug30_snack where s_price >= (
--		select avg(s_price) from aug30_snack
--	)
--);  
-- single-row subquery returns more than one row ���� �߻�.
-- ���� �ϳ��� �־�� �ϴµ�, �������� ���Դ�.
-- ȸ����� ���°ų�, �Ե��ų�, ...
-- ������ ���� " = " 
-- = ���� ���ϰ� �̻��� ����� ������ ���� ��� !
--		=> ���迬���� < in > ���.
select m_name, m_address from aug30_maker where m_name in (
	select distinct s_maker from aug30_snack where s_price >= (
		select avg(s_price) from aug30_snack
	)
);  