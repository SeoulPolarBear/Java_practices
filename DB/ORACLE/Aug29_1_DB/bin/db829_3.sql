--�а� ���̺�� �̰��� �����ϴ� �л� ���̺��� ������!
--�а� ���̺� : �а��ڵ�(4�ڸ� ����), �а� �̸�(10���� �̳�)

--�л� ���̺� : �л���ȣ(3�ڸ� ����), �л� �̸�, �л��� �ҼӵǾ��ִ� �а� �ڵ�
--�� �а��� �������� �� �л� ������ ��������

create table department(
	d_code number(4) primary key,
	d_name varchar2(10 char) not null
); 

insert into department values(3456,'���а�');
insert into department values(2651,'��ǻ�� ���а�');


create table student(
	s_code number(3) primary key,
	s_name varchar2(10 char) not null,
	s_d_code number(4) not null,
	constraint FK_s_d_code foreign key(s_d_code) 
	references department(d_code) on delete cascade
);

insert into student values(216, '�����', 3456);
insert into student values(217, '����ǻ�Ͱ���',2651);
insert into student values(219, '����', 3456);
insert into student values(220, '��AI',2651);
insert into student values(220, '��AI',3010);--���� : 3010�� department�� ���� ���� �ʴ´�.

select d_code from department;
select s_d_code from student;


delete from department where d_code = '3456'; 

drop table department; -- ���� ���� : �����ϰ� �ִ� table(student)�� �����ϱ� �����̴�.

drop table department cascade constraint purge;
--�̷��� �Ǹ� �����ϴ� table�� data�� ����� �ƴϱ� ������ student table���� ���� �״�� ���� �ȴ�.
--���� student table�� ���� ��������Ѵ�.
select * from student;
-------------------------------------------------------------------------------------------------------











