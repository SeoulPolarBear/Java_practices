--R(Read)
select [distinct] [컬럼명], [컬럼명 as 별칭 || 컬럼명 별칭], [연산자 사용], [통계함수],...
from [테이블명]
where [조건식]
group by [조건식]
having [함수 포함 조건]
order by [정렬대상 ASC/DESC(오름차순 / 내림차순)] --기본값은 오름차순

-- where절 (조건식)
-- 전체 데이터 중 지정한 조건에 맞는 데이터를 찾아주는 문장
-- 조건식에 사용할 연산자를 알아보자(비교 연산자)
-- =, !=, ^=, <>, >, <, >=, <=,...
--이 중에서 2,3, 4번째는 '같지 않다'로 쓰이는 연산자인데... 왜 3개나 될까...?
--2번과 4번의 경우에는 각각 표준화를 하려다 보니 사용하게 되었고, 
--3번의 경우에는 몇몇 DBMS과 차별화를 두기 위해서 사용하게 되었음

--가격이 3000원인 과자의 모든 정보를 조회
select * from snack where s_price = 3000;

--어제 만든 과자 table 사용
select * from snack;

--모든 과자 이름, 가격 조회
select s_name, s_price from snack;

--모든 과자 이름(가격) 조회 (ex : 콘칩(2000원))
select s_name||'('||s_price||'원'||')' as "이름(가격)" from snack;
select concat(s_name||'(',concat(s_price,'원')||')') as "이름(가격)" from snack;
--숫자여도 concat이 됩니다. 
--특수문자가 들어가게 될 경우 ""사용해야 한다.

--2000원 이하의 과자 중 최소 가격이 얼마인지
select min(s_price) as 최소가격 from snack where s_price <= 2000;

--모든 과자의 평균가
select round(avg(s_price),-1) as 평균가 from snack;

--과자의 이름과 가격의 30% 할인된 금액
select s_name, s_price*0.7 as "30%할인가격" from snack;

--3500원인 과자의 개수는 몇개?
select count(s_code) "3500원 과자" from snack where s_price = 3500;

--3000원 이하인 과자의 이름, 회사 이름
select s_company, s_name from snack where s_price <= 3000 order by s_company asc;
-------------------------------------------------------------------------------------
--모든 과자 이름, 가격, 유통기한 조회
select s_name,s_price, s_exp from snack;

--모든 과자 이름, 가격, 부가세 조회(가격의 10%)
select s_name, s_price, s_price * 0.1 as VAT from snack;

--모든 과자 이름, 가격, 판매가 조회 (20%할인)
select s_name, s_price, s_price * 0.8 as "판매가(20%할인)" from snack;

--3000원보다 큰 금액의 과자들의 평균가 조회
select avg(s_price) from snack where s_price >= 3000;

--최고가, 최저가, 총 과자 종류 몇 가지인지 조회
select max(s_price) 최고가, min(s_price) 최저가, count(*) 총과자 from snack;

--3000원 이상인 과자의 전체 정보 조회
select * from snack where s_price >= 3000;

--3000원 미만인 과자의 이름, 가격, 판매가 조회(20% 할인)
select s_name, s_price, s_price * 0.8 as "판매가(20%할인)" from snack where s_price < 3000;

--프링글스의 가격 조회
select s_price from snack where s_name = '프링글스';

--크라운 회사의 가격 총합
select sum(s_price) as 총합 from snack where s_company = '크라운';

