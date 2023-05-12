use mysql;

create user ‘jspuser’@’localhost’ identified by ‘mysql’;
grant all privileges on jspdb.* to ‘jspuser’@’localhost’ with grant option;
flush privileges;

create database jspdb;

-- 2023-05-12
create table member(
mid varchar(20) not null,
mpw varchar(20) not null,
mname varchar(20) not null,
mphone int,
memail varchar(45) not null, 
regdate datetime default now(),
last_login datetime default null,
Primary key(mid)
);
