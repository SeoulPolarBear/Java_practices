create table oct06_fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null
);

-- 값 5~6개

insert into oct06_fruit values('포도', 3200);
insert into oct06_fruit values('사과', 1000);
insert into oct06_fruit values('망고', 3500);
insert into oct06_fruit values('샤인머스캣', 13200);
insert into oct06_fruit values('레몬', 1200);
insert into oct06_fruit values('거봉', 5000);

select * from OCT06_FRUIT;
