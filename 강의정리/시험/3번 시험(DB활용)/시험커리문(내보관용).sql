--서술형  1.2 번

select deptno                       as 부서
        , sum(sal)                      as 급여총액
        , round(avg(sal),2)      as 평균급여액
from emp
where deptno is not null 
group by deptno
having round(avg(sal),2) >= 2000;







--사원 테이블에서 각 사원의 부서명을 조회하시오.
--- 아래 결과를 분석하여 동일하게 출력하시오
--- 사원, 부서 테이블 조인 시 부서가 없는 사원은 출력 안함
--- 오라클 JOIN, ANSI JOIN 둘 다 SQL문을 작성하시오
--- 데이터를 부서명, 사원명으로 오름차순하시오

--(분석)
--사원 테이블에는 부서명은 없고 부서 번호만 있다 - 조인해야함
-- 부서없는 사원 출력안한다 -> 조건 deptno in not null
-- 오름차순 asc

--오라클 조인
select    d.dname, e.empno, e.ename 
from       emp e , dept d
where     e.deptno = d.deptno
and         e.deptno is not null
order by d.dname asc, e.ename asc; 



-- 안시 조인
select    d.dname, e.empno, e.ename 
from       emp e inner join dept d
on           e.deptno = d.deptno
where     e.deptno is not null
order by d.dname asc, e.ename asc; 




create view emp_reward_view
as 
select empno, ename, job, hiredate, sal
        , (sal*0.1)*  (to_date('2019-01-01','yyyy-mm-dd') - hiredate)/365 "reward_sal" 
from emp;




--사원 테이블에서 각 사원에 급여(SAL)가 높은 순서대로 상위 5명을 조회하시오.
--- 사원의 모든 정보 표시
--- 급여순위 컬럼에 급여의 크기에 따른 순위표시
--- 급여가 높은 순으로 사원을 정렬

--(분석)
-- 급여가 높은순으로 상위 5명을 조회하시오 -> rownum <= 5 사용
-- 급여크기에 따른 순위표시 - 급여순위 컬럼을  새롭게 생성하고 순위표시 어떻게 할것인가?
-- 순위를 매기기위한 함수를 찾아라!
-- 급여 높은순으로 사원정렬 ->  order by sal desc;
dept number -> ( null) 문자처리 -> to_char

RANK()       OVER ( ORDER BY SAL DESC ) RANK;

--급여 순위는 가상 컬럼!!!!!!! 돌겟네
select   ROW_NUMBER() OVER (ORDER BY SAL DESC)  as 급여순위, emp.*
from emp
where nvl(to_char(deptno), '(null)')
and rownum <= 5
order by sal desc;

select *
from emp;


select  rank(  ) over(orderby sal desc)  as 급여순위,
        , empno , ename, job, mgr, hiredate, sal, comm, deptno
from emp
where rownum <= 5
order by sal desc;



insert into emp
    select

