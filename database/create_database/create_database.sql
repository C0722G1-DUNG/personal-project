drop database if exists sprin_2;
create database  sprin_2;
use sprin_2;
create table roles (
id_role INT auto_increment primary key,
name_role varchar(45)
);
create table `account`(
id_account INT auto_increment primary key,
email varchar(45),
encrypt_password varchar(45),
name_account varchar(45),
avatar VARCHAR(500),
flag_delete boolean,
username_account varchar(45)
);
create table account_role(
account_id INT ,
role_id INT,
foreign key (account_id) references `account` (id_account),
foreign key (role_id) references roles (id_role) 
);
create table employee(
id_employee INT auto_increment primary key,
name_employee varchar(45),
gender bit(1),
id_card  varchar(45),
flag_delete boolean,
id_account INT,
foreign key (id_account) references `account` (id_account) 
);

create table category(
  id_category INT auto_increment  NOT NULL primary key,
  name_product VARCHAR(45), 
  name_category varchar(255)
  ); 
    CREATE TABLE product (
  id_product INT auto_increment NOT NULL primary key,
  name_product VARCHAR(45),
  description VARCHAR(45),
  flag_delete BIT,
  price DOUBLE,
  avatar VARCHAR(500) ,
  id_category INT,
	foreign key(id_category) references category(id_category)
 );
    CREATE TABLE warehouse (
  id_warehouse INT auto_increment NOT NULL  PRIMARY KEY,
  quantity INT,
  id_product INT,
  	foreign key(id_product) references product(id_product));
  
  CREATE TABLE  `order` (
  id_order INT auto_increment primary key,
  id_account INT,
  flag_delet BIT,
  order_date date,
  foreign key(id_account) references `account`(id_account)
);
CREATE TABLE purchase_history (
  id_product INT,
  id_order INT,
  quantity INT,
  foreign key(id_product) references product(id_product),
  foreign key(id_order) references `order`(id_order)

);
CREATE TABLE payment (
  id_pay INT auto_increment primary key,
  id_order INT,
  payment_method VARCHAR(45),
  foreign key(id_order) references `order`(id_order)
);