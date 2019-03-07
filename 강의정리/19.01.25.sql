

-- 선수 테이블에서 전체 행의 수, 키 건수, 최대키,
-- 최소키,평균키(소수점 3자리에서 반올림)를 구하시오
select * from player; 

select count(*)             as "전체 행의 수",
       count(height)        as "키 건수", 
       max(height)          as 최대키,
       min(height)          as 최소키,
       round(avg(height),2) as 평균키
from player;

--테이블 구조 복사
create table emp_test
as
select ename, sal, job
from emp
where 1 = 0;  --구조만 복제하고 데이터는 비워놓는방식

select *
from emp_test;

drop table emp_test;

insert into emp_test
(
 ename
)
values(null);

select count(*), count(ename), count(sal), count(job)
from emp_test;

select rownum,emp_test.*
from emp_test;

--포지션별 최대키,최소키,평균키를 출력하시오
--포지션,인원수,키대상, 최대키,최소키,평균키
select * from player;
desc player;

select position               as 포지션,
       count(nvl(height,0))   as 키대상,
       count(height)          as 인원수,
       max(height)            as 최대키,
       min(height)            as 최소키,
       round(avg(height),2)   as 평균키
from player

group by position;
select position               as 포지션,
       count(*)               as 키대상,
       count(height)          as 인원수,
       max(height)            as 최대키,
       min(height)            as 최소키,
       round(avg(height),2)   as 평균키
from player
group by position;


--having 절

select deptno ,avg(sal)
from emp
group by deptno;

--부서별 평균 급여가 2000이상인
--부서의 부서번호와 부서별 평균 급여를 출력하시오
select deptno ,avg(sal)
from emp
group by deptno
having avg(sal) >= 2000;

select * from emp;

--부서의 최대값과 최소값을 구하되 최대 급여가 2900 이상인 부서만 출력
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900; 

--선수들테이블에서 포지션별 평균키 가 180 이상인 포지션 정보만 표시하시오
select position      as 포지션,
       avg(height)   as 평균키
from player
group by position
having avg(height) >= 180;

--K-리그 선수들중 삼성블루윙즈와 FC서울의 인원수는 얼마인가?
SELECT * FROM TEAM; --K09,K02
SELECT * FROM PLAYER;

SELECT TEAM_ID  AS 팀_ID ,
       COUNT(*) AS 인원수
FROM PLAYER
WHERE TEAM_ID = 'K02' OR TEAM_ID = 'K09'
GROUP BY TEAM_ID;


--포지션별 평균키만 출력하는데 최대키가 190CM 이상인 선수를
--가지고 있는 포지션의 정보만 조회하시오 (평균키는 소수점 3자리에서 반올림) 
SELECT POSITION             AS 포지션,
       ROUND(AVG(HEIGHT),2) AS 평균키    
FROM PLAYER
GROUP BY POSITION
HAVING MAX(HEIGHT) >= 190;

SELECT POSITION,MAX(HEIGHT)   
FROM PLAYER
WHERE HEIGHT >= 190
GROUP BY POSITION;

--ORDER BY절
--오름차순 asc 없어도됨
SELECT *
FROM EMP
ORDER BY sal asc; 

--내림차순
SELECT *
FROM EMP
ORDER BY sal desc;

--사원정보를 입사한 날짜가 가장 오래된 순서대로 출력하시오. 모든컬럼 표시(명시적으로 쓰라고하면 asc까지쓰기)
select * 
from emp
order by hiredate;

--가장 최근에 입사한 사람부터 조회가 가능하도록 sql문을 작성하시오
select *
from emp
order by hiredate desc;  --emp 테이블에서 hiredate를 내림차순 한 다음 조회하라

--emp 테이블의 자료에서 입사일을 오름차순으로 정렬하여 출력하되 사원번호, 사원명, 
--직급 입사일 컬럼을 출력하는 쿼리문을 작성하세요
select empno    as 사원번호,
       ename    as 사원명,
       job      as 직급,
       hiredate as 입사일
from emp
order by hiredate; 

--emp 테이블의 자료를 사원번호를 기준으로 내림차순으로 정렬하여 
--사원번호와 사원명 컬럼을 표시하세요(컬럼명 영어로)
select empno, ename
from emp
order by empno desc;

select * 
from emp
order by sal desc;

select * 
from emp
order by sal desc, ename asc;

--부서번호가 빠른 사원부터 출력하되 같은부서내의 사원을 출력할경우 
--최근에 입사한 사원부터 출력하되  사원번호,입사일,사원명,급여순으로 출력하시오
select empno    as 사원번호,
       hiredate as 입사일,
       ename    as 사원명,
       sal      as 급여
from emp
order by deptno, hiredate desc;

--선수테이블에서 선수들의 이름, 포지션, 백넘버를
--출력하는데 사람이름을 내림차순으로 출력하시오. 
--선수명,포지션 백넘버
select player_name as 선수명, position as 포지션, back_no as 백넘버
from player
order by player_name desc;

