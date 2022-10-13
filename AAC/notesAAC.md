# Chapitre1: 
### Def:
un algo est suitre fini d'operatoins elementaire constituant un schema
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
si: f=O(f),\ alors\ O(f+g)=O(g).\\
si:  \lambda \in \R_+,\ O(\lambda f)=O(f).
$$

### La notation $\Theta$
$$
T(n)=\Theta(f(n))\ si\  \exist c_1,c_2,n_0 / \\
\forall n>n_0: c_1\times f(n)\le T(n)\le c_2\times f(n)
$$

### Quelgues regles de la notation $O$
- $O(c)=O(1)$
- $O(cT)=cO(T)=O(T)$
- $O(T1+T2)=O(max(T1,T2))$
- $O(T1)\times O(T2)=O(T1\times T2)$

### les principales classes de complexite
$
O(1)\le O(n)\le O(log(n))\le O(n\ log(n))\le O(n^2)\le O(n^p)\le O(a^n) 
$

# Chapiter 2 Paradigme diviser pour regner
## Principe general
- analyse descendante

1. deviser le problem de taile n en sous-problemes plus petits
2. la solution de chaque sous-probleme facilite la
construction du probleme entier

## Schema generalm
```
DPR(x):
	Si x est suffisamment petit ou simple:
		return A(x)
	else
		Decomposer x en sous  exemplaires x1,x2,..xk
		pour i=1,k: yi=DPR(xi) finpour
		return les yi pour obtenir une solution a x
		retourner y;
	FinSi
```
## la relation de recurrrence

$$
 T(c)=O(1) \\
 T(n)=aT(n/b)+O(f(n))\\
T(n)=D(n)+C(n)\\
$$
## la maitre theorem special 
if
$$
T(n)=aT(n/b)+\Theta (n^d)
$$
there is :
$$ 
if\ d \ge log_b(a)=> T(n)=\Theta (n^d)\\
if\ d \le log_ba=>T(n)=\Theta(n^{log_ba})\\
if\ d = log_ba=>T(n)= \Theta(n^d log\ n)\\
$$
there's also general master theorm take notes on it but it won't be user
### Applications:
- binary seach
- find maximum
- quick sort
- rani
### need more notes here




