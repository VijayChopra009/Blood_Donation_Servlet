/////////////// donor table//////////////////
CREATE TABLE donorDetails (
    FirstName VARCHAR2(50),
    LastName VARCHAR2(50),
    Email VARCHAR2(100),
    Password VARCHAR2(50),
    MobNo VARCHAR2(15),
    Gender VARCHAR2(10),
    Age NUMBER,
    BloodGroup VARCHAR2(5),
    City VARCHAR2(50),
    Address VARCHAR2(255),
    State VARCHAR2(50)
);

create table donor(email varchar(255),password varchar(255));
///////////////////hospital tables////////////////////////////
CREATE TABLE hospitalregister (
id int,
    name VARCHAR2(100),
    email VARCHAR2(100) PRIMARY KEY,
    password VARCHAR2(100),
    mobno VARCHAR2(15) UNIQUE,
    state VARCHAR2(100),
    city VARCHAR2(100),
    pincode VARCHAR2(10),
    address VARCHAR2(255)
);

CREATE TABLE hospitallogin (
    ID NUMBER,
    Email VARCHAR2(255) ,
    Password VARCHAR2(255) ,
    A_Positive NUMBER DEFAULT 0,
    A_Negative NUMBER DEFAULT 0,
    B_Positive NUMBER DEFAULT 0,
    B_Negative NUMBER DEFAULT 0,
    AB_Positive NUMBER DEFAULT 0,
    AB_Negative NUMBER DEFAULT 0,
    O_Positive NUMBER DEFAULT 0,
    O_Negative NUMBER DEFAULT 0
);

///// ngo table////////
select * from ngocamp;
