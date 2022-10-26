--[�ɼ�]
--��������(constraint) �̶�� �θ�
--������ ���Ἲ�� �����ϱ� ���� �뵵 
--������ ���Ἲ : �����ͺ��̽��� ����� �����Ϳ� �ϰ����� ��Ȯ���� ��Ű�� ��

	--	1. ������ ���Ἲ ���� ����(Domain Constraint)
		--	���̺� ���� Ʃ�õ��� �� �Ӽ��� �����ο� ������ ���� ������ �Ѵٴ� ����
			--������ Ÿ��(type), ��(null / not null), �⺻��(default), üũ(check) ���� Ȱ���ؼ� ����
			
	--	2. ��ü (�⺻Ű�� ��ƼƼ) ���Ἲ ��������
	--		�⺻Ű ����(Primary key Constraint)�̶�� ��
	--		��ü(entity) : ���, ���, �繰, ��� ��� ���� ���������� �����ϸ鼭, �����ϰ� �ĺ��� ������ ����
	--				��, ��� record��(Ʃ�õ�)�� ��ü��� �����ϸ� �ǰڴ�. ��ü(�Ӽ�1, �Ӽ�2, ...)
	--				�ƹ��� ���� ��ü�� �־, ���� ���ϴ� '������' ��ü�� �߰��� �� �־�� �Ѵ�!				
	--				���̺��� �⺻Ű�� �����ϰ� , Null���� �������� �ȵǸ�,
	--				���̺��� ���� �ϳ��� ���� �����ؾ� �Ѵٴ� ����.
	
	--	3. ����(�ܷ�Ű) ���Ἲ ��������
--			�ܷ�Ű ����(Foreign key constraint)�̶�� �ϸ�,
--			���̺� ���� ���� ���踦 �����ϴ� ���� ����
--			���� �޴� ���̺��� �ܷ�Ű�� �����ϴ� ���̺��� �⺻Ű�� �����ؾ� �ϸ�,
--			���� �޴� ���̺��� ���� ���� �� ��, �����ϴ� ���̺��� ������ �޴� ��.

------------------------------------------------------------------------------------------------------------------------------
--1. Not Null : NULL�� ���� ����ִٴ� ��!
--				=> 0�̳� ���⵵ �ƴ� ���� ���� ���� ���� ����
--				NULL�� ������� �ʴ´�.
--					=> �ʼ������� �Է��ؾ� �� �÷��� �����Ѵ�.
--					=> ���� ���� ���Ǵ� ���� ����!!
--				: ���̺��� ���� �� ������ ���� ���� �������� ������~

-- �������Ǹ��� ���� �ο����� �ʴ� ���(Oracle�� �ڵ����� �ο�)
create table example1(
	col1 varchar2(10),
	col2 varchar2(10 char) not null-- is�� ������ �����ϴ�.	
);

--Constraint Ű���带 ����ؼ� �������Ǹ��� ���� �ο��ϴ� ���
create table example2(
	col1 varchar2(10 char),
	col2 varchar2(10 char)
	constraint col2_notnull not null
);

create table example2_1(
	col1 varchar2(10 char),
	col2 varchar2(10 char)
	constraint col2_1_notnull not null
);

--2. Unique : �ܾ� �� �״�� �ش� �÷��� ���� ���� ��ü ���̺��� �����ؾ� �Ѵٴ� ����
--			Not Null�� �Բ� ����� ����������, Unique�� ���� �������� �ʴ´�.
create table example3(
	col1 varchar2(10 char) unique,
	col2 varchar2(10 char) unique not null,
	col3 varchar2(10 char),
	constraint col3_unique unique(col3)
);

--select * from all_tables;

--3. Primary Key(�⺻ Ű) : NULL�� ������� �ʰ�, �ߺ��� �����͸� ������� �ʴ´�
--		(Not NULL + Unique => primary key) ���� primary key�� ����ϸ� not null ������� �ʾƵ� �ȴ�.
--		�������� Ư�� ������ �˻��ϰų� ���� ���� �۾��� �� �� �⺻ Ű�� �����Ѵ�.
--		ID, �ֹε�Ϲ�ȣ, ȸ�� ��ȣ, �� ��ȣ ��
--		�Ϲ������� ���̺��� 1���� �⺻Ű�� ������ �������� ������!

