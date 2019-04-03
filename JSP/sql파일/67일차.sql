-- 존재하지않는 회원 조회

SELECT MNAME, EMAIL 
FROM MEMBERS 
WHERE EMAIL = 's1@fdaf' AND PWD = '1111'; 

select *
from members;

insert into members
(mno, email, pwd, mname, cre_date, mod_date)
values(MEMEBERS_MNO_SEQ.nextval, '사용자입력@com', 'pwd사용자입력',
        '사용자 입력 이름', sysdate, sysdate);

select MEMEBERS_MNO_SEQ.currval from dual;

drop sequence MEMEBERS_MNO_SEQ;

create sequence MEMEBERS_MNO_SEQ
start with 57
increment by 1;

commit;

select sysdate
from dual;

-- 기본키랑 첫번째 생각대상!
select mno, mname, email, cre_date
from members
where mno = 1;

-- 수정

update members
set mname = '블랙펄',
    email = new@com,  
    pwd = 'dd';
where mno = 9;