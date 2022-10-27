--��������, ���Ѻο�, tablespace
--���̺�, ��, ��, ��Ű��, �ν��Ͻ�, ������
--sql�� ��ɹ� �� ���Ǿ�(DDL)�� ���鼭 ���̺��� ������ �ð�
--���̺� ������ �ʿ��� �ڷ���(�ַ����� ����� �͸�)
-- ������ : varcha2 / ������ : number / ��¥ : date
--	������ varchar2�� �뷮 �Է��� ���� char�� �־ ���� ������ ���� �� �ְ� ����!
--	������ number�� �뷮 �Է��� ���� ���е� / ���� �� �����ؼ� ������!
-- 	��¥ date...�� ������ �� ��!
--����� ������� ���� ���� ! /not null, primary key, foreign key
--table�� ������ �����ϰų�, �����غ��鼭 DDL �Ϸ�!

-- ���� ���̺��� ����ǵ�
-- ���� �̸�, ȸ��, ���� ������ �ְ� �ʹ�
-- ���̺� �ϳ��� PK �ϳ� �־�����...! => ��� PK�� ������ �����غ��鼭!

--�������� -> ȸ�� : ������ / �Ե� => �����̸� : ������ ���� �� �� ���� (PK x)
--ȸ�� �̸� : �� ȸ�翡�� �Ѱ��� ������ ���ڸ� ����� ���� �ƴϴϱ�(PK x)
--PK�� ���
--��ȣ���� ���� ���⿡ PK�� �ִ� �͵� �� ���!

create table snack(
s_code number(4) primary key,
s_name varchar2(10 char) not null,
s_company varchar2(10 char) not null,
s_price number(4) not null
);

-------------------------------------------------------------------------------------------
--�׷��� ������ DML�� �ٷﺼ ��!
--DML�� ������ ���۾�(Data manipulation Language)��� �ϰ�,
--���̺� �����͸� �˻�, ����, ����, ���� �ϴµ� ���Ǵ� ����
--select, insert, update, delete ���� �ְ�,
--�ٿ��� CRUD (CREATE, READ,UPDATE,DELETE)��� ��
--���⼭ C�� (insert)
--���´�
insert into ���̺��(�÷���, �÷���, ...) values(��, ��, ...);

insert into snack(s_code,s_name,s_company,s_price) values(1000,'Ȩ����','����',1500);
--������� �־��ָ� �÷��� ���� ����
insert into snack values(1000,'Ȩ����','����',1500);

--�÷� ���� �ٲ㵵 ��

insert into snack(s_code,s_price,s_name, s_company) values(1000,1500,'Ȩ����','����');

--�÷��� �� �� �ֱ� - ���� not null�̱� ������/not null�� �������� ���� �ߴ�, ������ ���� ���� ���� ���ؼ� null�� ��
insert into snack(s_code,s_price) values(1000,1500);

--���̺� �����
drop table snack cascade constraint purge;
--�ٽ� ���̺� �����ؼ� �� 5������ �־� ����
insert into snack values(1000,'Ȩ����','����',1500);
insert into snack values(1001,'��īĨ','������',1500);
insert into snack values(1002,'���� ����','������',1500);
insert into snack values(1003,'�����۽�','�̷α�',1500);
insert into snack values(1004,'ġ�佺','�����䷹��',1500);

select * from snack;

--�׷���... �����̾� 5�� �־ ������ ���ڵ� ��ȣ���� �ָ� �ƴµ�
--������ ������ ��û���� ���� �ִ�.

--���� ������ ��� �ִٰ� ���߿� �� ������ �ؾ������...
--�����͸� ���鶧���� ������ ��ȣ�� �ڵ����� ����� �Ǿ����� ���ڴ�.

-- factory pattern�̶�� �ؼ� �� �״�� ����ȭ �ý��� !
-- MySQL : autoincrement �ɼ�
-- ���� �츮�� ����ϴ� oracleDB : Sequence��� ���� ����
-- ��ȣ�� ������ �°� �ڵ����� �������ִ� �ǵ�
-- ���̺���� �����ϰ�, �������δ� insert�� �����ص� sequence ���� ������ �ö󰣴�.
-- �׸��� ������ ��(sequence ��)�� �ٽ� ���� �� ����.

-- sequence(table���� ������)����
create sequence ��������();--������ ������
create sequence snack_seq;--���̺��_seq�� ���� �̸��� ���´�.

--��ü���� ������
create sequence ��������
	increment by 1  -- ������ (1�� ����)
	start with 1    -- ���۰�
	minvalue 1      -- �ּҰ�
	maxvalue 999    -- �ִ밪
	nocycle / cycle -- �ִ밪�� �����ϸ� ���� ������ �ٽ� �ݺ����� ���� ����
	nocashe / cashe -- �������� �̸� ����� ���� �޸𸮿��� ������ ���� ����
	noorder / order;-- ��û ������� ���� �������� ����
	
--sequence ����

drop sequence ��������;
drop sequence snack_seq;

--sequnece ��� : ��������.nextval
--������ �ִ� ���̺� �����ߴٰ� �ٽ� ���� ���� �־� ���ô�.!

insert into snack values(snack_seq.nextval,'��īĨ','������',1500);
insert into snack values(snack_seq.nextval,'���� ����','������',1500);
insert into snack values(snack_seq.nextval,'�����۽�','�̷α�',1500);
insert into snack values(snack_seq.nextval,'ġ�佺','�����䷹��',1500);

