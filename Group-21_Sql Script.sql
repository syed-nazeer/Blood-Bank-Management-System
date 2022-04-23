CREATE TABLE ADMINSTRATIONLOGIN
                (
                 ID CHAR(5) NOT NULL,
                 PASSWORD VARCHAR(20),
                 PRIMARY KEY (ID),
                 CONSTRAINT CHECK_AID CHECK (ID LIKE 'A%')
                 );
CREATE TABLE ADMINSTRATORDATA
                 (
                  ID CHAR(5) NOT NULL,
                  NAME VARCHAR(30) NOT NULL,
                  POSITION VARCHAR(30) NOT NULL,
                  MOBILENO VARCHAR(20) NOT NULL,
                  MAIL VARCHAR(50) NOT NULL,
                  primary key(ID),
                  FOREIGN KEY(ID) REFERENCES ADMINSTRATIONLOGIN(ID)
                  );
CREATE TABLE  BEMPLOYLOGIN
				(
                ID CHAR(5) NOT NULL,
                PASSWORD VARCHAR(120) NOT NULL,
                PRIMARY KEY(ID),
                CONSTRAINT CHECK_BID CHECK(ID LIKE'B%')
                );
CREATE TABLE EMPLOYDATA
                (
                ID CHAR(5) NOT NULL unique,
                BID CHAR(5) NOT NULL,
                NAME VARCHAR(30) NOT NULL,
                MOBILENO VARCHAR(15) NOT NULL,
                MAIL VARCHAR(50) NOT NULL,
                CITY VARCHAR(30) NOT NULL,
                PRIMARY KEY(BID)
                );
CREATE TABLE  BLOODDATA
                (
                 BID CHAR(5) NOT NULL,
                 ABPOSITIVE INT,
                 ABNEGATIVE INT,
                 BPOSITIVE INT,
                 BENEGATIVE INT,
                 OPOSITIVE INT,
                 ONEGATIVE INT,
                 HH INT,
                 PRIMARY KEY(BID),
  				 FOREIGN KEY(BID) REFERENCES EMPLOYDATA(BID)
                 );
CREATE TABLE BLODDDONORDATA
                (
                BID CHAR(5) NOT NULL,
                BDID CHAR(6) NOT NULL,
                NAME VARCHAR(30) NOT NULL,
                BGrp VARCHAR(15) NOT NULL,
                AGE INT NOT NULL,
                ADDRESS VARCHAR(50) NOT NULL,
                MOBILE VARCHAR(15) NOT NULL,
                GENDER CHAR(1),
                LDD DATE ,  #LDD DENOTES LAST DONATED DATE
                LDD1 DATE,
                ldd2 date,
                PRIMARY KEY(BDID),
                FOREIGN KEY(BID) REFERENCES EMPLOYDATA(BID),
                CONSTRAINT CHECK_GENDER CHECK (GENDER IN('M','F'))
                );
CREATE TABLE DONORLOGIN
                (
                  ID CHAR(9) NOT NULL,
                  PASSWORD VARCHAR(20) NOT NULL,
                  PRIMARY KEY(ID),
                  CONSTRAINT CHECK_DID CHECK(ID LIKE'D%')
				);
CREATE TABLE DONORDATA
                (
                  ID CHAR(9) NOT NULL,
                  BID CHAR(5) NOT NULL,
                 NAME VARCHAR(20) NOT NULL,
                 Bgrp VARCHAR(15) NOT NULL,
                 AGE INT NOT NULL,
				 ADDRESS VARCHAR(50) NOT NULL,
                 MOBILE VARCHAR(15) NOT NULL,
                 LDD DATE NOT NULL,
                 JDD DATE NOT NULL,
                 feed int NOT NULL,
                STATUS VARCHAR(3) NOT NULL,
                 PRIMARY KEY(ID),
                 FOREIGN Key(ID) references Donorlogin(ID),
                 FOREIGN KEY(BID) REFERENCES EMPLOYDATA(BID),
                 CONSTRAINT CHECK_STATUS CHECK (STATUS IN ('YES','NO'))
                 );
CREATE TABLE PATIENTLOGIN
                (
                ID CHAR(9) NOT NULL,
                PASSWORD VARCHAR(20) NOT NULL,
				PRIMARY KEY(ID),
                CONSTRAINT CHECK_PID CHECK(ID LIKE 'P%')
                );
