# Distrubuted systems
##Definition
n software compuonents that are running on m computers but run as 1 system where n,m>1

The goal is to make a network work as a single computer

The benifits are of a distrubuted ystem are:

- Scalability: 
- Redundancy
useed to mean physical computer in different physical locations, now it can refer to autonomous processes that run on the same physical computer and interact with each other by message passsing.
the two defining properties:

 - there are serveral autonomous computation entities each has it’s own local memory
 - the entities communicate using message passing

     The user preceives the collection of proccesses as a unit.i

## Parllel and distrubuted computing:
  DS are goupr of netwoorked computers which share commun goal for their work. parallel and distrubuted computing have much overlap and it's hard to distenguish them. but you can set:
 
 - in Parellel computing, all processes have a shared memory to exchange information.
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

##architecture:
application: |----|-----|----|

midleware:   |              |

sys de coms: |    |    |    |

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
















