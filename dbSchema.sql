drop database `applicationDB`;
create database `applicationDB`;
use `applicationDB`;

create table userInfo( 
	UserID int not null auto_increment,
	FirstName varchar(255) not null,
    LastName varchar(255) not null,
    Gender enum('F','M') not null,
    Birthdate date not null,
    primary key (UserID)
);
create table address(
	ID int not null auto_increment,
    WorkAddress varchar(255),
    HomeAddress varchar(255),
    primary key (ID)
); 
                           
select * from userInfo;
select * from address;                        
                            
                            
                            
                            
                            