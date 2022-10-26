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
## transatction:
un unite d mises a jours.compose d'operation qui doivent toutse etre
exeutees ou poas du tout.

--valide:commit
-annuler(abort,rollback)
### properieted aid:
- automicite
- coherence 
- isolation 
- durabilite
## atomicite:
une transaction etatn une unite d'operations dur une base de donnees
l'anulation d'une transaction doit conduire a lannulation de tous ses
efts sur la ase de donnes
le sqbd doir conserver l'nistoryique des modifications non encore
validees pourpouvoir les restaure les donnnes origincales au cas ou la
transcation s auant effectuue ces modifications a ete annuee

## coherence 
une transaction doit faire passer une base de donnes d'un ett coheren a
un autre etat coherent 
un etat coherent est un etat out toutes les contrantes d'inegrite sont
respetees

 oracle propose de verifier chaque contrainte d'inefrite:
 - aud moment de la modification des donnees(par defaut)
 -  Aumoment de la validation de la transaction (clauses DEFFERABLE
		 INTIALLY DEPFERRED)
	
## concurrence des acces 
i plusierus transaction s'executen en parallele certian ..
## incoherence 
plusierus transactions modifiant des donnees liees parte une contrainte
d'interite peut introduire dees incoherences 
## perte de mises a jour
unne perte de mise a jour peut arriver lorsqu'une transaction calcule
une mise a jour a partir d'une donnee permee

## lecture non reproducitibles 
deu lexxture d'une meme donnee dans la meme transaction peuvent conduire
a deux valeur differentes si elle a ete modifie pa une autre
transaction.

## controle de concurrence 
les problemes lies a la concurrence des acces sont des aux acces
concurrents aux donnees en lecture et en ecriture des differentes
transaction 

lorsque les transactions sont executees de maniere serielle les
provlemes de concurrence vus precedemenet ne se posent pas 

## lecture non prepodcutiles 
deux lecture d'une meme donnee dans la meem transaction peuvent conduire
a deux valeurss fdifferentes si elle a ete modifiee par une autre
tansaction
## execution serialisable 
ne permettre l'execution que d
une seule transaction a la fois empeche lexpoitation optimale des
ressources disponibles (capacie de calcul ,parraleilism..). 
cela aumente condiderablement le temps de repone de la base de donnnees 
la solution consiste a executer en parallele les transactions dont le
affaires . 

## operations permutables 
chauqe transaction deux types d'oerations: 0 lecture R: lecture d'un
objet de la base dedonnnes lire le salaire de l'impolyqe 
- ecriture(2)

Deux operations dont ditees permutable si  leur effet est identique
quelque soit l'ordre dans lequel elles sont executees:
- les operations sur de objets distincts sot permutables
- - les operation de lecture dur le meme objet dont permutable 
- les operationd d'ecriture dur le meme objet ne sont par permutables
	
## execution seialisable 

un scenario d'exection serialisable est une
executin pouvant etre ramenee a une exjcution seielle equivalente par un
ensemble de permutations d'operations permutables.`

