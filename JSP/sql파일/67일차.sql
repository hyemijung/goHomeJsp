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
    email = 'ㅁㅇ@',  
    pwd = 'dd',
    mod_date = sysdate
where mno = 55;

rollback;

delete from members
where mno= 14;


select count(*)
from members;

-- 페이징 적용을 위한 작업

select mno, mname, email, cre_date
from(
    select rownum rnum, m.mno, m.mname, m.email, m.cre_date
    from(
            SELECT MNO, MNAME, EMAIL, CRE_DATE
            FROM MEMBERS
            ORDER BY mno DESC) M
)members
where rnum between 1 and 10;

-- 서브 쿼리 - 인라인 뷰(가상의 뷰)

-- 1번: 전체 조회
SELECT MNO, MNAME, EMAIL, CRE_DATE
FROM MEMBERS;

-- 인라인 뷰(가상의 뷰) - 무조건 알아야되는 기술!!!!!
-- 동적테이블 생성기술 (필요할때 생성해서 사용하는 것)
-- 어떤테이블이든 가로 열고 닫고하면 가상테이블이되어 활용 가능하다
SELECT MNO, MNAME, EMAIL, CRE_DATE
FROM (
    select 1 as MNO, '홍길동' MNAME, '이건 내가 만든 가상의 테이블이야@' EMAIL, sysdate AS CRE_DATE
    from dual
);






-- 1과 2 사이 조회는 되는데 3과 4 사이는 안된다 -> 1을 벗어나면 조회되지않음!!
-- (1이라는 개념이 들어가지않으면 rawnum은 사용하지못하게 해두었다
-- 그래서 이를 해결하기위해 유동적인 컬럼을 고정시켜야한다
 SELECT rownum, MNO, MNAME, EMAIL, CRE_DATE
 FROM MEMBERS
 where rownum between 3 and 4
 ORDER BY mno DESC;


-- 위의 단점을 보완하려면?
-- 인라인 뷰로 만드는 순서를 보라
-- 정렬한 결과를 사용하겠다 DESC -> 정렬한 결과를 괄호 밖에서 사용이 가능하다 
-- 이것만 사용가능(rownum rnum, RRR, m.mno, m.mname, m.email, m.cre_date)
select rownum rnum, m.mno, m.mname, m.email, m.cre_date
    from(
         SELECT MNO, MNAME, EMAIL, CRE_DATE
         FROM MEMBERS
        ORDER BY mno DESC
)m

WHERE RNUM BETWEEN 2 AND 4;
-- 위를 실행하면 ROWNUM 이라 1부터 시작한 사이를 조회하는것이 아니므로 오류가난다
-- 이를 해결하려면 아래처럼 해라!



-- ROWNUM을 사용하기 위해선 한번더 테이블 안에 넣어서 인라인뷰로 만들고- 별칭도 설정해줘야한다(테이블명도)

select mno, mname, email, cre_date
from(
    select rownum rnum, m.mno, m.mname, m.email, m.cre_date
    from(
         SELECT MNO, MNAME, EMAIL, CRE_DATE
         FROM MEMBERS
        ORDER BY mno DESC
    ) m
) MEMBER
WHERE RNUM BETWEEN 1 AND 4;
--WHERE ROWNUM BETWEEN 3 AND 4;
-- 위와 같이 ROWNUM 이라고 적으면 조회 불가 -> 왜냐면 가상의 컬럼을 가르치기 때문이다(ROWNUM의 특징)
-- ROWNUM의 특징: 그냥 가상의 컬럼으로 순서대로만 나열하자 
--(애초에 이것을 가공할 생각이없었음, 근데 행에 대한 컬럼을 따로만들지 않고 로우넘을 사용하는게 너무 좋았음
-- 따라서 로우넘의 약점을 보완하고자 인라뷰안에 넣어서 사용하니 로우넘을 원하는대로 가공해서 보는것이 가능했다)