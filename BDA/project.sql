drop table notes;
drop table module;
drop table etudiant;

create table etudiant(
rang number(4),
code_e number(5) PRIMARY KEY,
name varchar(20),
prenom varchar(20),
moyenne number(4,2),
specialite varchar(20)
);
INSERT into etudiant(code_e,name,prenom) VALUES(10000,'N1','P1');
INSERT into etudiant(code_e,name,prenom) VALUES(20000,'N2','P2');
INSERT into etudiant(code_e,name,prenom) VALUES(30000,'N3','P3');
INSERT into etudiant(code_e,name,prenom) VALUES(40000,'N4','P4');
INSERT into etudiant(code_e,name,prenom) VALUES(50000,'N5','P5');
INSERT into etudiant(code_e,name,prenom) VALUES(60000,'N6','P6');


create table module(
code_m varchar(4) PRIMARY KEY,
intitule varchar(40),
coefficient number(2)
);
INSERT INTO module VALUES ('BDA','Base de données Avancée', 2);
INSERT INTO module VALUES ('PWA','Programmation web Avancée', 2);
INSERT INTO module VALUES ('MS','Modélisation est simulation', 3) ;

create table NOTES(
code_e number(5) REFERENCES etudiant(code_e),
code_m varchar(20) REFERENCES module(code_m),
note number(4,2) NOT NULL 
);
INSERT INTO NOTES VALUES (10000, 'BDA' ,20);
INSERT INTO NOTES VALUES (10000, 'PWA' ,20);
INSERT INTO NOTES VALUES (10000, 'MS' ,20);
INSERT INTO NOTES VALUES (20000, 'BDA' ,10);
INSERT INTO NOTES VALUES (20000, 'PWA' ,10);
INSERT INTO NOTES VALUES (20000, 'MS' ,6);
INSERT INTO NOTES VALUES (30000, 'BDA' ,4);
INSERT INTO NOTES VALUES (30000, 'PWA' ,4);
INSERT INTO NOTES VALUES (30000, 'MS' ,0);
INSERT INTO NOTES VALUES (40000, 'BDA' ,20);
INSERT INTO NOTES VALUES (40000, 'PWA' ,20);
INSERT INTO NOTES VALUES (40000, 'MS' ,20);
INSERT INTO NOTES VALUES (50000, 'BDA' ,0);
INSERT INTO NOTES VALUES (50000, 'PWA' ,0);
INSERT INTO NOTES VALUES (50000, 'MS' ,0);
INSERT INTO NOTES VALUES (60000, 'BDA' ,1);
INSERT INTO NOTES VALUES (60000, 'PWA' ,2);
INSERT INTO NOTES VALUES (60000, 'MS' ,3);
INSERT INTO NOTES VALUES (60000, 'MS' ,33);
INSERT INTO NOTES VALUES (60000, 'PWA' ,2);



CREATE OR REPLACE TRIGGER T1 before INSERT ON NOTES
FOR EACH ROW WHEN (new.note >20 or new.note <0) 
BEGIN
RAISE_APPLICATION_ERROR(-20500,'Insertion impossible: note non valide');
END;
/

CREATE OR REPLACE PROCEDURE proc_rang is
   cur_code_e ETUDIANT.code_e%TYPE;
   cur_moyenne ETUDIANT.moyenne%TYPE;
   n number:=1;
   
   CURSOR cur is
      SELECT code_e ,sum(note*coefficient)/sum(coefficient) as m
      FROM notes, module 
      WHERE module.code_m=notes.code_m
      GROUP BY notes.code_e,code_e 
      ORDER BY m DESC ;
BEGIN
    UPDATE etudiant SET rang=NULL ;
   OPEN cur;
   LOOP 
        FETCH cur INTO cur_code_e ,cur_moyenne; EXIT WHEN cur%NOTFOUND;
        UPDATE etudiant set moyenne = cur_moyenne WHERE code_e=cur_code_e;
    
   END LOOP;
   CLOSE cur;
   OPEN cur;
   LOOP 
        FETCH cur INTO cur_code_e ,cur_moyenne; EXIT WHEN cur%NOTFOUND;
        UPDATE  etudiant SET rang=n WHERE moyenne=cur_moyenne AND rang IS NULL;
        n:=n+1;
   END LOOP;
   CLOSE cur;
END;
/

begin
        proc_rang();
end;
/
UPDATE notes SET note=10 WHERE code_e=40000;
/
BEGIN 
        proc_rang();
END;
/

