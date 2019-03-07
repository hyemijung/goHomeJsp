create table members(
    mno number not null,
    email varchar2(40) not null,
    pwd VARCHAR(100) not null,
    mname VARCHAR(50) not null,
    cre_date date not null,
    mod_date date not null
);
    
    
alter table members
add CONSTRAINT members_mno_pk PRIMARY KEY (mno);


alter table members
add CONSTRAINT members_email_uk unique (email);

create sequence members_mno_seq
increment by 1
start with 1;

drop sequence members_mno_seq;

desc members;

insert into members
(mno, email, pwd, mname, cre_date, mod_date)
values(MEMBERS_MNO_SEQ.nextval, 's1@test.com', '1111'
, '홍길동', sysdate, sysdate);

insert into members
(mno, email, pwd, mname, cre_date, mod_date)
values(MEMBERS_MNO_SEQ.nextval, 's2@test.com', '2222'
, '임꺽정', sysdate, sysdate);


-- insert 하는 이유는?
-- 


rollback;

select*
from members;

commit;



select mno, mname, cre_date
from members
order by mno asc;

