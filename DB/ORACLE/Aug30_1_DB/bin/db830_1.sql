--1. ��Ʈ�Ͽ� ���� ���̺��� ����...
--��Ʈ���� �̸�, ����, CPU, RAM, HDD, ���� �Ⱓ�� �Ӽ����� ���� �ϰ� ����
--���ǿ� �����ϴ� ���̺��� �ۼ��ϴ� ����
--[�ϳ��� �⺻Ű�� ������ �ϰ�, ��� ���� ä���־�� ��]
create table Laptop(
l_code varchar2(20 char) primary key,
l_name varchar2(20 char) not null,
l_price number(7) not null,
l_cpu varchar2(20 char) not null,
l_ram number(2) not null,
l_hdd number(4) not null,
l_guarantee date not null
);

select * from laptop;
--2. ��Ʈ���� ����� �������� 128GB¥�� RAM�� ����ϰ� �Ǿ���
-- �� �� RAM �÷��� �뷮�� �����ϴ� ���� �ۼ�
alter table laptop modify l_ram number(3);

--3. ��Ʈ���� ũ��(��ġ)�� ���� �÷��� �߰��ϴ� ���� �ۼ�
--[���� cm, �Ҽ��� �ι�° �ڸ����� ��Ÿ�� ��]
--[�� �÷��� �� ������ ���� �� ����]
alter table laptop add l_inch number(4,2) not null;

--4. ��Ʈ�Ͽ��� ������ HDD��ſ� SSD�� ������
--HDD �÷��� �̸��� SSD Ŀ�������� �����ϴ� ���� �ۼ�
alter table laptop rename column l_hdd to l_ssd;

--5. ���� �Ⱓ �÷��� �����ϴ� ���� �ۼ�
alter table laptop drop column l_guarantee;

--6. ��Ʈ���� ������ [80�� ~ 230��] ������ ���� �� �� �ְԲ�
--�ش� �÷��� �����ϴ� ���� �ۼ�
--alter table laptop drop column l_price;
--alter table laptop add l_price number(7) check(l_price between 800000 and 2300000) not null;
alter table laptop modify l_price constraint n_check check(l_price between 800000 and 2300000);

--7. ���� ���̺��� ������ �����ϴ� ���� �ۼ�
drop table laptop cascade constraint purge;
truncate table laptop;
