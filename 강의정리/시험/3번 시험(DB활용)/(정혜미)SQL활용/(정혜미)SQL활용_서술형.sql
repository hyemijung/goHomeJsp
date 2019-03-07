--서술형 1.1번
create table emp
(
        emp_no              number(8),
        emp_name         varchar2(10) not null,
        emp_hdate        date default sysdate,
        emp_mgr_no      number(8)
);


alter table emp
add constraint emp_emp_no_pk primary key(emp_no);


alter table emp
add constraint emp_empmgrno_emp_empno_fk 
        foreign key(emp_mgr_no) references emp(emp_no);



--서술형  1.2 번

select deptno                       as 부서
        , sum(sal)                      as 급여총액
        , round(avg(sal),2)      as 평균급여액
from emp
where deptno is not null 
group by deptno
having round(avg(sal),2) >= 2000;



--서술형 1.4번

desc 테이블명;

select *
from user_constraints;



--서술형 2.2번

create view emp_reward_view
as 
select empno, ename, job, hiredate, sal
        , (sal*0.1)*  (to_date('2019-01-01','yyyy-mm-dd') - hiredate)/365 "reward_sal" 
from emp;