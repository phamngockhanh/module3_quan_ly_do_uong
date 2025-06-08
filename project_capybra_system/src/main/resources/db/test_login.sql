create database login_database;

use  login_database;

create table roles (
	id int primary key auto_increment,
    name varchar(50)
);

create table accounts (
	id int primary key auto_increment,
    username varchar(50) unicode,
    password varchar(255),
    name varchar(50),
    role_id int,
    foreign key(role_id) references roles(id)
);

insert into roles (name)
values ("admin"), ("user");

insert into accounts (username, password, name, role_id)
values
("admin1", "$2a$12$Zhv6F3F83Y.lyQy6Rz8D6.L7fISmclam4eor.5rF/VzRDEqH8hHNS", "Nguyen Van A", 1),
("user1", "$2a$12$fTLH7nQ309P/XOYLeWckruGRGJpQMFHdwS/po47bgvjZVbpIE121K", "Tran Van B", 2);