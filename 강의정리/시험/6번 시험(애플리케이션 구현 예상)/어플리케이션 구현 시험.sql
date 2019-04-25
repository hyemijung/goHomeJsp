select *
from members;

delete from members;

insert into members
value(mno, email, pwd, mname, cre_date, mod_date)
values(1, 's1@test.com', '1234', '홍길동', sysdate, sysdate);

commit;


select*
from members;

UPDATE MEMBERS
    SET
        pwd = '1111',
        mname = '홍길동수정후',
        mod_date = sysdate
WHERE mno = 1;