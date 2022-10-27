select * from SEP01_FRANCHISE;
select * from SEP01_CEO;
select * from SEP01_MENU;
----------------------------------------------------------------------------------------------------
--좌석 수 제일 많은 식당 운영하는 사람의 전체 정보 조회
select * from SEP01_CEO
where c_no = (
	select f_ceo 
	from SEP01_FRANCHISE
	where f_seat = (
		select max(f_seat) 
		from sep01_franchise
		)
	);

--프랜차이즈 메뉴 전체의 이름, 가격
--을 가격 오름차순 -> 가격이 같다면 메뉴명을 가나다 역순 정렬
--여러번 정렬 하고 싶을 때... => order by 컬럼명, 컬럼명,...
select m_name, m_price 
from SEP01_MENU
where m_f_no in (
	select f_no 
	from SEP01_FRANCHISE
	)
	order by m_price , m_name desc;


--전체 사장님들 이름, 생일 조회
select c_name, to_char(c_birthday, 'YYYY.MM.DD') as 생년월일 from SEP01_CEO; 
 
--프렌차이즈 식당 몇 개?
select count(*) from SEP01_FRANCHISE;

--프랜차이즈 메뉴 전체의 평균가
select avg(m_price) 
from sep01_menu
where m_f_no in
	(select f_no 
	from sep01_franchise
	);
	
--제일 비싼 메뉴 이름, 가격
select m_name, m_price from SEP01_MENU
where m_price =(
	select max(m_price) 
	from SEP01_MENU
	);
	
-- 최연장자 사장님의 이름, 생일
--subquery가 날짜에도 적용된다!! (최연장자 = 최소 생일 값)
select c_name, to_char(c_birthday, 'YYYY.MM.DD') as 생년월일 
from SEP01_CEO
where c_birthday =(
		select min(c_birthday) 
		from SEP01_CEO
		);
	
-- 좌석 수 제일 적은 식당의 이름, 지점명, 좌석수
select f_name, f_location, f_seat
from SEP01_FRANCHISE
where f_seat =(	
	select min(f_seat) 
	from sep01_franchise
	);
	
--서브쿼리문과 join의 차이
-- 같은 table에서 컬럼 값을 가져올 때는 서브쿼리
-- 다른 table에 커럼 값을 가져올 때는 join을 쓰는 것이 좋다.
--이유 join이 서브쿼리 보다 느리기 때문(합치기 때문)

--서브쿼리를 사용할 때 domain만 같으면 된다.

--홍콩 반점 판교점 운영하는 사람의 이름, 생일
select c_name, to_char(c_birthday, 'MM')||'월'
			|| to_char(c_birthday, 'DD')||'일' as 생일 
from SEP01_CEO
where c_no =(
	select f_ceo 
	from sep01_franchise
	where f_name = '홍콩반점' and f_location = '판교'
	);
	
--'짜장'이 들어간 음식은 어디가면 먹을 수 있나요? (짜장면 파는 식당 이름, 지점명)
select f_name, f_location from sep01_franchise
where f_no in (
	select m_f_no from SEP01_MENU
	where m_name like '%짜장%'
	);
	
--좌석 수 제일 많은 식당을 운영하는 사람의 모든 정보
select * from sep01_ceo
where c_no in (
	select f_ceo 
	from SEP01_FRANCHISE
	where f_seat =(
		select max(f_seat) 
		from SEP01_FRANCHISE
		)
	);
-------------------------------------------------------------------------------
--최연소 사장님네 가게 메뉴 이름, 가격
select m_name, m_price from SEP01_MENU
where m_f_no in(
select f_no from sep01_franchise
where f_ceo in (
	select c_no from sep01_ceo
	where c_birthday =(
		select max(c_birthday)
		from SEP01_CEO
		)
	)
);
----------------------------------------------------------------------------------------------------
--테이블 여러개를 'JOIN' 시킨다.
--					:테이블 여러개를 붙여서 RAM에 잠깐 넣어놓는...!
----------------------------------------------------------------------------------------------------
--이렇게 테이블을 붙여서 사용이 가능하지만,
--테이블들이 합쳐지면서 나타낼 수 있는 모든 값들을 나타내기 때문에
-- 조건식을 사용해야 한다.
select * from SEP01_FRANCHISE, sep01_ceo;
--조건식을 사용해야 함!
select * from SEP01_FRANCHISE, sep01_ceo where f_ceo = c_no;

--전체 식당 이름, 지점명, 사장님 이름, 사장님 생일
select f_name, f_location, c_name, to_char(c_birthday, 'MM')||'월'
			|| to_char(c_birthday, 'DD')||'일' as 생일 from sep01_franchise,sep01_ceo where f_ceo = c_no;
			
--전체 메뉴명, 가격, 식당 이름, 지점명
select m_name, m_price, f_name, f_location 
from SEP01_FRANCHISE, sep01_menu 
where f_no = m_f_no;

--좌석수가 50개 이상인 식당의 메뉴명, 가격, 식당 이름, 지점명, 좌석수
select m_name, m_price, f_name, f_location, f_seat 
from sep01_menu, sep01_franchise where f_no = m_f_no
and f_seat >= 50;

