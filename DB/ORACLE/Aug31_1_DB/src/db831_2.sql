--R(Read)
select [distinct] [�÷���], [�÷��� as ��Ī || �÷��� ��Ī], [������ ���], [����Լ�],...
from [���̺��]
where [���ǽ�]
group by [���ǽ�]
having [�Լ� ���� ����]
order by [���Ĵ�� ASC/DESC(�������� / ��������)] --�⺻���� ��������

-- where�� (���ǽ�)
-- ��ü ������ �� ������ ���ǿ� �´� �����͸� ã���ִ� ����
-- ���ǽĿ� ����� �����ڸ� �˾ƺ���(�� ������)
-- =, !=, ^=, <>, >, <, >=, <=,...
--�� �߿��� 2,3, 4��°�� '���� �ʴ�'�� ���̴� �������ε�... �� 3���� �ɱ�...?
--2���� 4���� ��쿡�� ���� ǥ��ȭ�� �Ϸ��� ���� ����ϰ� �Ǿ���, 
--3���� ��쿡�� ��� DBMS�� ����ȭ�� �α� ���ؼ� ����ϰ� �Ǿ���

--������ 3000���� ������ ��� ������ ��ȸ
select * from snack where s_price = 3000;

--���� ���� ���� table ���
select * from snack;

--��� ���� �̸�, ���� ��ȸ
select s_name, s_price from snack;

--��� ���� �̸�(����) ��ȸ (ex : ��Ĩ(2000��))
select s_name||'('||s_price||'��'||')' as "�̸�(����)" from snack;
select concat(s_name||'(',concat(s_price,'��')||')') as "�̸�(����)" from snack;
--���ڿ��� concat�� �˴ϴ�. 
--Ư�����ڰ� ���� �� ��� ""����ؾ� �Ѵ�.

--2000�� ������ ���� �� �ּ� ������ ������
select min(s_price) as �ּҰ��� from snack where s_price <= 2000;

--��� ������ ��հ�
select round(avg(s_price),-1) as ��հ� from snack;

--������ �̸��� ������ 30% ���ε� �ݾ�
select s_name, s_price*0.7 as "30%���ΰ���" from snack;

--3500���� ������ ������ �?
select count(s_code) "3500�� ����" from snack where s_price = 3500;

--3000�� ������ ������ �̸�, ȸ�� �̸�
select s_company, s_name from snack where s_price <= 3000 order by s_company asc;
-------------------------------------------------------------------------------------
--��� ���� �̸�, ����, ������� ��ȸ
select s_name,s_price, s_exp from snack;

--��� ���� �̸�, ����, �ΰ��� ��ȸ(������ 10%)
select s_name, s_price, s_price * 0.1 as VAT from snack;

--��� ���� �̸�, ����, �ǸŰ� ��ȸ (20%����)
select s_name, s_price, s_price * 0.8 as "�ǸŰ�(20%����)" from snack;

--3000������ ū �ݾ��� ���ڵ��� ��հ� ��ȸ
select avg(s_price) from snack where s_price >= 3000;

--�ְ�, ������, �� ���� ���� �� �������� ��ȸ
select max(s_price) �ְ�, min(s_price) ������, count(*) �Ѱ��� from snack;

--3000�� �̻��� ������ ��ü ���� ��ȸ
select * from snack where s_price >= 3000;

--3000�� �̸��� ������ �̸�, ����, �ǸŰ� ��ȸ(20% ����)
select s_name, s_price, s_price * 0.8 as "�ǸŰ�(20%����)" from snack where s_price < 3000;

--�����۽��� ���� ��ȸ
select s_price from snack where s_name = '�����۽�';

--ũ��� ȸ���� ���� ����
select sum(s_price) as ���� from snack where s_company = 'ũ���';

