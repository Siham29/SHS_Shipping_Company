drop database shs_shipping_company;
create database shs_shipping_company;
use shs_shipping_company;

create table Customers (
Cid int primary key not null,c_Phone_num varchar(20),
 c_Name varchar(20) ,C_Address varchar(20) ,
 c_Email varchar(20) 
);
drop table customers;

select * from customers;


CREATE TABLE Employees (
   eid int primary key not null, phone_num varchar(20), address_name varchar(20),
  TypeE varchar(32) DEFAULT NULL 
);

select * from employees;



CREATE TABLE service(
  sid int primary key  NOT NULL,
 cid int , eid int , 
  foreign key(eid ) references Employees(eid),
 foreign key (cid)references Customers(cid)
);
select * from  orders;

drop table service;


CREATE TABLE orders (
    oid INT PRIMARY KEY NOT NULL,
    sid INT,
    vnumber int,
    price REAL,
    shipping_time varchar(20),
    shipping_date varchar(20),
    shipping_info VARCHAR(200) ,
    FOREIGN KEY (sid) REFERENCES service (sid),
    foreign key (vnumber)references Vehicle(vnumber));

   drop table orders;

  select* from orders;
  
  
CREATE TABLE Vehicle (
  Vnumber int NOT NULL,eid int not null ,
  Vtype varchar(20),
  PRIMARY KEY (Vnumber),
  foreign key (Eid)references Employees(Eid)
 
);
drop table vehicle;


select * from Vehicle;



