create database quan_ly_ban_do_uong;

use quan_ly_ban_do_uong;

create table roles (
	id int primary key auto_increment,
    name nvarchar(50)
);

create table accounts (
	id int primary key auto_increment,
    username nvarchar(30) unique,
    password nvarchar(255),
    role_id int,
    token nvarchar(50),
    status boolean,
    foreign key(role_id) references roles(id)
);

create table order_status (
	id int primary key auto_increment,
    name nvarchar(50)
);

create table categories (
	id int primary key auto_increment,
    name nvarchar(50)
);

create table users (
	id int primary key auto_increment,
    name nvarchar(50),
    account_id int unique,
    phone nvarchar(11),
    address nvarchar(50),
    email nvarchar(50),
    status boolean,
    foreign key(account_id) references accounts(id)
);

create table carts (
	id int primary key auto_increment,
    order_date datetime,
    user_id int unique,
    status boolean,
    foreign key(user_id) references users(id)
);

create table orders (
	id int primary key auto_increment,
    user_id int,
    order_date datetime,
    order_status_id int,
    foreign key(user_id) references users(id),
    foreign key(order_status_id) references order_status(id)
);

create table products (
	id int primary key auto_increment,
    name nvarchar(50),
    price bigint,
    category_id int,
    status boolean,
    description text,
    image nvarchar(255),
    size varchar(10),
    foreign key(category_id) references categories(id)
);

create table topping(
	id int primary key auto_increment,
    name nvarchar(50),
    price bigint,
    status boolean
);

create table product_topping(
	id int primary key auto_increment,
	product_id int,
    topping_id int,
    unique (product_id, topping_id),
    foreign key (product_id) references products(id),
    foreign key (topping_id) references topping(id) 
);

create table order_details (
	id int primary key auto_increment,
	order_id int,
    product_id int,
    quantity int,
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id),
    unique (order_id, product_id)
);

create table cart_details (
	id int primary key auto_increment,
	cart_id int,
    product_id int,
    quantity int,
    foreign key (cart_id) references carts(id),
    foreign key (product_id) references products(id),
    unique (cart_id, product_id)
);


delimiter //
	create trigger add_cart_after_create_user
    after insert on users
    for each row
    begin
		insert into carts (user_id, status)
        values (NEW.id, true);
    end;
//
delimiter ;


insert into roles (name)
values
 ("user"), ("admin");
 
 insert into accounts (username, password, role_id, status)
 values
 ("user1", "$2a$12$Zhv6F3F83Y.lyQy6Rz8D6.L7fISmclam4eor.5rF/VzRDEqH8hHNS", 1, 1),
  ("admin2", "$2a$12$fTLH7nQ309P/XOYLeWckruGRGJpQMFHdwS/po47bgvjZVbpIE121K", 2, 1);
  
  insert into users (name, account_id, phone, address, email, status)
 values
 ("Nguyễn Đức Vĩnh", 1, "0987654321", "Quảng Bình", "vinh@gmail.com", 1),
 ("Phan Ngọc Hoàng", 2, "0123456788", "Huế", "hoang@gmail.com", 1);

-- insert into carts (user_id ,order_date, status)
-- values
-- (1, '2022-12-30', 1),
-- (2, '2024-06-10', 1);
 
 insert into categories (name)
 values
 ("Cafe"),
 ("Nước ép"),
 ("Nước ngọt"),
 ("Sinh tố");
 
 insert into products (name, price, category_id, status, description, image, size)
 values
 ("Cafe đen", 12000, 1, 1, "", "",""),
 ("Cafe sữa", 15000, 1, 1, "", "",""),
 ("Nước ép cam", 15000, 2, 1, "", "",""),
 ("Nước ép bưởi", 17000, 2, 1, "", "",""),
 ("Sinh tố bơ", 25000, 4, 1, "", "",""),
 ("Nước mía", 10000, 2, 1, "", "",""),
 ("Coca cola", 13000, 3, 1, "", "","");
 
 
 
 