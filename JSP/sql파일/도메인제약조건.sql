--권한 

select *
from emp;


-- 백업
create table emp07
as 
select *
from emp;

select *
from user_constraints
where table_name = 'EMP07';

select *
from emp07;

delete from emp07;

commit;

-- 도메인을 거는 방식을 배워보자! (현재 데이터가 없는 상태)
-- 도메인 제약조건
-- 조회해서 제약조건 등을 확인한다
desc emp07; 


insert into emp07
values(1,'박성욱','강사', null, sysdate, 800, 100, 055);

insert into emp07
values(2,'유관순','학생2', null, sysdate, 500, 0, 055);

rollback;

commit;

-- 테이블에서 제약조건을 작성하는 방식
create table emp07
    auth varchar2(200) constraint ass chec(auth in('Y', '2'))
);


-- 제약조건을 테이블을 생성하고 난후, alter table로 추가하는것이 더 편리하다

--ddl
--제약조건 (월급의 범위는 500에서 5000 까지만 가능하도록)
-- 숫자는 비교연산자를 사용하면 된다.
alter table emp07
add constraint emp07_sal_ck
check(sal between 500 and 5000);


-- 직업을 강제한다(조건을 걸자)
-- 문자열은 
-- 강사랑 학생만 가능하도록
alter table emp07
add constraint emp07_job_ck
check(job in ('강사', '학생'));


