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
("admin1", "123", "Nguyen Van A", 1),
("user1", "123", "Tran Van B", 2);