## Chapitre1: 
#def:
un laog est suitre fini d'operatoins elementaire constituant un schema
de calcul ou de resolution d'une problem
## Correct & Complet

1. execute correctement
2. considere tous les cas 

## Efficace:

complexite minimal(temps et espace)

## complexite temps: 
temps de calcul
## comlexite dpatial:
l'espace memoire

## complexite pratique:
precise a une machine donne

## comp theorique
inependante des conditions pratiques

## def
Complexite d'un algo est la mesure de numbre d'operation fondamentales

## Type de complexite:

1. au meilleur
2. en moyenne
3. au pire

en s'interessse au cas le plus defavorable

## Etape de calcul de complexite:

1. definir unite de mesure
2. calcul T(n)
3. estimation d'une borne superieur f(n) de T(n)

## def operation elementaire:
une operation qui prend un temps fini(arithmetiques,acees aux donnee,
sauts conditionnels et inconditionnels.

T(n)=T~l1~+T~l2~+T~l2~+...
### Conitionnel:
`si cond alors
	l;`
T(n)=T~Condition~+T~l~

	`code`


`
si cond alors:
 l~1~
sinon:
 l~2~
`
T(n)= T~Condition~ + Max(T~l1~,T~l2~)


