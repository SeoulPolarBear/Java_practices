create table sep28_member(
m_id varchar2(20 char) primary key,
m_passwd varchar2(20 char) not null,
m_name varchar2(20 char) not null,
m_phoneNum varchar2(20 char) not null,
m_birthday date not null,
m_photo varchar2(20 char) not null
);

drop table sep28_member;
select * from sep28_member;