--2022년도 12월 안으로 먹어야 하는 과자 이름, 가격, 유통기한 조회
select s_name, s_price, s_exp from snack 
where s_exp < to_date('2022-10-01 00:00:00', 'YYYY-MM-DD HH24:MI:ss');
where to_char(s_exp,'YYYY') = '2022' and to_char(s_exp,'MM') <= '12';
---------------------------------------------------------------------------------------------------------
--관계 연산자
--NOT, AND, OR, BETWEEN, IN
--먼저 AND와 BETWEEN
--가격이 1000원 이상 3000원 이하인 과자의 전체 내용 조회
--AND를 이용해서
select * from snack where s_price >= 1000 and s_price <= 3000;
--BETWEEN를 이용해
select * from snack where s_price between 1000 and 3000;
-- between이 더 빠르다 이유 : between은 이상/이하로 조건 범위를 정하기 때문에 
-- 1000원 초과 3000원 미만인 과잘르 조회할 때는 between 사용이 애매...
-- 조건1 and 조건2 는 조건1을 돌고 나서 조건2를 도는 반면 between은 조건을 한번에 처리한다. 

--가격이 1000원,2000원,3000원인 과자의 전체 정보를 조회!
--OR연산자
select * from snack where s_price = 1000 or s_price = 2000 or s_price = 3000;
--IN를 이용해서
select * from snack where s_price in (1000,2000,3000);
--연속되지 않는 값들을 받아오고 싶을 때 => IN을 사용

--그럼 이 결과에 반대되는 결과 값을 받아오고 싶다면?
select * from snack where s_price NOT in (1000,2000,3000);

------------------------------------------------------------------------------------------------------------
--패턴 연산자
--문자열을 포함하는 검색을 할 때 사용 : like '패턴'의 형태
-- 이 때 패턴에는 '%'를 넣는데 '단어 0개 이상' 뭐가 들어갈지 모른다는 뜻!
-- like '%ㅋ' : ㅋ로 끝나는 거
-- like 'ㅋ%' : ㅋ로 시작하는 거
-- like '%ㅋ%' : ㅋ로 포함

-- like '_ㅋ%' : 2번째 문자가 ㅋ인 거
-- like '%ㅋ_' : 뒤에서 2번째가 ㅋ인거
-- like '_ㅋ' : 2글자인데 ㅋ이 마지막 글자
-- like '_ㅋ' : 2글자인데 ㅋ이 첫번째 글자

--'해'가 들어가는 회사에서 만든 과자의 이름 조회
select s_name from snack where s_company like '%해%';

--'이'가 들어가는 과자들 평균가 조회
select round(avg(s_price),-1) from snack where s_name like '%이%';

--크라운 과자거나, 새우깡~ 인거 이름, 제조사, 가격 조회
select s_name, s_company, s_price from snack where s_company = '크라운' or s_name like '%새우깡%';

--과자의 이름이 '새콤달콤'을 포함하거나 '치토스'를 포함하는 과자의 이름, 제조사, 가격 조회
select s_name, s_company, s_price from snack where s_name like '%새콤달콤%' or s_name like '%치토스%';

-- like in을 같이 쓰는 구조는 아예 없다.
select s_name, s_company, s_price from snack where s_name like in ('%새콤달콤%', '%치토스%');--(x)
--대신 비슷한게 존재한다.
--REGEXP_LIKE(컬럼명, 패턴1|패턴2|...)
--여러개의 패턴을 찾고 싶다면 |(파이프)를 넣어서 패턴을 추가하면 됨
--정규식(regex)을 이용해서 문자를 찾는 방법인데...

-- 패턴 앞에 ^를 넣으면 : 패턴값으로 시작하는 문자열 찾기
-- 패턴 뒤에 $를 넣으면 : 패턴값으로 끝나는 문자열 찾기

--과자의 이름이 '새콤달콤'을 포함하거나 '이'로 끝나는 과자의 이름, 제조사, 가격 조회
select s_name, s_company, s_price from snack where REGEXP_LIKE(s_name, '*새콤달콤*|이$');
select s_name, s_company, s_price from snack where REGEXP_LIKE(s_name, '^새콤달콤|이$');

------------------------------------------------------------------------------------------------------------------------------------------
--집합 연산자
--합집합
--UNION : 중복되는 값을 제외하고 출력
select 1 id, '수학' subject, 90 score from dual
	union
select 2 id, '국어' subject, 70 score from dual
	union