--2022�⵵ 12�� ������ �Ծ�� �ϴ� ���� �̸�, ����, ������� ��ȸ
select s_name, s_price, s_exp from snack 
where s_exp < to_date('2022-10-01 00:00:00', 'YYYY-MM-DD HH24:MI:ss');
where to_char(s_exp,'YYYY') = '2022' and to_char(s_exp,'MM') <= '12';
---------------------------------------------------------------------------------------------------------
--���� ������
--NOT, AND, OR, BETWEEN, IN
--���� AND�� BETWEEN
--������ 1000�� �̻� 3000�� ������ ������ ��ü ���� ��ȸ
--AND�� �̿��ؼ�
select * from snack where s_price >= 1000 and s_price <= 3000;
--BETWEEN�� �̿���
select * from snack where s_price between 1000 and 3000;
-- between�� �� ������ ���� : between�� �̻�/���Ϸ� ���� ������ ���ϱ� ������ 
-- 1000�� �ʰ� 3000�� �̸��� ���߸� ��ȸ�� ���� between ����� �ָ�...
-- ����1 and ����2 �� ����1�� ���� ���� ����2�� ���� �ݸ� between�� ������ �ѹ��� ó���Ѵ�. 

--������ 1000��,2000��,3000���� ������ ��ü ������ ��ȸ!
--OR������
select * from snack where s_price = 1000 or s_price = 2000 or s_price = 3000;
--IN�� �̿��ؼ�
select * from snack where s_price in (1000,2000,3000);
--���ӵ��� �ʴ� ������ �޾ƿ��� ���� �� => IN�� ���

--�׷� �� ����� �ݴ�Ǵ� ��� ���� �޾ƿ��� �ʹٸ�?
select * from snack where s_price NOT in (1000,2000,3000);

------------------------------------------------------------------------------------------------------------
--���� ������
--���ڿ��� �����ϴ� �˻��� �� �� ��� : like '����'�� ����
-- �� �� ���Ͽ��� '%'�� �ִµ� '�ܾ� 0�� �̻�' ���� ���� �𸥴ٴ� ��!
-- like '%��' : ���� ������ ��
-- like '��%' : ���� �����ϴ� ��
-- like '%��%' : ���� ����

-- like '_��%' : 2��° ���ڰ� ���� ��
-- like '%��_' : �ڿ��� 2��°�� ���ΰ�
-- like '_��' : 2�����ε� ���� ������ ����
-- like '_��' : 2�����ε� ���� ù��° ����

--'��'�� ���� ȸ�翡�� ���� ������ �̸� ��ȸ
select s_name from snack where s_company like '%��%';

--'��'�� ���� ���ڵ� ��հ� ��ȸ
select round(avg(s_price),-1) from snack where s_name like '%��%';

--ũ��� ���ڰų�, �����~ �ΰ� �̸�, ������, ���� ��ȸ
select s_name, s_company, s_price from snack where s_company = 'ũ���' or s_name like '%�����%';

--������ �̸��� '���޴���'�� �����ϰų� 'ġ�佺'�� �����ϴ� ������ �̸�, ������, ���� ��ȸ
select s_name, s_company, s_price from snack where s_name like '%���޴���%' or s_name like '%ġ�佺%';

-- like in�� ���� ���� ������ �ƿ� ����.
select s_name, s_company, s_price from snack where s_name like in ('%���޴���%', '%ġ�佺%');--(x)
--��� ����Ѱ� �����Ѵ�.
--REGEXP_LIKE(�÷���, ����1|����2|...)
--�������� ������ ã�� �ʹٸ� |(������)�� �־ ������ �߰��ϸ� ��
--���Խ�(regex)�� �̿��ؼ� ���ڸ� ã�� ����ε�...

-- ���� �տ� ^�� ������ : ���ϰ����� �����ϴ� ���ڿ� ã��
-- ���� �ڿ� $�� ������ : ���ϰ����� ������ ���ڿ� ã��

--������ �̸��� '���޴���'�� �����ϰų� '��'�� ������ ������ �̸�, ������, ���� ��ȸ
select s_name, s_company, s_price from snack where REGEXP_LIKE(s_name, '*���޴���*|��$');
select s_name, s_company, s_price from snack where REGEXP_LIKE(s_name, '^���޴���|��$');

------------------------------------------------------------------------------------------------------------------------------------------
--���� ������
--������
--UNION : �ߺ��Ǵ� ���� �����ϰ� ���
select 1 id, '����' subject, 90 score from dual
	union
select 2 id, '����' subject, 70 score from dual
	union