CREATE TABLE PATIENTDATA
               (
               ID CHAR(9) NOT NULL,
               NAME VARCHAR(30) NOT NULL,
               AGE INT,
               BID CHAR(5) NOT NULL,
               Bgrp VARCHAR(15) NOT NULL,
               ADDRESS VARCHAR(50) NOT NULL,
               MOBILENO VARCHAR(20) NOT NULL,
               JDD Date not null,
               Feed int,
               PRIMARY KEY(ID),
               FOREIGN KEY(ID) REFERENCES PATIENTLOGIN(ID)
               );
               create table feedback (
Q1 int,
Q2 int,
Q3 int,
Q4 int,
Q5 int,
Q6 int,
Q7 int,
Q8 varchar(150)  
);
insert into adminstrationlogin values ("Asunn","sunny0");
insert into adminstratordata values ("Asunn","chakri","manager","707515","chakri@");
insert into bemploylogin values("Bbunn","Sunny@123");
insert into employdata values("Bbunn","12312","chakri","707515","2019510@","ongole");
insert into blooddata values("12312",2,5,4,6,2,3,5); 
insert into blodddonordata values("12312","123","sunny","ABpositive",15,"Flat 405","8688377",'M','2008-11-11','2008-11-11','2008-11-11');
ALTER TABLE adminstratordata
ADD CONSTRAINT myUniqueConstraint UNIQUE(mail, mobileno);
ALTER TABLE employdata
ADD CONSTRAINT myUniqueConstraint UNIQUE(mail, mobileno);
ALTER TABLE blodddonordata
ADD CONSTRAINT myUniqueConstraint UNIQUE(address, mobile);
ALTER TABLE blooddata
ADD CHECK (ABpositive>=0 AND ABnegative>=0 and Bpositive>=0 AND Benegative>=0 and opositive>=0 AND onegative>=0 and HH >=0);
SELECT ID,BID,NAME,mobileno,mail,CITY
FROM employdata;
CREATE VIEW bdonor AS
SELECT BID,BDID,BGrp,Name,AGE,ADDRESS,MOBILE,GENDER,LDD
FROM blodddonordata;
Insert into adminstrationlogin values
("Assun",'sunnypapa'),
('Ahone','honry@'),
('Achak','ch@kri'),
('Asiva','siva123');
insert into adminstratordata values
('Ahone','harsha','manager','9876548667','harsha@mail.com'),
('Achak','chakradhar','chairman','6895447864','chakram@gmail.com'),
('Asiva','sivasai','teammanager','9866897646','sivasai@gmail.com');
insert into bemploylogin values
('Braj',md5('rajesh321@')),
('Bvars','54314@'),
('Byash','yash@890'),
('Bamar','amar@123'),
('Bvino','vinod@'),
('Bven','venky321'),
('Bhars','harshahari'),
('Bswap','swapna@78'),
('Bbhar','bharathi21');
insert into blodddonordata values
('10002','103','sharif','Bnegative',24,'7-115 vinayak nagar','8888883333','M','2008-12-11','2008-12-11','2008-12-11'),
('10004','104','Anuskha','Opositive',20,'1-18 Ramalayam street','7888899992','F','2021-01-11','2021-01-11','2021-01-11'),
('10006','105','Pavan','Anegative',21,'112-3a Amalapuram street','988988987','M','2008-07-08','2008-07-08','2008-07-08'),
('10007','107','Mahesh','ABnegative',27,'178-7-68q Aryan street','7979798989','M','2021-03-08','2021-03-08','2021-03-08');
insert into employdata values
('Bvars','10001','varshith','898654679','varshi123@gmail.com','Delhi'),
('Braj','10002','rajesh','9876087659','rajesh@email.com','hyderabad'),
('Byash','10003','yashwitha','7389276390','yashu@gmail.com','chittoor'),
('Bama','10004','amarnath','62975389','amarnath@gmail.com','Tirupati'),
('Bvin','10005','vinod kumar','9853789730','vinod@gmail.com','ooty'),
('Bvenk','10006','venkatesh','278397638','venky@gmail.com','amritsar'),
('Bhars','10007','harsha vardhan','8972789000','harsha@gmail.com','banglore'),
('Bswap','10008','swapna priya','9377999999','swapna@gmail.com','hyderabad'),
('Bbhar','10009','bharathi','8888889999','bharathi@gmail.com','ooty');
insert into blooddata values
('10001',3,2,6,4,2,4,1),
('10002',6,2,4,1,4,2,1),
('10003',3,2,2,6,2,1,3),
('10004',6,1,3,2,4,1,3),
('10005',2,4,6,1,3,4,1),
('10006',5,2,1,4,1,6,2),
('10007',4,1,4,3,2,5,2),
('10008',5,2,1,4,5,6,2),
('10009',1,3,5,3,2,6,2);
insert into blodddonordata values
("10001","111","sunny","ABpositive",'19',"Flat 405","868839977",'M','2008-11-11','2008-11-11','2008-11-11');
insert into blodddonordata values
('10004','104','Anuskha','Opositive','21','1-18 Ramalayam street','7888899992','F','2021-01-11','2021-01-11','2021-01-11'),
('10006','105','Pavan','Anegative','21','112-3a Amalapuram street','988988987','M','2008-07-08','2008-07-08','2008-07-08'),
('10007','107','Mahesh','ABnegative','27','178-7-68q Aryan street','7979798989','M','2021-03-08','2021-03-08','2021-03-08'),
('10008','108','Rashmika','Apositive','19','Flat 126a SBI colony','979787876','F','2021-02-18','2021-02-18','2021-02-18'),
('10009','109','Chitti','ABnegative','23','Flat 12b RRR street','8000080000','F','2021-03-18','2021-03-18','2021-03-18'),
('10010','110','salman','Opositive','29','17a-28-2  smart colon','900090009','M','2008-09-08','2020-09-08','2020-09-08');
insert into bemploylogin values
('Barun',md5('raje'));
select * from bemploylogin;
create view Bloodemploy as
(select *
 from employdata);
