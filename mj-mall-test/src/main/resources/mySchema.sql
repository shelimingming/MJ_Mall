set database sql syntax ORA true;
set database transaction control MVCC;
set database transaction rollback on conflict true;
SET DATABASE DEFAULT ISOLATION LEVEL READ COMMITTED;

drop table if exists user;
drop table if exists student;
create table user(id int, name varchar(3), address varchar(2));
create table student(role int, name varchar(3), grade varchar(2));