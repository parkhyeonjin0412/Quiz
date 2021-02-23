create table newst(
id varchar2(20),
name varchar2(20),
age number,
primary key(id)
);
insert into newst values('111','Hong',23);
insert into newst values('222','Kim',20);
insert into newst values('333','Go',30);
commit;
select * from newst;

create table quiz_member(
account_id varchar(20) primary key,
name varchar(20),
addr varchar(20)
);





