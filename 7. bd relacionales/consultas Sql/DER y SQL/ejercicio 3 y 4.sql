drop database empresa_internet;
create database empresa_internet;
use empresa_internet;
create table Client(
					dni int,
                    first_name varchar(45),
                    last_name varchar(45),
                    birth_date datetime,
                    state varchar(30),
                    city varchar(30),
                    primary key(dni)
					);
create  table pack(idPack int,
					speed int,
                    price decimal(11),
                    discount decimal(3),
                    dni int,
                    primary key(idPack),
                    foreign key(dni) references Client(dni)
                    
                    );
                    
insert into Client values(1017253800,'juan camilo','macias','1998-01-09','antioquia', 'medellin');
insert into Client values(1017253801,'david camilo','zapata martinez','2001-01-09','antioquia', 'medellin');
insert into Client values(1017253802,'juan andres','zapata ortiz','2005-01-09','valle', 'cali');
insert into Client values(1017253803,'juan pablo','zapata','1995-01-09','antioquia', 'medellin');
insert into Client values(1017253804,'juan carlos','zapata uribe','1989-01-09','valle', 'cali');
insert into Client values(1017253805,'andres camilo','echeverri macias','1988-01-09','antioquia', 'medellin');
insert into Client values(1017253806,'camilo','ochoa','2003-01-09','valle', 'cali');
insert into Client values(1017253807,'felipe camilo','henao','1994-01-09','antioquia', 'medellin');
insert into Client values(1017253808,'carlos camilo','henao','1965-01-09','antioquia', 'medellin');
insert into Client values(1017253809,'marcos camilo','zapata macias','1978-01-09','antioquia', 'medellin');
insert into pack values(1,300,80000,25,1017253800);
insert into pack values(2,200,40000,10,1017253800);
insert into pack values(3,150,20000,20,1017253800);
insert into pack values(4,300,80000,0,1017253801);
insert into pack values(5,100,10000,10,1017253801);

select * from Client where year(birth_date) > 2000;
select first_name as nombre,last_name as apellido from Client where state = 'antioquia' AND city='medellin';
select * from pack where dni in (1017253800,1017253801);
select * from client where (select count(*) from  pack where dni= client.dni)>0; 
select * from pack where discount = 0;
select * from pack where discount> 15 and price>= 40000;
select avg(price) as promedio from pack ;
select dni from client where first_name like '%camilo%';
select year(birth_date) as anio from client where first_name like 'juan%';
select first_name as nombre,last_name as apellido from Client where year(curdate())-year(birth_date)>=18;
