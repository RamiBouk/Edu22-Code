INSERT INTO CLIENTE VALUES(1,'RAMI','BOUK','ADR1','CP1','VILLE1',10,null);
INSERT INTO CLIENTE VALUES(2,'MOH','BOUK','ADR1','CP1','VILLE1',10,1);
INSERT INTO CLIENTE VALUES(3,'MOH','NOM','ADR1','CP1','VILLE1',10,1);


DROP TABLE CLIENTE;
DROP TABLE DETENTEUR;
DROP TABLE COMPTE;

create table CLIENTE(
NUMCL INTEGER,
PRENOM VARCHAR(20),
NOM VARCHAR(20),
ADR VARCHAR(20),
CP VARCHAR(20),
VILLE VARCHAR(20),
SALAIRE INTEGER,
CONJOINT INTEGER
);
COMMIT;
CREATE TABLE DETENTEUR(
NUMCL INTEGER,
NUMCP INTEGER
);
CREATE TABLE COMPTE(
NUMCP INTEGER,
DATEOUVER DATE,
SOLDE INTEGER
);

CREATE TRIGGER NOMCONJOINT
BEFORE INSERT OR UPDATE ON CLIENTE FOR EACH ROW
DECLARE
MSG EXCEPTION;
NAMECOJIONT VARCHAR(20);
BEGIN
IF(:new.conjoint is not null)
then
SELECT  NOM INTO NAMECOJIONT FROM CLIENTE WHERE :NEW.CONJOINT = NUMCL ;  
IF(:NEW.NOM != NAMECOJIONT)THEN
RAISE_APPLICATION_ERROR(-20200,'NOM COJOINT IS NOT THE SAME AS NOM CLIENT');
END IF;
END IF;
END;







