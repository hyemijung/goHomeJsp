select *
from members;

insert into members
(mno, email, pwd, mname, cre_date, mod_date)
values(MEMBERS_MNO_SEQ.nextval, 's3@test.com', '3333', '일지매', sysdate, sysdate);

rollback;