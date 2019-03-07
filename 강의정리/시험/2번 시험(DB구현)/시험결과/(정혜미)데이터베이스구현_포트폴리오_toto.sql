create table student
(
   stu_seq  number primary key, 
   name     VARCHAR2(50) not null,
   email      VARCHAR2(100) not null,
   address  varchar2(200),
   reg_date date not null
);

create sequence student_student_seq
    start with 1
    increment by 1;
    


create table subject
(
    subject_code    number primary key,
    subject_name    varchar2(20) not null,
    capacity          number(3) not null default(0),
    open_date        date not null
);



create sequence subject_subject_seq
    start with 1
    increment by 1;
    
    


create table education_log
(
    stu_seq             number not null,
    subject_code     number not null,
    lect_start_date    date primary key,
    lect_end_date     date,
    score                number(5,2)
);





ALTER TABLE education_log                                                  
ADD  FOREIGN KEY(stu_seq) REFERENCES student(stu_seq);

ALTER TABLE education_log                                                  
ADD CONSTRAINT subject_code FOREIGN KEY(subject_code) REFERENCES subject(subject_code);

