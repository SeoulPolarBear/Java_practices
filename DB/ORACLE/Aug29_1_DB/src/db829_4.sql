create table aug29_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null,
	c_kcal number(3) not null,
	c_start date not null
);

insert into aug29_coffee values('�Ƹ޸�ī��', 3000, 15, sysdate);
select * from aug29_coffee;

--DDL ���� Create���� �ٷ� �� �ְ� �Ǿ���!
--���� ���� ���� alter/ drop/ truncate�� ����!

-- 1. ������ Ÿ�� ���� / �÷��� ũ��(�뷮) ����
--alter [table��] modify [������ �÷���] [������Ÿ��(�뷮)];
--������ ���Ἲ ���� ���� ������ �߻��ϴ� ����
alter table aug29_coffee modify c_name number(10);--���� ���� ��� �ִ� ���¿��� domain�� �����Ϸ��� �߱� �����̴�.
alter table aug29_coffee modify c_name varchar2(2 char);--���� �뷮�� �Ѿ ���� �����ϱ� ������

-- ���ǻ��� : ������Ÿ���� ������ ���� �ش� �÷��� ���� ��� ������ ������ �����ϴ�.
-- �׷��� ������ ������ �߻�!
-- �÷��� �뷮�� ���� ��� �ش� Ŀ���� �뷮�� ��ȸ�ؼ� ������ ���̺���
-- ū ���� �ִ��� Ȯ���ϰ� => �� ���� �����ϸ� �ȴ�.

--2. �÷��� ����
alter table [���̺��] rename column [���� �÷���] to [�ٲ� �÷���];

alter table aug29_coffee rename column c_name to c_name2;

select * from aug29_coffee;

--3. �÷� �߰�
alter table [���̺��] add [�÷���] [������Ÿ��] [��������(��������)];
truncate table aug29_coffee;
alter table aug29_coffee add c_taste varchar2(20 char) not null;-- �� not null�� �������� ������ data�� ����� �Ѵ�.
insert into aug29_coffee values('�Ƹ޸�ī��', 3000, 15, sysdate, '������ ���');


--4. �÷� ����
alter table [���̺��] drop [�÷���];
alter table aug29_coffee drop column c_taste;
------------------------------------------------------------------------------------------------------------------
--���̺� ���� ���� �����
truncate table [���̺��];
truncate table aug29_coffee;
--���̺� �ִ� �����͸� ����������, ���̺��� ���� ��ü�� �������� ����

--���̺� ������(�����뿡 �ֱ�)
drop table [���̺��] cascade constraint;
drop table aug29_coffee cascade constraint;

--�����뿡 �ִ� ���̺��� ����
flashback table [���̺��] to before drop;
flashback table aug29_coffee to before drop;

--������ ����
purge recyclebin;

--�����뿡 �ֱ� + ���� => ���̺� ���� ���� (�����뿡 ������� ����)

drop table [���̺��] cascade constraint purge;
drop table aug29_coffee cascade constraint purge;
--------------------------------------------------------------------------------------------------------------------
--DDL : ��ǻ� �������� �ñ��� ����!
-- ����ִ� DBA���� ���̺��� ���� CRUD������ �ϰԲ� �� ��



