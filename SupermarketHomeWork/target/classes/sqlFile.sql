SET GLOBAL  time_zone = '+3:00';

CREATE DATABASE IF NOT EXISTS SUPERMARKET;

USE SUPERMARKET;

CREATE TABLE IF NOT EXISTS User(
     id int not null auto_increment,
     userType  ENUM ('BUYER', 'SalesRepresentative', 'OWNER'),
     balance  float,
     primary key(id)
);

CREATE TABLE Product(
    id int not null auto_increment,
    productName varchar(100) not null,
    price double not null,
    quantity double not null,
    primary key(id)
);
USE SUPERMARKET;
CREATE TABLE  IF NOT EXISTS Sale (
  productId int ,
   total double ,
   quantity int 

);
USE SUPERMARKET;
CREATE TABLE  IF NOT EXISTS shoppingCart (
  productId int

     );
     
 drop   TABLE  shoppingCart;
 USE SUPERMARKET;
 
 USE SUPERMARKET;
CREATE TABLE  IF NOT EXISTS shoppingCart (
  productId int,
  quantity int,
  productName varchar(100)
      );
      