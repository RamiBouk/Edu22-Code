# Distrubuted systems
## Definition
n software compuonents that are running on m computers but run as 1 
system where n,m>1

The goal is to make a network work as a single computer

The benifits are of a distrubuted ystem are:

- Scalability: 
- Redundancy
useed to mean physical computer in different physical locations,
now it can refer to autonomous processes that run on the same physical 
computer and interact with each other by message passsing.
the two defining properties:

 - there are serveral autonomous computation entities 
 each has it’s own local memory
 - the entities communicate using message passing

     The user preceives the collection of proccesses as a unit.i

## Parllel and distrubuted computing:
  DS are goupr of netwoorked computers which share commun goal for
  their work. parallel and distrubuted computing have much overlap 
  and it's hard to distenguish them. but you can set:
 
 - in Parellel computing, all processes have a shared memory
to exchange information.
 - in distrubuted computing each processe has it's own private memory.

## Processus:
  element logiciel effectuan une tach.

 # chapitre1 Definitions:
## System ditribue:

- Tanenbaum: (set<ordinateurs>)=>une seul sys coherent
- Coulourise: (composent=noeuds d'un reseau d'ordi) qui coordonnent
    suelment avec les messages

## distribue vs centralise:
### centralise:

- exec une seule machine
- les app accedent localement aux ressources
### system ditribue:
- set<ordi> connecte communiquent via message
- apparait come une seule entite




###middleware:
- masquer le'heterogeneite des machines et systemes
- masquer la repatition des donnees et traitment

##caracteristiques:
- absence de horloge commune
- absence de memoire commune

## synchrones vs asynchrones
est ce que l'emetteur est le recepteur ont le meme temps
- async: temps de transferet borne
- sync: temps de tranfert et non borne mais fini:
## client-server vs paire-a-pairi

1. serveur contole tout
2. tout les noeuds peut jouer le role de client est serveur
## Avantages:
1. Economique
2. Puissance de calcul
3. Dtrubutione naturelle de certaines application?
3. Haute disponibilite

## Defis

1. L'interoperablity
2. L'overture:
3. Haute disponivilite
4. l'invariance a l'echelle 
5. la gestion de la securite
6. le maintien de la consistance des ressources:
7. le transparence
8. la tolerance aux fautes et la gestion
# Chapitre 2:

## Processus:
Element logiciel effectuant une tache. un groups des  evenement:
- Evenements interne 
- evenements d'emission de message
- Evenements de reception de message
Chaque processus:
- possede un id unique
- possede une memoire et horloge locales
- pas de connaissance de l'etat des autre processus
- les Ps d'un system se'executent en parallele
## Canal de communication 
### Caracteristiques
- unie ou bidirectionnel 
- fialbe ou non 
- ordre de reception par rapport a l'emission 
- synchrone ou asynchrone
### Modle de system ditribure pour ce cours 
bidirectionnel, fiable , non FIFO, asynchrone.
(UDP)
## Etat d'un systeme ditribue
 situation dans laquelle se troube un element a une instant donne.
 - Etat locale 
 - Etat global
### problematique
un etat est lie a un temps $t$ or chaque P a une horloge et temps unique
## Solutions
- Synchronisation des horloges
  - interne
  - externe
- Utilisation de temps logique
  - horloge de lamport 
  - horloge Vectorielle de mattern 
  - horloge Matricielle
## Temps physique
une convention internationale definit le temps pysique ou reel:
- UTC:temps universel coordonne
utilise une horloge atomique. un pc peut recevoire cet information pour
synchroniser

### le temps et l'etat global sont difficiles a realiser dans les SDs:
- les Ps sont ditribues geographiquement
- le Taux d'occurrence des evenemtns est eleve
- les durees d'execution des evenements est tre courtes
- le delai de transfere des messages n'est pas negligable

<b> On ne peut qu'approximer la vision globale en:</b>
- Simulant un temps global via des horloque logiques
- Simulant un etat global via des snapshots globaux

### Temps physique: Algorithme de Cristian (centralise)
#### Utliser le temps d'un serveur:
- un client demande le temps ($T_0$).
- le serveur repond.
- le client recois la reponse ($T_1$).
- le client utliser le msg recue pour mettre a joiur son horloge.
- il y a des erreurs de precision, une estimation est:$(T_1-T_0)/2$
- $T_{client}=T_{serveur}+(T_1-T_2)/2$
### Temps physique: Algorithme de Berkeley (centralise)
- un $P_i$ est elu comme un serveur refrence de temps
- $P_i$ demande periodiquement le temps des autres $P$s
- $P_i$ calcule le moyen. ignoring extrem times.
- $P_i$ defuse le temps.
### Temps physique: Solution ditribue (decentralise)
- each $P$ defuse it's time
- each $P$ receive each other time
- chaque $P$ estime 
## Temps logique
- creer un temps qui n'est pas lie au temps physique
- cree une ordonnancement logique en fonction des evenements
### Temps logique: Chronogramme
${\large e} xy$ avec:
- $x$ le numero du P 
- $y$ numero de l'evenement
### Temps logique: dependanc causale
- $e'$ depend en $e$ si: $e$ doit avoir lieu avant $e'$
- Notation: $e \to e'$

- $e \to e'$ si et seulment si un de si condition:
  - e precede e' dans la meme procedure
  - e est l'emission d'un message, e'est la reception de ce message
  - il exist: $e \to f \land f \to e'$
- Evenements concurrents:
$$14444444444444
e \mid\mid e'
\iff
\overline{e\to e'} \land \overline{e'\to e}
$$
# chapitre 3
## Horloge de Lamport
## Horloge de Mattern
each process sends it's view on the other processes clocks as well with
ech message
## Horloge Matercialle
##Prtocole Birman-Shiper-Stephenson
it's a combination of matern and matricial
- les Ps se tamettent les messages par diffusion
- L'implementaiton du protocole est onde dur les regles siuants:
  - Regles 1: avan diffusion vi[i]:=vi[i]+1 et vm=vi[i]
  - Regles 2: 
