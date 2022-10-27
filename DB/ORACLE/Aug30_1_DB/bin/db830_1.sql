--1. 노트북에 대한 테이블을 생성...
--노트북의 이름, 가격, CPU, RAM, HDD, 보증 기간을 속성으로 갖게 하고 싶음
--조건에 부합하는 테이블을 작성하는 문장
--[하나의 기본키를 가져야 하고, 모든 값은 채워넣어야 함]
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
--2. 노트북의 사양이 좋아져서 128GB짜리 RAM을 사용하게 되었음
-- 이 때 RAM 컬럼의 용량을 변경하는 문장 작성
alter table laptop modify l_ram number(3);

--3. 노트북의 크기(인치)에 대한 컬럼을 추가하는 문장 작성
--[단위 cm, 소수점 두번째 자리까지 나타낼 것]
--[이 컬럼은 빈 값으로 넣을 수 없음]
alter table laptop add l_inch number(4,2) not null;

--4. 노트북에는 앞으로 HDD대신에 SSD가 장착됨
--HDD 컬럼의 이름을 SSD 커럼명으로 변경하는 문장 작성
alter table laptop rename column l_hdd to l_ssd;

--5. 보증 기간 컬럼을 삭제하는 문장 작성
alter table laptop drop column l_guarantee;

--6. 노트북의 가격이 [80만 ~ 230만] 사이의 값만 들어갈 수 있게끔
--해당 컬럼을 변경하는 문장 작성
--alter table laptop drop column l_price;
--alter table laptop add l_price number(7) check(l_price between 800000 and 2300000) not null;
alter table laptop modify l_price constraint n_check check(l_price between 800000 and 2300000);

--7. 만든 테이블을 완전히 삭제하는 문장 작성
drop table laptop cascade constraint purge;
truncate table laptop;
