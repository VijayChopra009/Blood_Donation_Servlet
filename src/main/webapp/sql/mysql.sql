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

ALTER TABLE employees
ADD hire_date DATE NOT NULL;

create table donor(email varchar(255),password varchar(255));