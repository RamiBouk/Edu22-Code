# Chapitre1: 
### Def:
un laog est suitre fini d'operatoins elementaire constituant un schema
de calcul ou de resolution d'une problem
### Correct & Complet

1. execute correctement
2. considere tous les cas 

### Efficace:

complexite minimal(temps et espace)

### Complexite temps: 
temps de calcul
### Complexite spatial:
l'espace memoire

### Complexite pratique:
precise a une machine donne

## Complexe theorique
inependante des conditions pratiques

### Def
Complexite d'un algo est la mesure de numbre d'operation fondamentales

### Type de complexite:

1. au meilleur
2. en moyenne
3. au pire

en s'interessse au cas le plus defavorable

### Etape de calcul de complexite:

1. definir unite de mesure
2. calcul $T(n)$
3. estimation d'une borne superieur $f(n)$ de $T(n)$

### Def operation elementaire:
une operation qui prend un temps fini(arithmetiques,acees aux donnee,
sauts conditionnels et inconditionnels.

$T(n)=T_{l1}+T_{l2} +T_{l3}+...$
### Conditionnel:

	si cond alors 
		l;

$T(n)=T_{Condition}+T_{l}$

	si cond alors:
		l1
	sinon:
 		l2

 $T(n)= T _{Condition}  + Max(T _{l1} ,T _{l2})$

### Boucle pour:

	pour i de debut a fin:
		l(j);
 
$T(n) = 1 +\sum_{j=1,..,n}(2+T_j(l))$

### Boucle tantque:

	Tantque(cond):
		l;
q: le nombre que le corps de la boucle est execute:

$T(n)=q*(T(condition)+T(l))$

## La notation de Landau $O$

- explique formellement les performances d'un algo
- la limite superieure d'une fonction dans un faceur constant
- caracterise le comportement asympototique des fonctions

### Lemme:
$$
O(f)+O(g)=O(f+g).\\
O(f)\times O(g)=O(f\times g).\\
si: f=O(f),\ alors\ Of(f+g)=O(g).\\
si:  \lambda \in \R_+,\ O(\lambda f)=O(f).
$$