--규모가 제일 큰 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수 
select m_name, m_price, f_name, f_location, f_seat 
from sep01_menu, SEP01_FRANCHISE
where m_f_no = f_no 
	and f_seat in (
	select max(f_seat) 
	from SEP01_FRANCHISE
	);

--최연장자 사장님네 전체 메뉴명, 가격, 식당이름, 지정명, 사장님이름, 생일
--		을 메뉴명 가나다순 -> 식당이름 가나다순

select m_name, m_price, f_name, f_location, c_name, to_char(c_birthday, 'MM')||'월'
			|| to_char(c_birthday, 'DD')||'일' as 생일 from SEP01_MENU,sep01_franchise,sep01_ceo
where m_f_no = f_no and f_ceo = c_no
and c_birthday =(
	select min(c_birthday) from SEP01_CEO)
order by m_name, f_name;
-----------------------------------------------------------------------------------------------------------
-- 메뉴 데이터를 개수를 나눠서 페이지로 보여주고 싶음
-- 어떻게 할까...?
-- 메뉴테이블에 m_no가 있음(Primary key)
--		Sequence로 처리했음
--			그런데 sequence는 insert에 실패해도 알아서 올라감
--		메뉴 데이터 삭제도 가능
--	=> m_no가 정확하게 1,2,3,4,...가 아님! (중간에 붕 떠버리는 값이 발생한다.)
-- 그럼 어떤 방법이 있을까?
-------------------------------------------------------------------------------------------------------------
--rownum(가상필드)***************************************
--		select할 때마다 자동으로 부여됨
--		* 랑은 같이 사용할 수 없음
--		order by보다 rownum이 먼저 부여가 된다.
--		무조건 1번부터 조회해야 함!

--메뉴 이름을 가나다 순으로 정렬해서 menu 전체 정보 조회
--select rownum, * from SEP01_MENU order by m_name;--요류 *를 사용했기 때문이다.
select rownum, m_no, m_name, m_price, m_f_no from SEP01_MENU order by m_name;

--메뉴 이름을 가나다 순으로 정렬해서 menu 테이블 rownum 1~3까지 전체 정보를 조회
--		order by보다 rownum이 먼저 부여가 된다. 그래서 rownum이 m_no와 같아져 버린거다.
--		따라서 
select rownum, m_no, m_name, m_price, m_f_no 
from SEP01_MENU 
where rownum between 1 and 3  
order by m_name;
			   				  -- 이렇게 하면 order by전에 rownum이 생성되어서
							  -- sequence를 먹인 m_no와 같게 나와버림
							  -- 우리가 의도한 바는 이름순으로 정렬을 하고
							  -- 그 다음 번호값(rownum)을 주기를 원했음



select rownum, m_no, m_name, m_price, m_f_no 
from SEP01_MENU 
order by m_name
where rownum between 1 and 3 ; -- 코드상 결과 값이 나오게 하려면 이렇게 하고 싶은데
								-- 문법오류!!!
	

select rownum, m_no, m_name, m_price --2. 그 다음에 rownum 부여
from (
	select m_no, m_name, m_price  -- 1. 이 부분을 테이블처럼 사용함
	from SEP01_MENU 			  -- (데이터 정렬 해놓고)
	order by m_name				  --Inline View라고 함(인라인 뷰)
) where rownum between 1 and 3;


select rownum, m_no, m_name, m_price
from (
	select m_no, m_name, m_price
	from SEP01_MENU
	order by m_name
) where rownum between 2 and 3; -- 무조건 1번부터 조회해야 함!

--rownum 2 ~ 4까지 메뉴테이블 정보를 메뉴명 가나다 순 정렬
-- select을 곁에 한번 더 씌워주면 안에 있는 rownum이 숫자만 부여해놓고 효력을 잃어버림
select *
 from (
 select rownum as rn, m_no, m_name, m_price
	from(
		select m_no, m_name, m_price
		from sep01_menu
		order by m_name
	)
 )
 where rn between 2 and 4;


--길동 이름을 가진 사장님네
--	메뉴명, 가격, 식당명, 지점명, 사장님이름
--	가격 내림차순 -> 메뉴명 가나다순
--	3 ~ 8번째까지 조회
select * -- *는 rownum as rn, m_name, m_price, f_name, f_location, c_name 와 같다. (어차피 커스텀 한 table 기준이므로)
from(
	select rownum as rn, m_name, m_price, f_name, f_location, c_name 
	from (
		select m_name, m_price, f_name, f_location, c_name 
		from SEP01_MENU, SEP01_FRANCHISE, sep01_ceo
		where m_f_no = f_no and f_ceo = c_no
			and c_name like '%길동'
		order by m_price desc, m_name
		)
	)
where rn between 3 and 8;

--김씨 성을 가진 사장님네 메뉴명, 가격, 사장님 이름, 사장님 성별
--가격 오름차순 정렬 => 2~3번만
select * 
	from(
		select rownum as rn, m_name, m_price, c_name, c_gender 
		from(
			select m_name, m_price, c_name, c_gender
			from sep01_menu, sep01_ceo ,SEP01_FRANCHISE
				where m_f_no = f_no and f_ceo = c_no 
					and c_name like '김%'
				order by m_price asc
			)
		)
	where rn between 2 and 3;
	
	
	
	
	
	
	
	






