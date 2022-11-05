create table oct04_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null
);

create sequence oct04_student_seq;

select * from oct04_student;

create table oct04_test(
    t_no number(3) primary key,
	t_subject varchar2(10 char) not null,
	t_date date not null,
	t_s_no number(3) not null,
	foreign key (t_s_no) 
	references oct04_student(s_no)
	 on delete cascade
);

create sequence oct04_test_seq;