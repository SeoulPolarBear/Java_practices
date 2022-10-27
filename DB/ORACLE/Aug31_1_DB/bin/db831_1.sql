--������Ʈ���� �Խ��ǿ� ���� ���̺�� �̸� [�����ϴ�] �Խ��� ��� ���̺��� ������� ��
--�Խ��� ���̺��� [�ۼ��� / �Խ��� �� ���� / �ۼ� �ð�]�� ���� �κ��� �־�����
--��� ���̺��� [�ۼ��� / ��� ���� / �ۼ� �ð�]�� ���� �κ��� �־�����

-- 1. ���̺��� ������ �ľ��ؼ� �Խ��� ���̺� �����
create table notice_board(
n_b_code number(4) primary key,
n_b_author varchar2(10 char) not null,
n_b_content varchar2(500 char) not null,
n_b_time date not null
);

-- 2. ���̺��� ������ �ľ��ؼ� ��� ���̺� �����
-- [���� : ���� �Ǵ� ���̺��� ������ �����Ǹ� ���� �ִ� ��� ���뵵 ����]
create table board_comment(
b_c_code number(4) primary key,
b_c_author varchar2(10 char) not null,
b_c_content varchar2(500 char) not null,
b_c_time date not null,
b_c_n_b_code number(4) not null,
constraint FK_comment foreign key(b_c_n_b_code)
references notice_board(n_b_code) on delete cascade
);
CREATE SEQUENCE BOARD_SEQ;
CREATE SEQUENCE NOTICE_BOARD_SEQ;
--3. ������ ���̺� ���� 2���� �ֱ� / ����� ���� 2����
--[Date �����ؼ� ���� ���� ���� ��¥ / �ð����� ����]
insert into NOTICE_BOARD values(12, '�������� ������', '���� ���� �Ϸ� �Ǽ���', to_date(sysdate,'YYYY-MM-DD HH24:MI'));
insert into NOTICE_BOARD values(NOTICE_BOARD_SEQ.nextval, '��ٸ��� �⸰', '���� ��� �������� ��ؾ� �ұ��?', to_date(sysdate,'YYYY-MM-DD HH24:MI'));
ALTER TABLE NOTICE_BOARD MODIFY  n_b_author varchar2(20 char);
insert into NOTICE_BOARD values(13, '��ͼ� ����� �����', '���� ������ ����� �����׿�', to_date(sysdate,'YYYY-MM-DD HH24:MI'));

ALTER TABLE board_comment MODIFY b_c_author varchar2(20 char);
insert into board_comment values(22, 'ä�������� ȣ����', '���õ� ���ڸ԰� �����߰ھ�� ���õ� ȭ����', to_date(sysdate,'YYYY-MM-DD HH24:MI'),12);
insert into board_comment values(32, '������ ������ź', '������ ���� ������ ���ɸ� ���?', to_date(sysdate,'YYYY-MM-DD HH24:MI'),13);
insert into board_comment values(BOARD_SEQ.nextval, '�Թڿ��� ������', '���� �Ϸ� ��� �������� ������ �˴ϴ�.', to_date(sysdate,'YYYY-MM-DD HH24:MI'),1);

insert into board_comment values(BOARD_SEQ.nextval, '���������� ����', '���õ� ����԰� ȭ����', to_date(sysdate,'YYYY-MM-DD HH24:MI'),12);
insert into board_comment values(BOARD_SEQ.nextval, '�밡�� ŷ��', '�ƿ� �밡�� �Ϸ������ϴµ� ����...', to_date(sysdate,'YYYY-MM-DD HH24:MI'),13);
insert into board_comment values(BOARD_SEQ.nextval, '�������� �̾���', '���� �Ϸ� ��� �������� ������ �� ������ �˴ϴ�.', to_date(sysdate,'YYYY-MM-DD HH24:MI'),1);

SELECT * FROM NOTICE_BOARD INNER JOIN BOARD_COMMENT 
ON NOTICE_BOARD.N_B_CODE = BOARD_COMMENT.b_c_n_b_code
order by N_B_CODE asc;

SELECT BOARD_COMMENT.b_c_author FROM NOTICE_BOARD INNER JOIN BOARD_COMMENT 
ON NOTICE_BOARD.N_B_CODE = BOARD_COMMENT.b_c_n_b_code where n_b_author = '�������� ������'
order by N_B_CODE asc;

--�Խñ� 1���� ������ �� ��۵鵵 ���������� Ȯ��
delete from NOTICE_BOARD where n_b_code = 1;

