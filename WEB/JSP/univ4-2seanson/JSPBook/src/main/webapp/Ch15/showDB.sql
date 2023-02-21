use JSPBookDB;
CREATE TABLE IF NOT EXISTS member(
id int NOT NULL AUTO_INCREMENT,--(id 입력시)자동으로 증가한다.
 passwd VARCHAR(20),
 name VARCHAR(30),
 PRIMARY KEY(id)
)
show tables;
desc member;
ALTER TABLE member ADD phone varchar(100);
ALTER TABLE member DROP COLUMN phone;
ALTER TABLE student CHANGE COLUMN passwd password varchar(60);
RENAME TABLE member TO student;

insert into student (id,password,name) values('1','1234','Chung');
insert into student (id,password,name) values('2','4321','Kang');
insert into student (id,password,name) values('3','1244','Shin');
--insert into student (id,password,name) values('4','1357','백');


select * from student;
select * from student limit 2;
delete from student where id = 1;

delete from student;

desc student;
