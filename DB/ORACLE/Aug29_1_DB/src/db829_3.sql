--학과 테이블과 이것을 참조하는 학생 테이블을 만들어보자!
--학과 테이블 : 학과코드(4자리 숫자), 학과 이름(10글자 이내)

--학생 테이블 : 학생번호(3자리 숫자), 학생 이름, 학생이 소속되어있는 학과 코드
--그 학과가 없어지면 이 학생 정보도 지워지게

create table department(
	d_code number(4) primary key,
	d_name varchar2(10 char) not null
); 

insert into department values(3456,'수학과');
insert into department values(2651,'컴퓨터 공학과');


create table student(
	s_code number(3) primary key,
	s_name varchar2(10 char) not null,
	s_d_code number(4) not null,
	constraint FK_s_d_code foreign key(s_d_code) 
	references department(d_code) on delete cascade
);

insert into student values(216, '김수학', 3456);
insert into student values(217, '김컴퓨터공학',2651);
insert into student values(219, '김산수', 3456);
insert into student values(220, '김AI',2651);
insert into student values(220, '김AI',3010);--오류 : 3010은 department에 존재 하지 않는다.

select d_code from department;
select s_d_code from student;


delete from department where d_code = '3456'; 

drop table department; -- 에러 이유 : 참조하고 있는 table(student)이 존재하기 때문이다.

drop table department cascade constraint purge;
--이렇게 되면 참조하는 table의 data를 지운게 아니기 때문에 student table에는 값이 그대로 남게 된다.
--따라서 student table도 따로 지워줘야한다.
select * from student;
-------------------------------------------------------------------------------------------------------











