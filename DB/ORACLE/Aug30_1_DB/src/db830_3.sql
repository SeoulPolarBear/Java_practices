----------------------------<������ ���� �Լ�>------------------------------------------------
--1. ���� �Լ�
--		-ABS(����) : ���밪 ���									ex)ABS(-4.5)
select ABS(-4.5) as abs from dual;
--		-POWER(����, n) : ������ n����								ex)POWER(2,3)
select POWER(12,3) as power from dual;
--		-ROUND(����, m) : ���ڸ� m�� �ݿø� ���� �ڸ��� 			ex)ROUND(5.36, 1)
select ROUND(5.36,1) as round from dual; -- 5.4
select ROUND(-5.36,1) as round from dual; -- ����
select ROUND(5.36,-1) as round from dual;-- 10
select ROUND(-5.36,-1) as round from dual;-- ����
--		-TRUNC(����, m) : ������ m��° �ڸ����� ����� ���� ����	ex)TRUNC(123.456,2)
select TRUNC(-4.5, 1) as abs from dual;
--																	ex)TRUNC(123.456,-1)
select ABS(-4.5) as abs from dual;
--																	ex)TRUNC(123.456,0)
select ABS(-4.5) as abs from dual;
--		-MOD(m, n) : ���� m�� n���� ���� ������						ex)MOD(12, 10)
select ABS(-4.5) as abs from dual;
--		-SQRT(����) : ������ ������ ���� ��� (���ڴ� ���!)		ex)SQRT(9.0)
select ABS(-4.5) as abs from dual;


--2. ���� �Լ�
--			-CONCAT(s1,s2)			: �� ���ڿ��� ����																ex) CONCAT('ABCD', 'EFG')
--			-SUBSTR(s1, n, k) 		: ���ڿ��� n��°���� k��ŭ�� ���̸� ��ȯ										ex) SUBSTR('ABCDEFG', 3, 4)
--			-INSTR(s1, s2, n, k)	: s1�� n��°���� �����ؼ� ã�����ϴ� s2�� k��° ��Ÿ���� ���ڿ��� ��ġ�� ��ȯ	ex) INSTR('Hello', 'l', 1, 2)
--			-LPAD(s, n, c) 			: ���ڿ� s�� ���ʺ��� ������ �ڸ� �� n���� ������ ���� c�� ä��					ex) LPAD('ABC', 5, '*')
--			-RPAD(s, n, c) 			: ���ڿ� s�� �����ʺ��� ������ �ڸ� �� n���� ������ ���� c�� ä��				ex) RPAD('ABC', 5, '*')
--			-LTRIM(s1, s2) 			: ���ڿ� s1 �������� ���ʿ� �ִ� ������ ���� s2 ����							ex) LTRIM('****ABC', '*')
--			-RTRIM(s1,s2) 			: ���ڿ� s1 �������� �����ʿ� �ִ� ������ ���� s2 ����							ex) RTRIM('ABC****', '*')
--			-REPLACE(s1, s2, s3)	: s1�� ������ ���� s2�� ���� s3�� ����											ex) REPLACE('michael jackson', 'mi', 'ki')
--			-LENGTH(s1) 			: ���ڼ��� �����ִ� �Լ�														ex) LENGTH('����')
--			-LENGTHB(s1) 			: ������ �뷮(����Ʈ)�� �����ִ� �Լ�											ex) LENGTHB('����')



--3. ��¥ / �ð� �Լ�
--	[��¥����]
--		YYYY : 4�ڸ� ����
--		YYY, YY, Y : ���� 4�ڸ� ������ ������ 3,2,1 �ڸ�
--		MM : ��
--		DD : 1�� �� ��¥(����)
--		DAY : ����(������ ~ �Ͽ���)
--		DY : ���� ����(�� ~ ��)
--		HH, HH12 : 12�ð� / AM or PM : ���� or ����
--		HH24 : 24�ð�
--		MI : ��
--		SS : ��


--		- SYSDATE : ���� ��¥ / �ð��� ��ȯ
--		- TO_DATE(s1, datetime����) : ������ �����͸� ��¥������ ��ȯ
select to_date('2022-09-01 ���� 06:00', 'YYYY-MM-DD PM HH:MI') FROM DUAL;

