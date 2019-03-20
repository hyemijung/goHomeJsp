
CREATE TABLE MEMBER(
NO         NUMBER              UNIQUE NOT NULL,
NAME       VARCHAR2(40)        NOT NULL,
EMAIL       VARCHAR2(100)       PRIMARY KEY,
PWD         VARCHAR2(50)        NOT NULL,
CREDATE    DATE                NOT NULL
);
CREATE SEQUENCE MEMBER_NO_SEQ
INCREMENT BY 1
START WITH 1;

CREATE TABLE BOARD(
NO         NUMBER        NOT NULL,
TITLE       VARCHAR2(100) NOT NULL,
WRITER      VARCHAR2(50) NOT NULL, --EMAIL
CONTENT     VARCHAR2(4000) NOT NULL,
CREDATE    DATE        NOT NULL

);

CREATE SEQUENCE BOARD_NO_SEQ
INCREMENT BY 1
START WITH 1;

ALTER TABLE BOARD
ADD CONSTRAINTS BOARD_WRITER_FK FOREIGN KEY (WRITER) REFERENCES MEMBER(EMAIL);


--테이블당 데이터 1가지씩 입력해보기!
INSERT INTO MEMBER
(NO,NAME,EMAIL,PWD,CREDATE)
VALUES
(MEMBER_NO_SEQ.NEXTVAL,'정혜미','HMJ@aa.com',1111,SYSDATE);

INSERT INTO BOARD
(NO,TITLE,WRITER,CONTENT,CREDATE)
VALUES
(BOARD_NO_SEQ.NEXTVAL,'첫번째 글','HMJ@aa.com','이얏호 JLProject 게시판의 첫번째 글이다!',SYSDATE);
--오류가 나도 NEXTVAL은 올라감..ㅠㅠ

SELECT * FROM MEMBER;
SELECT * FROM BOARD;


select no, title, writer, content, credate
from board
order by no desc;

insert into member
(no, name, email, pwd, credate )
values(board_NO_SEQ.NEXTVAL, '정이랑', '이랑@naver.com', '3333', sysdate);

insert into member
(no, name, email, pwd, credate )
values(board_NO_SEQ.NEXTVAL, '박지민', '지민@naver.com', '3333', sysdate);


insert into board
(no, title, writer, content, creDate )
values(board_NO_SEQ.NEXTVAL, '잘안되네요', '이랑@naver.com', '자꾸 오류나요', sysdate);

insert into board
(no, title, writer, content, creDate )
values(board_NO_SEQ.NEXTVAL, '문의', '지민@naver.com', '수정사항 문의드려요', sysdate);


delete from board
where no = '6';


update board
set title = '관리자님 보세요', content='테스트중인데 관리자님이 도와주세요'
where writer = '지민@naver.com';


select rownum as lineNum, no, title, writer, content, credate
from board;


desc board;