
select       d.dname, e.empno, e.ename 
from          emp e , dept d
where        e.deptno = d.deptno
and            e.deptno is not null
order by    d.dname asc, e.ename asc; 




select       d.dname, e.empno, e.ename 
from          emp e inner join dept d
on              e.deptno = d.deptno
where        e.deptno is not null
order by    d.dname asc, e.ename asc; 





select   ROW_NUMBER() OVER (ORDER BY SAL DESC)  as 급여순위, emp.*
from emp
where nvl((to_char(deptno), '000000'), '(null)')
and rownum <= 5
order by sal desc;