--키가 큰 순서대로,키가 같은 경우 백넘버 순으로 적용하시오
--단 키가 null인 데이털는 제외한다
--선수이름,포지션,백넘버,키
select player_name  as 선수이름,
       position     as 포지션,
       back_no      as 백넘버,
       height       as 키
from player
where height is not null
order by height desc, back_no;



select dept.*, deptno * 10 as newcol
from dept
order by deptno desc, dname asc, loc desc;

select dept.*, deptno * 10 as newcol
from dept
order by 1 desc, 2 asc, 3 desc;

select dept.*, deptno * 10 as newcol
from dept
order by newcol desc;

select dept.*, deptno * 0 as newcol
from dept
order by newcol desc, 1 desc;


--view
select ename, job, sal,sal * 12 yearsal
from emp;

create view EMP_BOOKS_VIEW
AS
select ename, job, sal,sal * 12 yearsal
from emp;

SELECT *
FROM EMP_BOOKS_VIEW;

DROP VIEW EMP_BOOKS_VIEW;

create view EMP_BOOKS_VIEW
AS
select ename, job, sal,sal * 12 yearsal
from emp
WHERE 1 = 0;

--사원테이블에서 입사년도, 입사일, 입사시간 입사분, 
--입사초와 같이 날짜 단위들을 VIEW로 생성하시오
SELECT * FROM EMP;

CREATE VIEW EMP_TIME_VIEW
AS
SELECT EMPNO AS 사원번호, ENAME AS 사원이름, HIREDATE AS 입사날짜,
       FLOOR((TO_DATE('2000-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS') - HIREDATE)/ 365) AS 입사년도,
       FLOOR((TO_DATE('2000-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS') - HIREDATE)) AS 입사일,
       (TO_DATE('2000-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS') - HIREDATE) * (60*60*24) AS 입사초
FROM EMP;
DROP VIEW EMP_TIME_VIEW;
SELECT * FROM EMP_TIME_VIEW;


--동등 조인
--사원의 정보와 각사원의 부서정보를 조회하시오
SELECT *
FROM EMP,DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

SELECT EMP.ENAME, DEPT.DEPTNO, DEPT.DNAME
FROM EMP,DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

SELECT *
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP'
OR TABLE_NAME = 'DEPT';

SELECT E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

--선수 테이블과 팀 테이블과 팀 테이블에서 선수이름과 소속된 팀의 이름을 출력하시오
SELECT * FROM PLAYER;
SELECT * FROM TEAM;

SELECT  P.PLAYER_NAME   AS 선수명,
        T.TEAM_NAME     AS 소속팀명
FROM PLAYER P, TEAM T
WHERE P.TEAM_ID = T.TEAM_ID;




--사원중에 SMIT라는 이름의 사원에 대해
--이름과 부서명을 출력하시오
select E.ENAME, D.DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.ENAME = 'SMITH';


--사원 중 입사일이 현재날짜 보다 작거나 같은
--사원의 이름과 부서명을 조회하시오(부서가 없는 사원은 제외)

-- 오라클 전용 SQL문
select E.ENAME, D.DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.HIREDATE <= SYSDATE;

-- ANSI STANDARD JOIN   안시 표준 조인
select E.ENAME, D.DNAME
FROM EMP E INNER JOIN DEPT D
ON  E.DEPTNO = D.DEPTNO
AND E.HIREDATE <= SYSDATE;

--조인을 사용하여 뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT E.ENAME,E.SAL
FROM EMP E INNER JOIN DEPT D
ON  E.DEPTNO = D.DEPTNO
WHERE D.LOC = 'NEW YORK';

SELECT E.ENAME,E.SAL
FROM EMP E ,DEPT D
WHERE  D.DEPTNO = E.DEPTNO
AND D.LOC = 'NEW YORK';
--ACCOUNTING 부서 소속 사원의 이름과 입사일을 SQL문으로 작성하시오
SELECT E.ENAME, E.HIREDATE
FROM EMP E,DEPT D
WHERE e.deptno = D.DEPTNO
AND D.DNAME = 'ACCOUNTING';

SELECT E.ENAME, E.HIREDATE
FROM EMP E INNER JOIN DEPT D
ON D.DEPTNO = E.DEPTNO
WHERE D.DNAME = 'ACCOUNTING';

--직급이 MANAGER 인 사원의 이름 부서명을 조회하되 사원의 이름순으로 정렬하시오
SELECT E.ENAME, D.DNAME
FROM EMP E,DEPT D
WHERE e.deptno = D.DEPTNO
AND E.JOB = 'MANAGER'
ORDER BY E.ENAME;

SELECT E.ENAME, D.DNAME
FROM EMP E INNER JOIN DEPT D
ON e.deptno = D.DEPTNO
AND E.JOB = 'MANAGER'
ORDER BY E.ENAME;

--비동등 조인
--오라클 SQL
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, D.DNAME
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO
AND SAL BETWEEN 1000 AND 3000;

--안시 표준으로 구하기
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, D.DNAME
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
WHERE E.SAL <= 3000 AND E.SAL >= 1000;

--오라클 안시 합친거
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.SAL <= 3000 AND E.SAL >= 1000;





