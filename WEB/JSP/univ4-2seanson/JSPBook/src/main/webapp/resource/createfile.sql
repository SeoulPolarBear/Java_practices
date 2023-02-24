CREATE TABLE IF NOT EXISTS Student(
	num int NOT NULL, 
	depart VARCHAR(20),
	name VARCHAR(20),
	address VARCHAR(20),
	phone VARCHAR(20),
	primary key(num)
);

DESC Student;


INSERT INTO Student VALUE(2018100001,"모바일과","홍길순","서울시","010-9002-1234");
INSERT INTO Student VALUE(2018100002,"모바일과","홍길동","경기도","010-2009-4321");
INSERT INTO Student VALUE(2018200001,"영어과","수여인","인천시","010-3918-0007");
INSERT INTO Student VALUE(2018200002,"영어과","김다운","서울시","010-93002-0101");

SELECT * FROM Student;

SELECT * FROM Student where depart = "모바일과";

UPDATE Student SET depart = "컴퓨터과" where depart = "모바일과";

DELETE FROM Student where depart = "영어과";