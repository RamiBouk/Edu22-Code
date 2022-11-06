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
$(X_n)$ es une chaine de markov homogene si:

1. Propety de Markov: ( the past states don't matter)
$$
P\{X_{n+1}=x_{n+1}|X_1=x_1,..,X_i=x_i,.,X_n=x_n\}=
P\{X_{n+1}=x_{n+1}|X_n=x_n\}
$$
2. Homogeneite: ( the current time doesn't matter)
$$
\forall n_1,n_2:P\{X_{n_1+1}=y|X_{n_1}=x\}=P\{X_{n_2+1}=y|X_{n_2}=x\}
$$
## Recurrence et transience
### Transient
 i est transient si il exist un chemin pour ne jamais reviem
### Recurrent
 i est recurrent si il n'est pas transient
### La periodicite 
le pgcd entre les nombre des pas dans les cycles entre i est i
defini par d(i).

si d(i)=1 alors i est aperiodique

si les etat i et j commniquent alos ils ont la meme periode

# le loi de poison(loi natural pour les varaible discret)
## definition
le processus depoisoon set a modeleiser l'occurrene d'evenemts
successive

le variable discret $X$ siut une loi de posson de parametre $\lambda$ si

$$
\forall k \in N, P\{X=k\}=e^{-\lambda}\times \frac{\lambda^k}{k!}
$$
- $p[x=k]$: la probablite d'avoir k A fois
- $\lambda$ expected value of x and also varirance 

### dfintin le loi d'expo
## Les files d'attente Markoviennes 

- dans unchaine de markov le temps est discret 
- on analyse un situationdans le system est analyser de facon continue
- $X_t$: l'etat du systeme en $t$
- les  points sont aleatoires dans le temps

## processus de naissance et de mort 
- 
