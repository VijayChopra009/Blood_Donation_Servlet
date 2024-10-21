
///////////////////////////////// mysql database changes///////////////////////////////
---------------------donor tables-----------------------
create table donor(
email varchar(150) unique not null,
password varchar(100) 
)



create table donordetails(
id int auto_increment unique not null,
firstname varchar(50) not null,
lastname varchar(50) not null,
email varchar(150) not null unique,
password varchar(150),
mobno varchar(100) not null unique,
gender varchar(50),
age int,
bloodgroup varchar(30),
city varchar(50),
address varchar(255),
state varchar(50),
pincode varchar(50),
live_loc varchar(255)
);


-------------------- hospital tables ----------------------------
create table hospitalregister(
id int auto_increment not null unique,
name varchar(150)  not null unique,
email varchar(150) not null unique,
password varchar(100) ,
mobno varchar(50) unique not null,
state varchar(100),
city varchar(100),
pincode varchar(30),
address varchar(255)
);

create table hospitallogin(
id int,
email varchar(150) unique not null,
password varchar(100),
A_POSITIVE int,
A_NEGATIVE int,
B_POSITIVE int,
B_NEGATIVE int,
AB_POSITIVE int,
AB_NEGATIVE int,
O_POSITIVE int,
O_NEGATIVE int,
name varchar(150)
);

----------------------ngo camp table-------------------

create table ngocamp(
camp_date varchar(100),
address varchar(255),
	city varchar(100),
    pincode varchar(40),
    state varchar(50),
    contact varchar(50),
    details varchar(255)


);
