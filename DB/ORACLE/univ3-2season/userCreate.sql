drop user test cascade;

-- test ����� �����ϱ�
CREATE USER test IDENTIFIED BY database;


-- Grant ��ɾ�� ����, ��� ���� �ֱ�
grant connect, resource, create view  to test;