select 1 id, '수학' subject, 90 score from dual;
--UNION ALL : 중복되더라도 모두 출력

select 1 id, '수학' subject, 90 score from dual
	union all
select 2 id, '국어' subject, 70 score from dual
	union all
select 1 id, '수학' subject, 90 score from dual;

--교집합
--INTERSECT : 두 테이블의 집합 중 공통되는 값 출력
select 1 id, '수학' subject, 90 score from dual
	union
select 2 id, '국어' subject, 70 score from dual
	intersect
select 1 id, '수학' subject, 90 score from dual;

--차집합
--MINUS : 첫 번째 select문 중에서 두번째 select문에 없는 값을 출력
select 1 id, '수학' subject, 90 score from dual
	union
select 2 id, '수학' subject, 70 score from dual
	minus
select 2 id, '국어' subject, 70 score from dual
	MINUS
select 1 id, '수학' subject, 90 score from dual;


--과자 데이터 중에서 회사가 크라운이고 가격이 1000원 이하이거나 3000원 이상인 과자 전체정보조회
--연산자 우선순위 (오른쪽이 최우선순위)
-- OR > AND > NOT > 비교연산자 > 괄호

select * from snack where s_company = '크라운' and (s_price <=1000 or s_price >= 3000);
select * from snack where s_company = '크라운' and s_price not between 999 and 2999;

-------------------------------------------------------------------------------------------------------------
--Group by : 그룹으로 묶어 연산해서 하나의 결과를 나타내는 것
--회사별 과자 평균 가격, 최소 가격, 최고 가격
--group by 하기 전에 최고가, 최저가, 평균가 구했을 때 => 단일 값으로 출력
--이번에는 회사별로 그룹을 지어서 값을 나타냄
select s_company, avg(s_price), min(s_price), max(s_price) from snack group by s_company;

--Rollup 연산자
--group by rollup [그룹 대상]
--컬럼에 대한 소계(subtotal)을 만들어 줌
--group by 절의 컬럼 개수가 n개라면, rollup을 썼을 때는 n+1개
--회사 이름, 회사별 과자 총 가격 합계와 모든 과자들의 가격 합계
select s_company, sum(s_price) from snack group by rollup(s_company);

--NULL에 대한 값을 뭔가로 나오게 하고 싶으면 DECODE 함수를 사용
--DECODE(컬럼명, 조건, 조건에 맞는 결과값, 조건에 맞지 않을 때 결과값)
--s_company가 null이면 '전체', 그게 아니면 s_company 값
select Decode(s_company,null,'전체',s_company), sum(s_price) from snack group by rollup(s_company);

select NVL2(s_company,s_company,'전체'), sum(s_price) from snack group by rollup(s_company);

--decode 사용시 : 조건 자리에는 비교 연산자 (x), 산술 연산자 (o)
-----------------------------------------------------------------------------------------------------------
--Having : Group by절에 의해 생성된 결과 중 원하는 조건에 부합하는 자료만 찾고자 할 때 사용
--Having과 Where 모두 조건을 이용해서 원하는 조건에 맞는 데이터만 산출한다는 공통점이 있는데
--Having : 그룹의 결과를 제한
--		vs
--where : 조건을 사용해서 결과를 제한

--where이 having 보다 무조건 위에 있어야 한다.
--즉, 그룹 짓고 나서의 조건은 having을 사용한다.


--회사별 과자 평균 가격이 2000원 이상인 회사의 이름과 과자 평균 가격을 조회
select s_company, avg(s_price) from snack group by s_company having avg(s_price) >= 2000;


--ORDER by : 정렬! 기본값은 오름차순 ASC이며, 내림차순 정렬은 DESC
--where +group by + having by + order by 
--롯데 또는 해태 회사의 과자 평균 가격이 1800원 이상일 때 각 회사의 평균 가격 내림차순 정렬

select s_company, avg(s_price) from snack 
where s_company in ('오리온','롯데','해태')
group by s_company
having avg(s_price) >= 1800
order by avg(s_price);





















