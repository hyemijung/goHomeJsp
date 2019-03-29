select mno, mname, email, cre_date
from members
order by cre_date desc;

-- crud

desc members;

select *
from members
order by mno desc;

-- 제대로 조회된다는 사실을 검증
select *
from members
where email = 's1@test.com'
and pwd = '1111';

-- 사용자가 보고자하는 정보(지켜야하는 정보와 보여줘야할 정보를 구분한다)
select mname, email
from members
where email = 's1@test.com'
and pwd = '1111';

-- 잘못되면 안된다는 사실을 검증
select *
from members
where email = '1'
and pwd = '1111';