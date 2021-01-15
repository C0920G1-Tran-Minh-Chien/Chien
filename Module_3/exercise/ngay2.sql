drop database if exists exercise;
create database exercise;
use exercise;

create table categories(
	id int primary key ,
    `name` varchar(50),
    `description` varchar(50)
);

create table customers(
	id int primary key,
	firts_name varchar(50),
    last_name varchar(50),
    phone_number varchar(50),
    address varchar(50),
    email varchar(50),
    birthday date
);

create table employees(
	id int primary key,
	firts_name varchar(50),
    last_name varchar(50),
    phone_number varchar(50),
    address varchar(50),
    email varchar(50),
    birthday date
);

create table suppliers(
	id int primary key,
    name varchar(50),
    email varchar(50),
    phone_number varchar(50),
    address varchar(50)
);

create table products(
	id int primary key,
    `name` varchar(50),
    umage_url varchar(50),
    price int,
    discount int,
    stock int,
    category_id int,
    supplier_id int,
    `description` varchar(50),
    foreign key (category_id) references categories(id),
    foreign key (supplier_id) references suppliers(id)
);

create table orders(
	id int primary key,
    create_date datetime,
    shipped_date datetime,
    `status` varchar(50),
    `description` varchar(50),
    shipping_address varchar(50),
    shipping_city varchar(50),
    payment_type varchar(50),
    customer_id int,
    employee_id int,
    foreign key (customer_id) references customers(id),
    foreign key (employee_id) references employees(id)
);

create table order_details(
	id int primary key,
    order_id int,
    product_id int,
    quantity int,
	foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
 );