grant select on bloodemploy to EMPLOYDATA;
  create view admindata as
  (select *
  from ADMINSTRATORDATA);
  grant select on adminstratordata to EMPLOYDATA;
create view donordeatils as
(select * from blodddonordata);
  grant select on donordetails to donor;
  Delete from blodddonordata where BID='10001';
  select * from blodddonordata;
  Delete from employdata where ID='Byash';
  Update adminstratordata set Mail="dvfvdvdvd" where ID='Asunn';
  SELECT COUNT(*)  FROM adminstratordata;
  select * from blooddata order by BID;
  insert into blooddata values('001',3,2,6,4,2,4,1);
  Update blooddata set ABpositive=Abpositive+2 where BID='12312';
  select * from bdonor where BID='12312';
  update blodddonordata set ldd2='2020-04-03' where BDID='123';
  insert into donorlogin values('Prash','sunny@123');
  insert into patientlogin values('Prash','sunny@123');
  insert into donordata values('Prash','12312','rashmika','ABpositive',17,'ongole','7993952303','2020-03-01','2020-03-01','60','yes');
  update donordata set status = 'NO' where ID ='Drash';
  select * from patientdata;
insert into patientdata values('Prash','rashmika',17,'12312','ABpositive','ongole','7993952303','2020-03-01','60');
CREATE VIEW sdonor AS
SELECT ID,BID,BGrp,Name,AGE,ADDRESS,MOBILE,LDD,status
FROM donordata;
CREATE VIEW spatient AS
SELECT ID,BID,BGrp,Name,AGE,ADDRESS,MOBILE,LDD,status
FROM donordata;
ALTER TABLE blodddonordata MODIFY COLUMN BDID VARCHAR(8);
ALTER TABLE donorlogin MODIFY COLUMN ID VARCHAR(9);
ALTER TABLE donordata MODIFY COLUMN ID VARCHAR(9);
ALTER TABLE patientlogin MODIFY COLUMN ID VARCHAR(9);
ALTER TABLE patientdata MODIFY COLUMN ID VARCHAR(9);
SELECT * FROM dbms_project.feedback;
insert into feedback values(5,4,3,2,1,2,3,"no more");
update donordata set JDD ='2020-04-04' where ID='D12312695';
insert into feedback values
(1,3,2,6,4,2,4,'NO'),
(1,3,2,6,4,2,4,'No'),
(1,3,2,6,4,2,4,'no'),
(1,3,2,6,4,2,4,'no');
insert into donorlogin values
('D10001123','sunny@123'),
('D10002123','bffs123'),
('D10003123','Raju$321'),
('D10004123','Sivareddy@95%'),
('D10005123','Chakradhar%@100'),
('D10006123','Dheeraj@150'),
('D10007123','Rajesh@pass'),
('D10008123','Prakash@$$$'),
('D10009123','Rakesh@<>'),
('D10010123','Nazeer$$$');

insert into donordata values
('D10001123','10001','Salman','ABpositive',19,'ongole','7993952303','2019-03-01','2020-03-01','30','yes'),
('D10002123','10002','Aravind','Bpositive','21','Mumbai','999994999','2020-01-12','2021-06-09','30','yes'),
('D10003123','10003','Rajesh','Anegative','25','Dharavi','8989852928','2019-09-21','2020-05-10','30','yes'),
('D10004123','10004','SahayamShiva','Opositive','27','Madanaplli','9898981213','2020-09-30','2021-04-29','30','yes'),
('D10005123','10005','Chakrapani','ABnegative','37','Hyderbad','7989852298','2019-04-23','2020-12-12','30','yes');
insert into patientlogin values
('P10001123','sunny@123'),
('P10002123','R@vi123'),
('P10003123','Anuskha$432'),
('P10004123','Rashmika123'),
('P10005123','deeraj$$12'),
('P10006123','Nikhil&$');

insert into patientdata values
('P10001123','Charapani',17,'10001','ABpositive','ongole','7993952303','2020-03-01','30'),
('P10002123','Ravishankar','19','10002','Bpositive','Madanapalli','7979898282','2021-04-04','30'),
('P10003123','Anuskha','23','10003','Opositive','Mumbai','9696969292','2020-02-10','30'),
('P10004123','Rashmika','21','10004','ABpositive','Tirupati','8987868523','2019-01-23','30'),
('P10005123','PamuDeeraj','30','10005','Onegative','Tirupati','9999993232','2020-03-30','30'),
('P10006123','Nikhil','21','10006','Anegative','Mumbai','8787868523','2019-12-23','30');
