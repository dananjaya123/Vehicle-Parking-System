
drop database parking;
create database parking;
use parking;
create table customer(
	nic varchar(20)not null,
	name varchar(100)not null,
	address varchar(100)not null,
	phoneNumber varchar(15)not null,
	email varchar(50),
	constraint primary key(nic)
);


create table payment(
	pID varchar(10)not null,
	tID varchar(10)not null,
	date date,
	amount double(20,2)not null,
    constraint primary key(pID),
	CONSTRAINT FOREIGN KEY (tID) REFERENCES ticket(tID)
	ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE parkingArea(
	paID VARCHAR(10) NOT NULL,
    area_Name VARCHAR(20),
    fee double(10,2),
     vehiclecategory varchar(50),
	CONSTRAINT PRIMARY KEY (paID)
);


create table parkingSlot(
	psID varchar(10)not null,
	paID varchar(10)not null,
	slot_Name varchar(20)not null,
	Length varchar(20)not null,
	widch varchar(20)not null,
    constraint primary key(psid),
	CONSTRAINT FOREIGN KEY (paID) REFERENCES parkingArea(paID)
	ON UPDATE CASCADE ON DELETE CASCADE
);

create table payment(
	pID varchar(10)not null,
	ptID varchar(10)not null,
	date date,
	amount double(20,2)not null,
    constraint primary key(pID),
	CONSTRAINT FOREIGN KEY (ptID) REFERENCES paymentType(ptID)
	ON UPDATE CASCADE ON DELETE CASCADE
);



create table vehicle(
	vID varchar(10)not null,
	vehicleNumber varchar(15)not null,
	vehicleColour varchar(10)not null,
    vehicleCategory varchar(15)not null,
	constraint primary key(vID)
	
);


create table registration(
	rID varchar(10)not null,
	vID varchar(10) not null,
	nic varchar(20)not null,
	date date,
	constraint primary key(rID),
	CONSTRAINT FOREIGN KEY (vID) REFERENCES vehicle(vID)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (nic) REFERENCES customer(nic)
	ON UPDATE CASCADE ON DELETE CASCADE
);


create table ticket(
	tID varchar(10)not null,
	rID varchar(10)not null,
	psID varchar(10)not null,
    paID varchar(10)not null,
	check_In_Time varchar(15)not null,
	check_In_Date date,
	customer_Name varchar(100)not null,
	phone_Number varchar(10)not null,
	check_Out_Time varchar(15),
	check_Out_Date date,
	constraint primary key(tID),
	CONSTRAINT FOREIGN KEY (rID) REFERENCES registration(rID)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (psID) REFERENCES parkingSlot(psID)
	ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (paID) REFERENCES parkingArea(paID)
	ON UPDATE CASCADE ON DELETE CASCADE
);

create table login(
	Login_ID varchar(10),
    Login_name varchar(25) not null,
    User_name varchar(25) not null,
    Password varchar(20)not null,
    Last_Login_date date default null,
    Last_Login_time time default null
    
    );
	
	
	create table slotbooking(
	psID varchar(10)not null,
	booked boolean not null,
		tID varchar(10),
	constraint primary key(psID),
	CONSTRAINT FOREIGN KEY (psID) REFERENCES parkingSlot(psID)
	ON UPDATE CASCADE ON DELETE CASCADE

);
    
    insert into login values ("LID001","admin","admin","1234","2018-06-4","08:10:00");