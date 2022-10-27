-- select [distinct] [�÷���], [�÷��� as ��Ī Ȥ�� �÷��� ��Ī], [������], [����Լ�], ...
-- from [���̺��]
-- where [���ǽ�]
-- group by [�׷� ��� �÷���]
-- having [�Լ� ���� ���ǽ�]
-- order by [���� ��� �÷��� asc / desc ]
--------------------------------------------------------------------------------------------------
-- ��ľ� ����������

-- ȫ����� �Ǳ����� ȫ�浿�� ��ϰ� 100��
-- ȫ����� �������� ��浿�� ��ϰ� 80��
-- �ѽ����� �������� ȫ�浿�� ��ϰ� 150��
-- ��õ���� ��õ���� �ֱ浿�� ��ϰ� 130��

create table sep01_franchise(
	f_no number(3) primary key,
	f_name varchar2(10 char) not null,
	f_location varchar2(10 char) not null,
	f_ceo number(3) not null,					-- ����� ��ȣ
	f_seat number(3) not null
);
create sequence sep01_franchise_seq;

insert into sep01_franchise values(sep01_franchise_seq.nextval, 'ȫ�����', '�Ǳ�', 1, 100);
insert into sep01_franchise values(sep01_franchise_seq.nextval, 'ȫ�����', '����', 2, 80);
insert into sep01_franchise values(sep01_franchise_seq.nextval, '�ѽ�����', '����', 3, 150);
insert into sep01_franchise values(sep01_franchise_seq.nextval, '��õ����', '��õ', 4, 130);
insert into sep01_franchise values(sep01_franchise_seq.nextval, '�ϰ����', '��õ', 4, 110);

select * from sep01_franchise;
--------------------------------------------------------------------------------------------
-- ȫ�浿, 1990-03-01�ϻ�, ����
-- ��浿, 1992-02-01�ϻ�, ����
-- ȫ�浿, 1991-12-12�ϻ�, ����
-- �ֱ浿, 1989-09-01�ϻ�, ����

create table sep01_ceo(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_birthday date not null,
	c_gender char(2 char) not null
);

create sequence sep01_ceo_seq;

insert into sep01_ceo values(sep01_ceo_seq.nextval, 'ȫ�浿', to_date('1990-03-01', 'YYYY-MM-DD'), '����');
insert into sep01_ceo values(sep01_ceo_seq.nextval, '��浿', to_date('1992-02-01', 'YYYY-MM-DD'), '����');
insert into sep01_ceo values(sep01_ceo_seq.nextval, 'ȫ�浿', to_date('1991-12-12', 'YYYY-MM-DD'), '����');
insert into sep01_ceo values(sep01_ceo_seq.nextval, '�ֱ浿', to_date('1989-09-01', 'YYYY-MM-DD'), '����');

select * from sep01_ceo;

--------------------------------------------------------------------------------------------
-- ¥���, 5000��, ȫ����� �Ǳ���(100��)���� �Ĵ�
-- �Ҵ߹�, 12000��, �ѽ����� ������(150��)���� �Ĵ�
--	... ����� �޴� 5������!

create table sep01_menu(
	m_no number(2) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null,
	m_f_no number(3) not null,
	constraint FK_menu foreign key(m_f_no) 
	references sep01_franchise(f_no) on delete cascade
);
--drop table sep01_menu cascade constraint purge;
create sequence sep01_menu_seq;

insert into sep01_menu values(sep01_menu_seq.nextval, '¥���', 6000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '������', 15000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '������', 7000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '«��', 7000, 1);
insert into sep01_menu values(sep01_menu_seq.nextval, '���꽽', 30000, 1);

insert into sep01_menu values(sep01_menu_seq.nextval, '���ڿϽ�', 30000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '�粿ġ', 15000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '������', 10000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '������', 35000, 2);
insert into sep01_menu values(sep01_menu_seq.nextval, '�� ����', 28000, 2);

insert into sep01_menu values(sep01_menu_seq.nextval, '���ڳ�̾߳�', 10000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, 'Ÿ�ھ߳�', 5000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, '���', 9000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, '�����ٽ�', 50000, 3);
insert into sep01_menu values(sep01_menu_seq.nextval, '����ư�', 15000, 3);

insert into sep01_menu values(sep01_menu_seq.nextval, '�Ҵ߹�', 8000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '���� ������', 8000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '�߶���', 12000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '������', 18000, 4);
insert into sep01_menu values(sep01_menu_seq.nextval, '����', 40000, 4);


insert into sep01_menu values(sep01_menu_seq.nextval, '����� ȸ ��Ʈ', 50000, 3);

select * from sep01_menu;