select *from  snack;

drop sequence snack_seq;
drop table snack cascade constraint purge;

--���� �ٽ� ���̺��̶� ������ �����ְ�, ���̺� �ٽ� ���鶧 �Ӽ� �߰�! (������� Date)

create table snack(
s_code number(4) primary key,
s_name varchar2(10 char) not null,
s_company varchar2(10 char) not null,
s_price number(4) not null,
s_exp date not null
);

create sequence snack_seq;

--���� �ð� ��¥ --------------------------------------------------------------------------
select sysdate from dual;
insert into snack values(snack_seq.nextval, '���޴��� �����', 'ũ���', 500, sysdate);

select * from snack;

--Ư���ð� / ��¥ -----------------------------------------------------------------------------
--		�����Լ� - to_date('��','����')
--		����(�빮��) - YYYY, MM, DD, AM/PM, HH(12�ð�), HH24(��õ), MI(��), SS(��)

insert into snack values(snack_seq.nextval, '���޴��� �����', 'ũ���', 500, 
to_date('2023-10-4 14','YYYY-MM-DD HH24'));

--���� �� ������ �־� ����


insert into snack values(snack_seq.nextval, '��¡����', '���', 1500, 
to_date('2023-11-23 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '������ ����������', '�Ե�', 1500, 
to_date('2023-2-10 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '�� ���� ��������', '������', 1500, 
to_date('2023-3-22 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '���� ������� ����', 'ũ���', 1500, 
to_date('2022-12-24 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '��Ĩ ����������', 'ũ���', 1500, 
to_date('2023-10-22 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '��Ϲ���Ĩ', '����', 1600, 
to_date('2023-8-14 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '���ڱ�', '���', 1400, 
to_date('2022-12-4 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '������', '���', 1400, 
to_date('2022-12-4 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '�ߴٸ� �ҹٺ�ť', '���', 1200, 
to_date('2022-12-25 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '�ſ� �����', '���', 1300, 
to_date('2023-4-28 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '�ٳ���ű', '���', 1700, 
to_date('2023-6-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval, '�˻���Ĩ', '���', 1500, 
to_date('2023-9-14 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'��īĨ','������',1500,to_date('2023-12-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'���� ����','������',2500,to_date('2023-11-10 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'�����۽�','�̷α�',1500,to_date('2023-5-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'ġ�佺','�����䷹��',1500,to_date('2023-6-30 14','YYYY-MM-DD HH24'));

insert into snack values(snack_seq.nextval,'��īĨ ��뷮','������',3000,to_date('2023-12-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'���� ���� ��뷮','������',3000,to_date('2023-11-10 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'�����۽� �̱���','�̷α�',3000,to_date('2023-5-12 14','YYYY-MM-DD HH24'));
insert into snack values(snack_seq.nextval,'ġ�佺 ��뷮','�����䷹��',3000,to_date('2023-6-30 14','YYYY-MM-DD HH24'));

--====================================================================================================================================================
--R(Read)
select [distinct] [�÷���], [�÷��� as ��Ī || �÷��� ��Ī], [������ ���], [����Լ�],...
from [���̺��]
where [���ǽ�]
group by [���ǽ�]
having [�Լ� ���� ����]
order by [���Ĵ�� ASC/DESC(�������� / ��������)] --�⺻���� ��������

--�������̺� ��ü ��ȸ
-- '*' : ���̺� ���� ��� �÷��� �����´�.
select * from snack;
----------------------------�ߺ� ���� �� select------------------------------------------------
select distinct s_company from snack;


----------------------------�÷��� as ��Ī || Ŀ���� ��Ī select-------------------------------
--��Ī ���� ��쿡��... select�� �ȿ��� ���� ����� �����ѵ�(+,-,*,/)
select s_company / 100 from snack;
--�÷��� ��ü�� s_price/100���� ����
--���� ���α׷��� ���� �����ϴٺ��� �÷����� �̿��ؼ� ���� �ҷ����� ��찡 �ִµ�,
--��Ī�̶�� ���� �Ἥ �򰥸��� �����ϴ� �뵵�� ���

--AS�� �Ἥ �ϴ� ��
select s_price / 100 as s_percent from snack;
--�÷��� �����ϰ� �ٷ� ��Ī���� ��
select s_price / 100 s_percent from snack;


----------------------------������ ��� select------------------------------------------------
--������! (���������)
--Dual ���̺�
--1. ����Ŭ ��ü���� �������ִ� �������̺�
--2. �����ϰ� �Լ��� �̿��ؼ� ��� ��� ���� Ȯ�� �� �� ����ϴ� ���̺�
select 1 + '3' as result from dual;
--4�� ����!
--��κ� �ٸ� ���� ���� ��쿡�� '���� �켱' 13�̶�� ����� �����µ�
--����Ŭ������ �ݴ�� '���� �켱'
--����Ŭ�������� �����ڰ� ���ڸ� ���� ����
select 1 + 'a' from dual; --���� (���ڷ� �ٲ� �� ���ٴ� ���� 'invalid number')
select 'a' + 'b' from dual;--���� (���ڷ� �ٲ� �� ���ٴ� ���� 'invalid number')
select 'b' from dual;--��� b
--���ڸ� �����ֱ� ���� �����ڰ� ���� �ִµ�
--�ٷ� ||
select 1||'a' as result from dual;












