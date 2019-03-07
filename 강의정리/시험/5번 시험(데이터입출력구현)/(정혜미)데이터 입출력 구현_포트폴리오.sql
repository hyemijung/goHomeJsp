


-- 조인하자 ( 팀 <-> 스타디움 <-> 스케쥴 )
select  std.stadium_name
        , sch.sche_date         
        , t.team_name             AS HOMETEAM_NAME
        , sch.home_score       AS HOMETEAM_SCORE
        , t.team_name             AS AWAYTEAM_NAME
        , sch.away_score        AS AWAYTEAM_SCORE
from team t, stadium std, schedule sch 
where t.stadium_id=std.stadium_id
and std.stadium_id=sch.stadium_id
and sch.home_score is not null                                --홈팀점수와 (값이 없는 경기는 제외한다)                
and sch.away_score is not null                                --상대팀점수 둘 중 값이 없는 경기는 제외한다
order by sch_date desc, stadium_name asc;           --경기일정이 최근에 일어난 순서 및 경기장명을 사전순으로 정렬하시오





--팀 아이디로 팀 네임을 알수있다 -> 홈팀네임과  어웨이팀네임도 결국은 팀 아이디로 알수있다
-- 조인한 결과에서 홈팀네임과 상대팀네임을 어떻게 보여줄것인가?
-- 홈팀아이디 = 팀 아이디, 상대팀아이디 = 팀 아이디 ?
select team_name
from team
where team_id;




-- 날짜 형식 업데이트
update schedule
set sche_date = to_date('20120904', 'yyyy년mm월dd일');
where sche_date = '20120904';


-- 날짜는 문자열이었다 -> date타입으로 변환해야한다 ->
select to_char(to_date(sche_date, 'yyyymmdd'), 'yyyy"년"mm"월"dd"일") schedate,
from schedule;

-- 또는 두번째방법




-- 강사님 정답코드

SELECT  DOM.STADIUM_NAME STADIUM_NAME, TO_CHAR(TO_DATE(S.SCHE_DATE, 'YYYYMMDD'), 'YYYY"년"MM"월"DD"일"') SCHE_DATE, 
            HT.TEAM_NAME HOMETEAM_NAME, S.HOME_SCORE HOMETEAM_SCORE, 
            AT.TEAM_NAME AWAYTEAM_NAME, S.AWAY_SCORE AWAYTEAM_SCORE
    FROM    TEAM HT, SCHEDULE S, TEAM AT, STADIUM DOM
    WHERE   HT.TEAM_ID = S.HOMETEAM_ID
    AND     AT.TEAM_ID = S.AWAYTEAM_ID
    AND     DOM.STADIUM_ID = S.STADIUM_ID
    AND    (S.HOME_SCORE IS NOT NULL
    OR      S.AWAY_SCORE IS NOT NULL)
    ORDER BY S.SCHE_DATE DESC, DOM.STADIUM_NAME;


-- 프로시저
 P_SEL_K_LEAGUE_SCHE('부산아시아드경기장', '20120904', V_STADIUM_NAME, V_SCHE_DATE, 
    V_HOMETEAM_NAME, V_HOMETEAM_SCORE, V_AWAYTEAM_NAME, V_AWAYTEAM_SCORE);