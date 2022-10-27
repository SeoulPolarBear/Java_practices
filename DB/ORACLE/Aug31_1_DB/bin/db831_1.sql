--웹사이트에서 게시판에 대한 테이블과 이를 [참조하는] 게시판 댓글 테이블을 만드려고 함
--게시판 테이블에는 [작성자 / 게시판 글 내용 / 작성 시간]에 대한 부분이 있었으면
--댓글 테이블에는 [작성자 / 댓글 내용 / 작성 시간]에 대한 부분이 있었으면

-- 1. 테이블의 구조를 파악해서 게시판 테이블 만들기
create table notice_board(
n_b_code number(4) primary key,
n_b_author varchar2(10 char) not null,
n_b_content varchar2(500 char) not null,
n_b_time date not null
);

-- 2. 테이블의 구조를 파악해서 댓글 테이블 만들기
-- [조건 : 참조 되는 테이블의 내용이 삭제되면 관련 있는 댓글 내용도 삭제]
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
--3. 각각의 테이블에 값을 2개씩 넣기 / 댓글은 각각 2개씩
--[Date 관련해서 넣을 값은 현재 날짜 / 시간으로 통일]
insert into NOTICE_BOARD values(12, '감성팔이 개구리', '오늘 좋은 하루 되세요', to_date(sysdate,'YYYY-MM-DD HH24:MI'));
insert into NOTICE_BOARD values(NOTICE_BOARD_SEQ.nextval, '기다리는 기린', '오늘 기분 좋을려면 어떻해야 할까요?', to_date(sysdate,'YYYY-MM-DD HH24:MI'));
ALTER TABLE NOTICE_BOARD MODIFY  n_b_author varchar2(20 char);
insert into NOTICE_BOARD values(13, '비와서 우울한 고양이', '오늘 날씨가 흐려서 슬프네요', to_date(sysdate,'YYYY-MM-DD HH24:MI'));

ALTER TABLE board_comment MODIFY b_c_author varchar2(20 char);
insert into board_comment values(22, '채식주의자 호랑이', '오늘도 감자먹고 힘내야겠어요 오늘도 화이팅', to_date(sysdate,'YYYY-MM-DD HH24:MI'),12);
insert into board_comment values(32, '얄팍한 오랑우탄', '슬프면 저랑 파전에 막걸리 어때요?', to_date(sysdate,'YYYY-MM-DD HH24:MI'),13);
insert into board_comment values(BOARD_SEQ.nextval, '함박웃음 개죽이', '오늘 하루 기분 좋으려면 웃으면 됩니다.', to_date(sysdate,'YYYY-MM-DD HH24:MI'),1);

insert into board_comment values(BOARD_SEQ.nextval, '육식주의자 사자', '오늘도 삼겹살먹고 화이팅', to_date(sysdate,'YYYY-MM-DD HH24:MI'),12);
insert into board_comment values(BOARD_SEQ.nextval, '노가다 킹콩', '아오 노가다 하러가야하는데 비라니...', to_date(sysdate,'YYYY-MM-DD HH24:MI'),13);
insert into board_comment values(BOARD_SEQ.nextval, '순찰중인 미어켓', '오늘 하루 기분 좋으려면 동료들과 잘 지내면 됩니다.', to_date(sysdate,'YYYY-MM-DD HH24:MI'),1);

SELECT * FROM NOTICE_BOARD INNER JOIN BOARD_COMMENT 
ON NOTICE_BOARD.N_B_CODE = BOARD_COMMENT.b_c_n_b_code
order by N_B_CODE asc;

SELECT BOARD_COMMENT.b_c_author FROM NOTICE_BOARD INNER JOIN BOARD_COMMENT 
ON NOTICE_BOARD.N_B_CODE = BOARD_COMMENT.b_c_n_b_code where n_b_author = '감성팔이 개구리'
order by N_B_CODE asc;

--게시글 1번을 지웠을 때 댓글들도 지워지는지 확인
delete from NOTICE_BOARD where n_b_code = 1;

