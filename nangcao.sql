use master

GO

IF exists (select name from sysdatabases where name='lab')
drop Database lab

GO

Create Database lab

GO

use lab
Go

IF OBJECT_ID('Forums') IS NOT NULL
DROP TABLE Forums

GO

CREATE TABLE Forums(
	Id		    int         NOT NULL  PRIMARY KEY,
	Name   nvarchar(50) NOT NULL,
	Decription  nvarchar(50) NOT NULL   	
	)

GO
 

 insert into Forums values (1 , N'Linh' , N'Nguyễn Khánh Linh')
 insert into Forums values (2 , N'Ngân' , N'Hoàng Dỗ Anh Ngân')
 insert into Forums values (3 , N'Nga' , N'Nguyễn Phi Nga')
 insert into Forums values (4 , N'Khánh' , N'Lê Ngân Khánh')
 insert into Forums values (5 , N'Kim' , N'Thuyên Kim')
 insert into Forums values (6 , N'Anh' , N'Nhật Kim Anh')
 
 Go
 
IF OBJECT_ID('Login') IS NOT NULL
DROP TABLE Login

GO

CREATE TABLE Login(
	Id   nvarchar(50) NOT NULL PRIMARY KEY,
	Passwords  nvarchar(50) NOT NULL   	
	)

GO
 
insert into Login values ('admin','admin')
 
	  
