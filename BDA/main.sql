drop table stats;

create table STATS(
NOMTABLE varchar(20),
NBMAJ NUMBER
);
insert into stats values('EMP',20);
insert into stats values('DEPT',30);
create table DEPT(
id number,
nom varchar(20))

Select * from EMP;


update emp set emp.name='nom';
Select * from stats;


create or replace trigger emp__update 
after update or insert on EMP
for each row 
BEGIN
update STATS set NBMAJ=NBMAJ+1 where nomtable='emp';
END;



drop view statown;
select owner from all_tables where table_name='STATS';
Select* from statown; 
create view statown as select owner,SUM(nbmaj) totmaj
from STATS,all_tables where nomtable=table_name
group by owner;
grant select on statown to public;


select * from stats;
 

create user AB identified by password;









