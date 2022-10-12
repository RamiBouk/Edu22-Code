# Introduction

- SQL is a decalrative non precedural language
- PL/SQL is a languag just for SGBDR Oracle
- most other SGBDR	 HAVE THEIR OWN LANGUAGE AS WELL
- P;/SQL LETS YOU WRITE TRIGGERS 
## blocs PL/SQL
il ya 3 types de blocs:
- blocs annonymes
- procdedures stockees 
- fonctions stockees
## block pl/sql
```
DECLARE 

nom_const CONSTANT TYPE:=valeur;
nom_var type [NOT NULL:=valeur];
-- nom varchar2(60)
-- a type can defined as teh following; table_name%ROWTYPE
-- or table_name.col%TYPE

BEGIN

-- dbms.output.putline(something || something_else)-- for printing 
-- RECORD

-- IF cond THEN code ELSEIF code ELSE code ENDIF

-- CASE  exp 
-- WHEN exp1 THEN code ;
-- WHEN exp2 THEN code ;
-- ELSE code;

-- WHILE cond LOOP code ENDLOOP;
-- LOOP code EXIT WHEN cond code;
-- for i in [REVERSE] n TO m 

EXCEPTION

END
--COMENT
/*
COMMENT
*/
```
### types des donnes

tout les types de donnes oracle sont presents dans PL/SQL
notes:
PL programming language 
## Curseurs
c'est comme un pointeur, point sur un seul tuple;
1. Implicite:
creee implicitement dans INSERT, UPDATE, DELETE, SELECT ... INTO.

2. explicite:

cree par le develepeiur pl/sql
```
SELECT * INTO var_row FROM Table WHERE num=100;
nb_tupels:=i SQL%ROWCOUNT

```
### les attributs du curseur implicite:

- %FOUND
- %NOTFOUND
- %ROWCOUNT
### code cursor
```
-- declare
CURSOR nom_cursor IS SELECT noms_colomn FROM nom_table;
-- use (open,use,close just like a file)j
l
```
### lecture des tuples
```
FETCH nom_cursor into[list of <vari>|record]
```

### Tuple courant 

The tuple start at the begingn of the opened tble. then with each fetch
it moves down.
### les attr des curseur explicite.
same as implicite adding 
- %ISOPEN

### pprocedure stockee(or simply procedure)
#### il ya droid types des param:
- in(par valeur)
- out(reterning a value)
- in out(par variable)


```
[CREATE|REPLACE] PROCEDURE nom [params]
IS
-- declare variables
BIGEN

END;
```

calling the procedure this way:

in SQL:
` Procedure_name(param)`

in PL/SQL:
` EXECUTE Procedure_name(param);`

## fonctions
defined just like procedures with a return value.

for code just replace thekey word `PROCEDURE` with `FUNCTION` and use
the key word `return` to return a value. 

### Appele

SQL;
```
FROM function_name(params) FROM DUAL;
```
## Exceptions
### types des exception

- CURSOR_ALREADY_OPEN
- NO_DATA_FOUND
- ZERO_DIVIDE
- TOO_MANY_ROWS
- ...

### lever une erreur
in the code: 
```
RAISE exception_name;
```
in the exception:
```
IF exception_name then 
RAISE_APPLICATION_ERROR(ERROR_CODE,'text');
```

- use the function RAISE_APPLICATION_ERROR(ERROR_CODE,'text');
- ERROR_CODE are numbers from -20000 to -20999


## Packages
missed this part

## Separateur
use '/' between pl/sql blocs

# les triggers
definition
## declaration de trigger
## types des triggers
## trigger ligne
## cops u trigger
## nos de correlation
## resrictions

