select 1 id, '����' subject, 90 score from dual;
--UNION ALL : �ߺ��Ǵ��� ��� ���

select 1 id, '����' subject, 90 score from dual
	union all
select 2 id, '����' subject, 70 score from dual
	union all
select 1 id, '����' subject, 90 score from dual;

--������
--INTERSECT : �� ���̺��� ���� �� ����Ǵ� �� ���
select 1 id, '����' subject, 90 score from dual
	union
select 2 id, '����' subject, 70 score from dual
	intersect
select 1 id, '����' subject, 90 score from dual;

--������
--MINUS : ù ��° select�� �߿��� �ι�° select���� ���� ���� ���
select 1 id, '����' subject, 90 score from dual
	union
select 2 id, '����' subject, 70 score from dual
	minus
select 2 id, '����' subject, 70 score from dual
	MINUS
select 1 id, '����' subject, 90 score from dual;


--���� ������ �߿��� ȸ�簡 ũ����̰� ������ 1000�� �����̰ų� 3000�� �̻��� ���� ��ü������ȸ
--������ �켱���� (�������� �ֿ켱����)
-- OR > AND > NOT > �񱳿����� > ��ȣ

select * from snack where s_company = 'ũ���' and (s_price <=1000 or s_price >= 3000);
select * from snack where s_company = 'ũ���' and s_price not between 999 and 2999;

-------------------------------------------------------------------------------------------------------------
--Group by : �׷����� ���� �����ؼ� �ϳ��� ����� ��Ÿ���� ��
--ȸ�纰 ���� ��� ����, �ּ� ����, �ְ� ����
--group by �ϱ� ���� �ְ�, ������, ��հ� ������ �� => ���� ������ ���
--�̹����� ȸ�纰�� �׷��� ��� ���� ��Ÿ��
select s_company, avg(s_price), min(s_price), max(s_price) from snack group by s_company;

--Rollup ������
--group by rollup [�׷� ���]
--�÷��� ���� �Ұ�(subtotal)�� ����� ��
--group by ���� �÷� ������ n�����, rollup�� ���� ���� n+1��
--ȸ�� �̸�, ȸ�纰 ���� �� ���� �հ�� ��� ���ڵ��� ���� �հ�
select s_company, sum(s_price) from snack group by rollup(s_company);

--NULL�� ���� ���� ������ ������ �ϰ� ������ DECODE �Լ��� ���
--DECODE(�÷���, ����, ���ǿ� �´� �����, ���ǿ� ���� ���� �� �����)
--s_company�� null�̸� '��ü', �װ� �ƴϸ� s_company ��
select Decode(s_company,null,'��ü',s_company), sum(s_price) from snack group by rollup(s_company);

select NVL2(s_company,s_company,'��ü'), sum(s_price) from snack group by rollup(s_company);

--decode ���� : ���� �ڸ����� �� ������ (x), ��� ������ (o)
-----------------------------------------------------------------------------------------------------------
--Having : Group by���� ���� ������ ��� �� ���ϴ� ���ǿ� �����ϴ� �ڷḸ ã���� �� �� ���
--Having�� Where ��� ������ �̿��ؼ� ���ϴ� ���ǿ� �´� �����͸� �����Ѵٴ� �������� �ִµ�
--Having : �׷��� ����� ����
--		vs
--where : ������ ����ؼ� ����� ����

--where�� having ���� ������ ���� �־�� �Ѵ�.
--��, �׷� ���� ������ ������ having�� ����Ѵ�.


--ȸ�纰 ���� ��� ������ 2000�� �̻��� ȸ���� �̸��� ���� ��� ������ ��ȸ
select s_company, avg(s_price) from snack group by s_company having avg(s_price) >= 2000;


--ORDER by : ����! �⺻���� �������� ASC�̸�, �������� ������ DESC
--where +group by + having by + order by 
--�Ե� �Ǵ� ���� ȸ���� ���� ��� ������ 1800�� �̻��� �� �� ȸ���� ��� ���� �������� ����

select s_company, avg(s_price) from snack 
where s_company in ('������','�Ե�','����')
group by s_company
having avg(s_price) >= 1800
order by avg(s_price);





















