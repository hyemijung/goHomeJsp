select *
from members;

insert into members
(mno, email, pwd, mname, cre_date, mod_date)
values(MEMBERS_MNO_SEQ.nextval, 's3@test.com', '3333', '일지매', sysdate, sysdate);

rollback;

select *
from members
where email = 'aaa@aaa';

desc members;

-- 한글이라 깨진 데이터를 지워준다
delete
from members
where pwd = '3333';

commit;


update members
set email = 'emailChange', mname = '이름변경', mod_date = sysdate
where mno = 7;



select mno, email, mname, cre_date
from members
where mno=1;

delete from members
where mno = 1;

select count(*)
from members;


desc members;


select *
from members;


insert into members
(mno, email, pwd, mname, cre_date, mod_date)
values(members_mno_seq.nextval, 's3@test.com', '3333', '김구', sysdate, sysdate); 

rollback;


