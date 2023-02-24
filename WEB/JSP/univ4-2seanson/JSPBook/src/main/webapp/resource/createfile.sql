CREATE TABLE IF NOT EXISTS Student(
	num int NOT NULL, 
	depart VARCHAR(20),
	name VARCHAR(20),
	address VARCHAR(20),
	phone VARCHAR(20),
	primary key(num)
);

DESC Student;


INSERT INTO Student VALUE(2018100001,"����ϰ�","ȫ���","�����","010-9002-1234");
INSERT INTO Student VALUE(2018100002,"����ϰ�","ȫ�浿","��⵵","010-2009-4321");
INSERT INTO Student VALUE(2018200001,"�����","������","��õ��","010-3918-0007");
INSERT INTO Student VALUE(2018200002,"�����","��ٿ�","�����","010-93002-0101");

SELECT * FROM Student;

SELECT * FROM Student where depart = "����ϰ�";

UPDATE Student SET depart = "��ǻ�Ͱ�" where depart = "����ϰ�";

DELETE FROM Student where depart = "�����";