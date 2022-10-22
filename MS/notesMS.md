# Introduction:
## systeme
### Def:
\<moyen\|element\> agences de maniere a statisfaire un objectif donee
### caracteristiques d'un systeme:
- composants
- relations
- environnement
- mission
- evolutions
### types des syteme:

- discret(nombre denombrable d'etats)
- continu
- deterministe(same input=same output)
## Modelisation:
### Modele
#### Def:
represntatin d'un systeme construit pour un objective donne
## Def:

- operation de realit => math
- etapes comme decompostition en sous-systeme
- utiliser pourconfigurer ou analyser les systemes.
## Pourquoi:

- connaitre 
- predire 
- optimiser

il faut definir les points suivane:
- le systeme
- le modele
- l'objective
## Simulation:
### def:

- l'implementation dyamique d'un modele
- la traduction en programmes infomrmatique
## la recherche operationnelle (R.O)
### Def:
l'ensenble des methodes et technique pour la recherche de meilleur choix

aide a:
- comprendre 
- evaluer les enjeux
- arbitrer ou faire ls choix les plu efficaces
## Types de problemes traites:
### Combinatoire
- grande nombre de solutions admissibles
### Aleatoire:
- se pose en termes incertains
### Concurrentiel
- les termes depndent de l'interrelation entre ses propres agissement 
et ceux  d'autres decideurs
## Pricipales methodes de la R.O
- processus stochasticques
- Theorie des graphes
- la simulatoin informatique
- optimisation lineaire

# Chaines de Markov
une suite de variables aleatoires $(X_n)$
decriven  a chaque instant n l'etat d'une systeme laeatoire


with the next state only depeneding on the current state

- c'est un modele d'evolution dynamique en temps discret
- $p_{ij}(s,t)=P\{X(t)=j/X(s)=i\}$
- $s,t$: are a time value, $i,j$ are states
- $p$ est la probabilites de transition
## Homogeneite
$(X_n)$ es une hcaine de markov homogene si:

1. Propety de Markov:
$$
Pr(X_{n+1}=x_{n+1}|X_1=x_1,..,X_i=x_i,.,X_n=x_n)=
Pr(X_{n+1}=x_{n+1}|X_n=x_n)
$$
2. Homogeneite: 
$$
\forall n_1,n_2:Pr(X_{n_1+1}=y|X_{n_1}=x)=Pr(X_{n_2+1}=y|X_{n_2}=x)
$$
## Recurrence et transience
### transient
 i est transient si il exist un chemin pour ne jamais reviem
### recurrent
 i est recurrent si il n'est pas transient
### la periodicite 
le pgcd entre les nombre des pas dans les cycles entre i est i
defini par d(i).

si d(i)=1 alors i est aperiodique

si les etat i et j commniquent alos ils ont la meme periode

