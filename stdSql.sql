create database students_db;

use students_db;

CREATE TABLE Persons (
    ID int primary key auto_increment,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);

-- drop table Persons;

INSERT INTO Persons (LastName, FirstName, Address, City)
VALUES 
	('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger'),
    ('Dinh', 'Hung Tuan', 'TP Bac Giang', 'Bac Giang'),
    ('Dinh', 'Uyen Thu', 'TP Bac Giang', 'Bac Giang');
    
CREATE TABLE Class (
    IdClass int primary key auto_increment,
    Name varchar(255),
    Room varchar(255)
);

alter table Persons add column IdClass int, add constraint FK_Persons_IdClass foreign key (IdClass) references Class(IdClass);

alter table Persons add column IdSubject int, add constraint FK_Persons_IdSubject foreign key (IdSubject) references Subjects(IdSubject);

CREATE TABLE Subjects (
    IdSubject int primary key auto_increment,
    Name varchar(255),
    IdPerson int,
    constraint FK_Subjects_IdPerson foreign key (IdPerson) references Persons(ID)
);

-- alter table Persons drop column IdClass;