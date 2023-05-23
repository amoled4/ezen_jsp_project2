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


-- 2023-05-16
create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(20) not null,
regdate datetime default now(),
content text,
readcount int default 0,
Primary key(bno));

create table comment(
cno int not null auto_increment,
bno int default 0,
writer varchar(100) default “unknown”,
content varchar(1000) not null,
regdate datetime default now(),
primary key(cno));