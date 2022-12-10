### System
Set of means and elements that are used in a way to satisfy an objective
done

### Model 
A representation of a constructed system for an objective

#### why modele 
- to know
- to predict
- to optimise

### Simulation
The dynamic implementation of a model and the translation to the
computer programme

### Operational research
The methods and techniques for research of the best choice
#### types of problems:
- Combinatorial
- Random
- Competitive

# Markov chains
a list of ($Xn$) variables that describe a system at the state n
where the next state is only effected by the current state

## a homogene Markovien chain
1. property de markov:
$$
P\{X_{n+1}=x_{n+1}|X_1=x_1,..,X_i=x_i,.,X_n=x_n\}=
P\{X_{n+1}=x_{n+1}|X_n=x_n\}
$$
2. Homogeneite: ( the current time doesn't matter)
$$
\forall n_1,n_2:P\{X_{n_1+1}=y|X_{n_1}=x\}=P\{X_{n_2+1}=y|X_{n_2}=x\}
$$

## Recurrence et transience:
### Transiet 
There is a way to transende the state(never return to it)
### Recurrent
Can't be transended
### Priodicite
The PGCD of number of cycles that include d(i)

- if d(i)=0 then  i is aperiodique
- if two sates comunicate they have the same periodicite

## Trajectory law
for a $Markov(\mu,P)$ \ $\mu$ the intial law

$$
P(X_{0:n}=x_{0:n})=\mu(x_o)p(x_0,x_1)p(x_1,x_2)...p(x_{n-1},x_n)
$$
## $X_n$ law
$$
X_n=X_{n-1}\times P=X_0\times P^n
$$
## Convergence
$X_n$ converge when $n$ is big enough
## Mesure of probability
$\lambda=(a,b)$ is a mesure of probablity that is invariante for $P$ 
if :
$$
\lambda\times P=\lambda\ where \ a+b=1
$$
under certaine conditions $X_n$ converge to $\lambda$
##
## States Classification
- classes irreductibles: etats que communique
- there's a transient state so they are irruductible disjointed classes
- i$\to$j: j is accecible to i
- i$\to$j and j$\to$i: i and j comunicate(i and j are equivalant)
	- this is what cause irredictable classes

# Probability d'absorption
$$
a^{(Ri)}=a^{(Ri)}(1)+PT*a^{(Ri)}
$$
$$
 R1={1,2,3,4}\\ 
 a_5=2/7+3/7 
 a_5+2/7 a_6  \\
 a_6=1/2 a_5 \\
 a_7=1/6 a_6\\
 a5= 2/3          \      a6= 1/3      \           a7= 1/18\\

 R2={8}\\
 =3/7 a_5+2/7 a_6\\ 
 a_6=1/2+1/2 a_5\\ 
 a_7=5/6+1/6 a_6\\
 a5= 1/3\\ 
 a6= 2/3\\
 a7=17/18\\

$$
# Les filles d'attente markoviennes
add poisson law here

- $\lambda$ the average number of occurences per unite of time(taux de
naissance)

- ${\mu}$ services per unite of time ($\mu$ taux de mort)
- il y a $S$ server
- $X_t$ l'etat du systeme en $t$
- les point de changement sont pas exact au temps
- $L$ le nombre moyen de client dans le systeme
- $Lq$ nombre moyen de client dans le queue d'attente
- $Wq$ durree d'attente moyenne d'un client
- $W$ la duree moyenne dans le systeme
## M/M/1
- $\mu p_1=\lambda p_0$
- $\mu p_2+\lambda p_0=\mu p_1+\lambda p_1$
- $u=\lambda/\mu$
- $p_0=1-u$
- $p_n=u^np_0$
- $L=\frac{u}{1-u}$
- $Lq=\frac{u^2}{1-u}$

### Any type of F.A.M
- $L=\sum_{i=1}^n np_n$
- $L_q=\sum_{n=s+1}^{+\infin} (n-s)p_n$

## Formules de little
- $L=\lambda W$
- $L_q=\lambda W_q$
- $L=L_q+\frac{\lambda}{\mu}$
- $W=W_q+\frac{1}{\mu}$