--		- TO_CHAR(date, datetime����) : ��¥�� �����͸� ���������� ��ȯ
select to_char(sysdate, 'YYYY-MM-DD') FROM DUAL;
-- Ư�� ��¥ ���� �޾ƿ��� �ʹٸ� sysdate�ڸ��� to_date�Լ��� �־ ����� ��!
-- 	=> ��ȯ�Ǵ� ������ Ÿ���� �ٸ���.

--TO_DATE�� ��¥�� / TO_CHAR�� ������ ��ȯ
--		-ADD_MONTHS(date, ����) : ��¥���� ������ �޸�ŭ ����(1 : ������, -1 : ������)
select add_months(sysdate, -3) from dual;

--		-LAST_DAY(date) : �� ���� ������ ���� ��ȯ
select last_day(sysdate) from dual;

--���� ��¥ ���� ���� ��ȸ(���̺� ����� '����' / �÷��� '2022��' �̶�� ������ )
select concat(to_char(sysdate,'YYYY'),'��') as ���� from dual;
-- ���� ��¥ ���� �� ��ȸ (���̺� ����� '��' / �÷��� '08��' �̶�� ������)
select to_char(sysdate,'MM')||'��' as �� from dual;
-- ���� ��¥ ���� �� ��ȸ (���̺� ����� '��' / �÷��� '30��' �̶�� ������)
select to_char(sysdate,'DD')||'��' as �� from dual;
-- ���� ��¥ ���� ��/�� ��ȸ(���̺� ����� ���� '��', '��' / �÷��� ���� '?��' '?��' �̶�� ������)
select to_char(sysdate, 'HH24')||'��' as ��, concat(to_char(sysdate,'MI'),'��') as �� from dual;
-- ������ �������� �������� ��ȸ
select to_char(sysdate, 'PM') "����/����" from dual;
-- ���ڿ� 2022-09-09 ���� 07:23�� 2022.09.09�� ��ȸ
select to_char(to_date('2022-09-09 ���� 07:23','YYYY-MM-DD PM HH:MI'),'YYYY.MM.DD') FROM DUAL;
-- ���� ��¥ ���� 3�� �� ������ ���� ��� ��ĥ���� ��ȸ
SELECT to_char(LAST_DAY(ADD_MONTHS(sysdate, -3)),'MM')||'��' as "3���� ������ ��", to_char(LAST_DAY(ADD_MONTHS(sysdate, -3)),'DD')||'��' as "3���� ������ ��" from dual;


--4. ���� / �м��Լ� - select �÷��� ���̳�, having ������ ���!
--	-AVG(�÷���) : ���
--	-COUNT(�÷���) : �˻��Ǵ� ������ ��
--	-MAX(�÷���) : �ִ밪
--	-MIN(�÷���) : �ּҰ�
--	-SUM(�÷���) : ����
--	-RANK : �ߺ� ������ŭ ���� ���� ���� ��Ŵ (1 2 2 2 5 ...)
--	-DENSE_RANK : �ߺ� ������ �����ص� ���������� ���� ���� ���� ǥ���� (1 2 2 2 3 ...)

--5.  NULL ���� �Լ�
-- ���� �������ǿ� NOT NULL�� ������ �����͸� �Է��ϰ� �س��µ�
-- NULL : ��Ȯ�� ���̳� ���� ������� �ʴ� �� / 0�̳� ����ִ� ������ �ƴ�!

--		-NVL�Լ� : NULL�� ��츸 ������ ������ ��ġ�ϴ� �Լ�
--		NVL(��, NULL�϶� ��ü ��)
SELECT NVL(NULL, 'B') FROM DUAL;
SELECT NVL('A','B') FROM DUAL;

--		-NVL2�Լ� : NULL�� ���ο� ���� ������ ������ ��ġ�ϴ� �Լ�
--		NVL2(��, ���� ���� �� ��ü ��, NULL�϶� ��ü��)
SELECT NVL2(NULL, 'A', 'B') FROM DUAL;
SELECT NVL2('C', 'A', 'B') FROM DUAL;



----------------------------�ߺ� ���� �� select------------------------------------------------

----------------------------�ߺ� ���� �� select------------------------------------------------

----------------------------�ߺ� ���� �� select------------------------------------------------

----------------------------�ߺ� ���� �� select------------------------------------------------

----------------------------�ߺ� ���� �� select------------------------------------------------

----------------------------�ߺ� ���� �� select------------------------------------------------


