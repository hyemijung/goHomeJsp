--INSERT문
--회원 테이블에 데이터를 넣는다
insert into member(
    MEMBER_NO,
    STATUS,
    AUTHORITY,
    NAME,
    ID,
    PASSWORD,
    ADRESS,
    HP,
    CRE_DATE,
    MOD_DATE
)
values(
    MEMBER_NO_SEQ.nextval,
    '1',
    '일반',
    '일지매',
    'zz',
    'zz',
    '서초구',
    '010010',
    sysdate,
    sysdate
);

--상품테이블에 데이터를 넣는다
insert into product(
    PRODUCT_NO,
    NAME,
    QUANTITY,
    PRICE,
    DETAIL,
    ORIGINAL_FILE_NAME,
    STORED_FILE_NAME,
    FILE_SIZE,
    ENROLLMENT_DATE
)
values(
    PRODUCT_NO_SEQ.nextval,
    '반팔',
    100,
    10000,
    '이것은 반팔입니다!',
    '반팔.png',
    '123456789',
    12323,
    sysdate
);

--구매목록 테이블에 데이터를 넣는다
insert into PURCHASE_LIST(
    PURCHASE_LIST_NO,
    MEMBER_NO,
    PRODUCT_NO,
    PRODUCT_SIZE,
    PURCHASE_DATE,
    REQUESTS,
    ADRESS
)
values(
    PURCHASE_NO_SEQ.nextval,
    1,
    1,
    'L',
    sysdate,
    '',
    '계양구'
);



--UPDATE문

--회원 수정하기
UPDATE MEMBER
    SET
        NAME = '지원',
        ID = 'zx',
        PASSWORD = 'zx',
        ADRESS = '계양구',
        HP = '0202',
        MOD_DATE = sysdate
WHERE member_NO = 1;

--상품 수정하기
UPDATE PRODUCT
    SET
        NAME = '긴팔',
        QUANTITY = 50,
        PRICE = 20000,
        DETAIL = '반팔이 긴팔이 되었습니다!',
        ORIGINAL_FILE_NAME = '긴팔.png',
        STORED_FILE_NAME = '45612389',
        FILE_SIZE = 12311
WHERE PRODUCT_NO = 1;

--회원 탈퇴했을 시 계정을 비활성화
UPDATE MEMBER
    SET
       AUTHORITY = 0;
WHERE member_NO = 1;

--UPDATE PRODUCT
--    SET
--       AUTHORITY = 0;
--WHERE member_NO = 1;



--DELETE문

--회원을 삭제
DELETE FROM MEMBER
WHERE MEMBER_NO = 1;

--상품 삭제
DELETE FROM PRODUCT
WHERE PRODUCT_NO = 1;

--
DELETE FROM PURCHASE_LIST
WHERE PURCHASE_LIST_NO = 1;



--SELECT문

--로그인
SELECT MEMBER_NO, AUTHORITY, NAME, ID, PASSWORD
FROM MEMBER
WHERE ID = 'zx' AND PASSWORD = 'zx'
AND STATUS = 1;

--내 정보 보기
SELECT 
    MEMBER_NO,
    NAME,
    ID,
    ADRESS,
    HP,
    CRE_DATE
FROM MEMBER
WHERE MEMBER_NO = 1;

--전체 회원 보기
SELECT 
    MEMBER_NO,
    AUTHORITY,
    NAME,
    ID,
    PASSWORD,
    ADRESS,
    HP,
    CRE_DATE,
    STATUS
FROM MEMBER
WHERE MEMBER_NO = 1;

--상품 리스트 보기
SELECT PRODUCT_NO, NAME, QUANTITY, PRICE, STORED_FILE_NAME
FROM PRODUCT;

--상품 상세보기
SELECT PRODUCT_NO, NAME, QUANTITY, PRICE, DETAIL, STORED_FILE_NAME
FROM PRODUCT
WHERE PRODUCT_NO = 1;

--나의 구매목록보기
SELECT  P.PRODUCT_NO, P.NAME, P.PRICE, 
            PL.PRODUCT_SIZE, PL.ADRESS, PL.PURCHASE_DATE,
            REQUESTS
FROM PURCHASE_LIST PL, MEMBER M, PRODUCT P
WHERE M.MEMBER_NO = PL.MEMBER_NO
AND P.PRODUCT_NO = PL.PRODUCT_NO
AND M.MEMBER_NO = 1;

--전체 구매목록(관리자 영역)
SELECT  P.PRODUCT_NO, P.NAME, P.PRICE, 
            PL.PRODUCT_SIZE, PL.ADRESS, PL.PURCHASE_DATE, PL.REQUESTS
FROM PURCHASE_LIST PL, MEMBER M, PRODUCT P
WHERE M.MEMBER_NO = PL.MEMBER_NO
AND P.PRODUCT_NO = PL.PRODUCT_NO;
