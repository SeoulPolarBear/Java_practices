select * from SEP01_FRANCHISE;
select * from SEP01_CEO;
select * from SEP01_MENU;
----------------------------------------------------------------------------------------------------
--�¼� �� ���� ���� �Ĵ� ��ϴ� ����� ��ü ���� ��ȸ
select * from SEP01_CEO
where c_no = (
	select f_ceo 
	from SEP01_FRANCHISE
	where f_seat = (
		select max(f_seat) 
		from sep01_franchise
		)
	);

--���������� �޴� ��ü�� �̸�, ����
--�� ���� �������� -> ������ ���ٸ� �޴����� ������ ���� ����
--������ ���� �ϰ� ���� ��... => order by �÷���, �÷���,...
select m_name, m_price 
from SEP01_MENU
where m_f_no in (
	select f_no 
	from SEP01_FRANCHISE
	)
	order by m_price , m_name desc;


--��ü ����Ե� �̸�, ���� ��ȸ
select c_name, to_char(c_birthday, 'YYYY.MM.DD') as ������� from SEP01_CEO; 
 
--���������� �Ĵ� �� ��?
select count(*) from SEP01_FRANCHISE;

--���������� �޴� ��ü�� ��հ�
select avg(m_price) 
from sep01_menu
where m_f_no in
	(select f_no 
	from sep01_franchise
	);
	
--���� ��� �޴� �̸�, ����
select m_name, m_price from SEP01_MENU
where m_price =(
	select max(m_price) 
	from SEP01_MENU
	);
	
-- �ֿ����� ������� �̸�, ����
--subquery�� ��¥���� ����ȴ�!! (�ֿ����� = �ּ� ���� ��)
select c_name, to_char(c_birthday, 'YYYY.MM.DD') as ������� 
from SEP01_CEO
where c_birthday =(
		select min(c_birthday) 
		from SEP01_CEO
		);
	
-- �¼� �� ���� ���� �Ĵ��� �̸�, ������, �¼���
select f_name, f_location, f_seat
from SEP01_FRANCHISE
where f_seat =(	
	select min(f_seat) 
	from sep01_franchise
	);
	
--������������ join�� ����
-- ���� table���� �÷� ���� ������ ���� ��������
-- �ٸ� table�� Ŀ�� ���� ������ ���� join�� ���� ���� ����.
--���� join�� �������� ���� ������ ����(��ġ�� ����)

--���������� ����� �� domain�� ������ �ȴ�.

--ȫ�� ���� �Ǳ��� ��ϴ� ����� �̸�, ����
select c_name, to_char(c_birthday, 'MM')||'��'
			|| to_char(c_birthday, 'DD')||'��' as ���� 
from SEP01_CEO
where c_no =(
	select f_ceo 
	from sep01_franchise
	where f_name = 'ȫ�����' and f_location = '�Ǳ�'
	);
	
--'¥��'�� �� ������ ��𰡸� ���� �� �ֳ���? (¥��� �Ĵ� �Ĵ� �̸�, ������)
select f_name, f_location from sep01_franchise
where f_no in (
	select m_f_no from SEP01_MENU
	where m_name like '%¥��%'
	);
	
--�¼� �� ���� ���� �Ĵ��� ��ϴ� ����� ��� ����
select * from sep01_ceo
where c_no in (
	select f_ceo 
	from SEP01_FRANCHISE
	where f_seat =(
		select max(f_seat) 
		from SEP01_FRANCHISE
		)
	);
-------------------------------------------------------------------------------
--�ֿ��� ����Գ� ���� �޴� �̸�, ����
select m_name, m_price from SEP01_MENU
where m_f_no in(
select f_no from sep01_franchise
where f_ceo in (
	select c_no from sep01_ceo
	where c_birthday =(
		select max(c_birthday)
		from SEP01_CEO
		)
	)
);
----------------------------------------------------------------------------------------------------
--���̺� �������� 'JOIN' ��Ų��.
--					:���̺� �������� �ٿ��� RAM�� ��� �־����...!
----------------------------------------------------------------------------------------------------
--�̷��� ���̺��� �ٿ��� ����� ����������,
--���̺���� �������鼭 ��Ÿ�� �� �ִ� ��� ������ ��Ÿ���� ������
-- ���ǽ��� ����ؾ� �Ѵ�.
select * from SEP01_FRANCHISE, sep01_ceo;
--���ǽ��� ����ؾ� ��!
select * from SEP01_FRANCHISE, sep01_ceo where f_ceo = c_no;

--��ü �Ĵ� �̸�, ������, ����� �̸�, ����� ����
select f_name, f_location, c_name, to_char(c_birthday, 'MM')||'��'
			|| to_char(c_birthday, 'DD')||'��' as ���� from sep01_franchise,sep01_ceo where f_ceo = c_no;
			
--��ü �޴���, ����, �Ĵ� �̸�, ������
select m_name, m_price, f_name, f_location 
from SEP01_FRANCHISE, sep01_menu 
where f_no = m_f_no;

--�¼����� 50�� �̻��� �Ĵ��� �޴���, ����, �Ĵ� �̸�, ������, �¼���
select m_name, m_price, f_name, f_location, f_seat 
from sep01_menu, sep01_franchise where f_no = m_f_no
and f_seat >= 50;

