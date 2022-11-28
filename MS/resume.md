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

## REcurrence et transience:
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
\lambda\times P=\lambda / a+b=1
$$
under certaine conditions $X_n$ converge to $\lambda$
##
## Stats Classification
- classes irreductibles: etats que communique
- there's a transient state so they are irruductible disjointed classes
- i$\to$j: j is accecible to i
- i$\to$j and j$\to$i: i and j comunicate(i and j are equivalant)
	- this is what cause irredictable classes

# Probability d'absorption??????