create table example4(
	col1 varchar2(10 char) primary key,
	col2 varchar2(10 char) not null,
	col3 varchar2(10 char) not null
);
--���� �÷��� ���� �� constraint Ű���带 ��� + ������ PK�� ������ �ϳ�������...!
create table example5(
	col1 varchar2(10 char),
	col2 varchar2(10 char) not null,
	col3 varchar2(10 char) not null,
	constraint PK_example5 primary key(col1, col2)
);

--** ��¥ �����
-- 4. Foreign Key(�ܷ� Ű) : �ٸ� ���̺��� Ư�� �÷��� ��ȸ�ؼ� ������ �����Ͱ� �ִ� ��쿡�� �Է��� ���ȴ�.
--			�����ϴ� ���̺��� PK�� Unique�� ������ �÷����� FK�� ������ �� �ִ�.
--			�ܷ�Ű ������ ���ؼ��� �����޴� �÷��� ���� �����Ǿ�� �ϰ�,
--			�ܷ�Ű�� ���� ���̺��� �� ���Ŀ� ������ �Ǿ�� �Ѵ�.

--�ܷ�Ű�� ���� ���̺��� ����
create table example6(
	�÷��� �ڷ���,
	constraint FK�� foreign key(�÷���)
	references ������̺��(������̺��� �⺻Ű or ����Ű) 
	on delete set null || on delete  cascade
	--�����޴� ���̺��� �� �κ��� ������ �� 
	--�� ���̺��� ����Ǿ� �ִ� �࿡ ���ؼ�
	--on delete set null : Null���� ������
	--on delete  cascade �� �൵ ���� �������� ���� �ɼ�
	
	-- ����� cascade �ϸ� �� record�� ���� ��������.
	
	--�̶� update�� �� �� ������ �߻��Ѵ�. ��, on update�� ���� ���� �ʴ´�.
	--���� ���� ������ �Ǿ��ְ� �ǰ� ���� �Һ��� �Ǿ������.
	--���� table�� ���� ����� �������� ������ �ִ�.
);

create table example6(
	ex6_id varchar2(10 char) primary key
);

insert into example6 values('10');
insert into example6 values('20');
insert into example6 values('30');

select * from example6;

create table example7(
ex7_id varchar2(10 char),
constraint fk_ex7 foreign key(ex7_id) references example6(ex6_id) on delete cascade
--,constraint pk_ex7 primary key(ex7_id)
);


insert into example7 values('10');
insert into example7 values('20');
insert into example7 values('30');
insert into example7 values('40');

delete from example6 where ex6_id = '10';

delete from example6 where ex6_id = '40';

drop table example7;

select * from example7;

--drop table example1 cascade constraint purge; 
--drop table example2 cascade constraint purge; 
--drop table example2_1 cascade constraint purge; 
--drop table example3 cascade constraint purge; 
--drop table example4 cascade constraint purge; 
--drop table example5 cascade constraint purge; 
--drop table person cascade constraint purge; 
--drop table test3 cascade constraint purge; 
---------------------------------------------------------------------------------------------------------
--5. Check : �������� ���� ������ ������ �����ؼ� ���ǿ� �ش��ϴ� �����͸� ����Ѵ�.
create table example8(
	col1 number(3) constraint ex8_check check (col1 between 1 and 9)
);

drop table example8 cascade constraint purge;

--6. default : �ƹ��� �����͸� �Է����� ���� ��� ������ �����Ͱ� �ڵ����� �Էµ�
create table example9(
	col1 number(4) default 999 
);

insert into example9 values(default);
insert into example9 values();-- �̰� �ȵ�
insert into example9 values(null);
insert into example9 values(0);
insert into example9 values(11);

select * from example9;












