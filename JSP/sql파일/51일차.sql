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