--�Ը� ���� ū �Ĵ��� �޴���, ����, �Ĵ��̸�, ������, �¼� �� 
select m_name, m_price, f_name, f_location, f_seat 
from sep01_menu, SEP01_FRANCHISE
where m_f_no = f_no 
	and f_seat in (
	select max(f_seat) 
	from SEP01_FRANCHISE
	);

--�ֿ����� ����Գ� ��ü �޴���, ����, �Ĵ��̸�, ������, ������̸�, ����
--		�� �޴��� �����ټ� -> �Ĵ��̸� �����ټ�

select m_name, m_price, f_name, f_location, c_name, to_char(c_birthday, 'MM')||'��'
			|| to_char(c_birthday, 'DD')||'��' as ���� from SEP01_MENU,sep01_franchise,sep01_ceo
where m_f_no = f_no and f_ceo = c_no
and c_birthday =(
	select min(c_birthday) from SEP01_CEO)
order by m_name, f_name;
-----------------------------------------------------------------------------------------------------------
-- �޴� �����͸� ������ ������ �������� �����ְ� ����
-- ��� �ұ�...?
-- �޴����̺� m_no�� ����(Primary key)
--		Sequence�� ó������
--			�׷��� sequence�� insert�� �����ص� �˾Ƽ� �ö�
--		�޴� ������ ������ ����
--	=> m_no�� ��Ȯ�ϰ� 1,2,3,4,...�� �ƴ�! (�߰��� �� �������� ���� �߻��Ѵ�.)
-- �׷� � ����� ������?
-------------------------------------------------------------------------------------------------------------
--rownum(�����ʵ�)***************************************
--		select�� ������ �ڵ����� �ο���
--		* ���� ���� ����� �� ����
--		order by���� rownum�� ���� �ο��� �ȴ�.
--		������ 1������ ��ȸ�ؾ� ��!

--�޴� �̸��� ������ ������ �����ؼ� menu ��ü ���� ��ȸ
--select rownum, * from SEP01_MENU order by m_name;--��� *�� ����߱� �����̴�.
select rownum, m_no, m_name, m_price, m_f_no from SEP01_MENU order by m_name;

--�޴� �̸��� ������ ������ �����ؼ� menu ���̺� rownum 1~3���� ��ü ������ ��ȸ
--		order by���� rownum�� ���� �ο��� �ȴ�. �׷��� rownum�� m_no�� ������ �����Ŵ�.
--		���� 
select rownum, m_no, m_name, m_price, m_f_no 
from SEP01_MENU 
where rownum between 1 and 3  
order by m_name;
			   				  -- �̷��� �ϸ� order by���� rownum�� �����Ǿ
							  -- sequence�� ���� m_no�� ���� ���͹���
							  -- �츮�� �ǵ��� �ٴ� �̸������� ������ �ϰ�
							  -- �� ���� ��ȣ��(rownum)�� �ֱ⸦ ������



select rownum, m_no, m_name, m_price, m_f_no 
from SEP01_MENU 
order by m_name
where rownum between 1 and 3 ; -- �ڵ�� ��� ���� ������ �Ϸ��� �̷��� �ϰ� ������
								-- ��������!!!
	

select rownum, m_no, m_name, m_price --2. �� ������ rownum �ο�
from (
	select m_no, m_name, m_price  -- 1. �� �κ��� ���̺�ó�� �����
	from SEP01_MENU 			  -- (������ ���� �س���)
	order by m_name				  --Inline View��� ��(�ζ��� ��)
) where rownum between 1 and 3;


select rownum, m_no, m_name, m_price
from (
	select m_no, m_name, m_price
	from SEP01_MENU
	order by m_name
) where rownum between 2 and 3; -- ������ 1������ ��ȸ�ؾ� ��!

--rownum 2 ~ 4���� �޴����̺� ������ �޴��� ������ �� ����
-- select�� �翡 �ѹ� �� �����ָ� �ȿ� �ִ� rownum�� ���ڸ� �ο��س��� ȿ���� �Ҿ����
select *
 from (
 select rownum as rn, m_no, m_name, m_price
	from(
		select m_no, m_name, m_price
		from sep01_menu
		order by m_name
	)
 )
 where rn between 2 and 4;


--�浿 �̸��� ���� ����Գ�
--	�޴���, ����, �Ĵ��, ������, ������̸�
--	���� �������� -> �޴��� �����ټ�
--	3 ~ 8��°���� ��ȸ
select * -- *�� rownum as rn, m_name, m_price, f_name, f_location, c_name �� ����. (������ Ŀ���� �� table �����̹Ƿ�)
from(
	select rownum as rn, m_name, m_price, f_name, f_location, c_name 
	from (
		select m_name, m_price, f_name, f_location, c_name 
		from SEP01_MENU, SEP01_FRANCHISE, sep01_ceo
		where m_f_no = f_no and f_ceo = c_no
			and c_name like '%�浿'
		order by m_price desc, m_name
		)
	)
where rn between 3 and 8;

--�达 ���� ���� ����Գ� �޴���, ����, ����� �̸�, ����� ����
--���� �������� ���� => 2~3����
select * 
	from(
		select rownum as rn, m_name, m_price, c_name, c_gender 
		from(
			select m_name, m_price, c_name, c_gender
			from sep01_menu, sep01_ceo ,SEP01_FRANCHISE
				where m_f_no = f_no and f_ceo = c_no 
					and c_name like '��%'
				order by m_price asc
			)
		)
	where rn between 2 and 3;
	
	
	
	
	
	
	
	






