--JOIN
-- �ϳ��� ��ɹ��� ���� ���� ���̺� ����� �����͸� �ѹ��� ��ȸ�� �� �ִ� ���
-- ��ġ �ϳ��� ���̺��� ��ó�� ������

create table tb1 (name varchar2(10 char), age number(3));
create table tb2 (name varchar2(10 char), age number(3));

insert into tb1 values('�����',30);
insert into tb1 values('�ڼ���',31);
insert into tb1 values('������',35);
insert into tb1 values('������',39);

insert into tb1 values('���İ�',45);
insert into tb1 values('���İ�',50);

insert into tb2 values('���İ�',40);
insert into tb2 values('���İ�',55);
insert into tb2 values('���İ�',50);
insert into tb2 values('���İ�',44);

insert into tb2 values('�����',35);
insert into tb2 values('�ڼ���',40);

------------------------------------------------------------------------------------------------------
-- cross join : ������ ���� ���� �� ���̺��� ������ ��� ����� ��ȸ(��� ����� ��)
--��ǻ� �Ⱦ���.
select * from tb1,tb2;
select * from tb1 cross join tb2;

--inner join : ���ǿ� �ش��ϴ� ���� ����
select * from tb1 inner join tb2 on tb1.name = tb2.name;
select * from tb1 A, tb2 B where A.name = B.name;		--EQUI ����(���� ����)
select * from tb1 join tb2 using (name);				--EQUI ���� JOIN ~ USING(���δ���÷���)
select * from tb1 natural join tb2; 					--�ڿ� ����, ������ ���� ���ʿ� ���� �̸��� ���� ������ �÷����� ��ȸ

--outer join : outer join�� ����ϴ� ������ ���� ���̺��� �����Ͱ� ��� ��ȸ(���� ����) �ǰ�,
--				��� ���̺� �����Ͱ� �ִ� ��� �ش� �÷��� ���� �������� ���ؼ�!
--	(+)�� �̿��� outer join : null�� ��µǴ� ���̺��� �÷� (+) ��ȣ �߰�

-- left outer join : ���� ���̺� ���� ���� �� ������ ���̺��� ���ǿ� ���� �ʾƵ� ����
--						(���ǿ� ���� ������ null�� �޲�)
--						Right ���ٴ� Left�� �� ���� ��(���� ���̺��� �������� �δ� ���� O)
select * from tb1 left outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name = tb2.name(+);


--right outer join : ������ ���̺� ���� ���� �� ���� ���̺��� ���ǿ� ���� �ʾƵ� ����
--						(���ǿ� ���� ������ null�� �޲�)
select * from tb1 right outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name(+) = tb2.name;

--full outer join : ���� ���̺� ���� ���� ��, �ٸ� �� ���̺��� ���ǿ� ���� �ʾƵ� ����
--						(���ǿ� ���� ������ null�� �޲�)
select * from tb1 full outer join tb2 on tb1.name = tb2.name;

--self join ** �򰥸�
--�ϳ��� ���̺� ���� �ִ� �÷����� �����ϴ� ������ �ʿ��� ���
--�ܾ� �״���� �� ó�� ������ JOIN�Ѵٴ°�!

--�� ������Ʈ�� ȸ���� 5���� �ְ�, �����ڰ� 2���� �ִ�.
--ȸ���� �̸��� ���� ȸ��1~5, �������� �̸��� ������1,2
--ȸ���� ���̵�� ���� member1~5, �������� ���̵�� manager1, 2
--ȸ�� 1~3���� ������ 1�� ���� / ������ ȸ���� ������ 2�� ����

create table sep02_member(
	m_id varchar2(10 char) primary key,
	m_name varchar2(10 char) not null,
	m_manager varchar2(10 char) --�����ڵ��� ������ �ȹ����� ���� ���� X
);

insert into sep02_member values('member1', 'ȸ��1', 'manager1');
insert into sep02_member values('member2', 'ȸ��2', 'manager1');
insert into sep02_member values('member3', 'ȸ��3', 'manager1');
insert into sep02_member values('member4', 'ȸ��4', 'manager2');
insert into sep02_member values('member5', 'ȸ��5', 'manager2');
insert into sep02_member values('manager1', '������1', null);
insert into sep02_member values('manager2', '������2', null);

select * from sep02_member;

-- �� �����ڰ� � ȸ���� �����ϴ��� �˰� ����
--select *
--	from sep02_member A join sep02_member B on A.m_id = B.m_id; 

	select A.M_ID, A.m_name, b.m_id
	from sep02_member A inner join sep02_member B on A.m_id = B.m_manager; 
	-- ���� ���̺������� ���������� �ϱ� ����
	-- ���̺� ��Ī�� �־ ��������
	-- ���� ID�� ������ ������ ���� 
	-- ������ �����ؼ�
	-- �����ϴ� ȸ�� ID ���� ������ �� �ְ�!
																










