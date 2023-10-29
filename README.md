# Projet Java
Ce projet vous permet d'intéragir avec une base de donnée de programmeur.

# Détails des classe principales
- package exec:
Start: Classe principale non instanciable pour le lancement du programme (une seule méthode y est appelé)
Menu: Classe qui gère toute la mécanique du programme. 

- package utils: 
Constantes: Classe pour stocker les constantes notemment les URL de connexion à la base de donnée. Il suffit donc de modifier ces informations pour faire fonctionner le programme si vous travaillez avec une autre base de donnée.
Programmeur: Classe de programmeur pour instancier les objet programmeur avec toutes les caractéristiques d'un programmeur (nom, prénom, année de naissance, adresse, pseudo, responsable, hobby, salaire, prime)

- package exception:
InvalidChoiceException: Classe qui permet de renvoyer un message d'erreur pour les choix des utilisateurs.

- package data:
ActionBDD: Interface pour le comportement générique du programme. Elle contient les méthodes principales du programme.
ActionBDDImpl: Classe qui implémente l'interface ActionBDD et permet ainsi d'implémenter toutes les méthodes du programme.

# package supplémentaire:
Les packages lib, .idea et out sont les packages pour assurer le bon fonctionnement du programme qui va de la connexion à la base de donnée MySql ou jdk.

# Fonctionnalité:
Au lancement du programme le menu est affiché à l'utilisateur. 
Il propose plusieurs options:
- Afficher tous les programmeurs dans la base de données
- Afficher un programmeur (l'utilisateur renseigne l'id du programmer qu'il recherche)
- Supprimer un programmeur
- Ajouter un programmeur (l'utilisateur doit donner le nom, prénom, adresse, hobby, pseudo, responsable, salaire, prime, années de naissance)
- une option autre qui permet d'accéder à une sous section du Menu:
    . Afficher le programmeur qui a le meilleur salaire
    . Afficher les programmeurs qui ont le même responsable 
    . Liste des activités des activités des programmeurs
    . Retour au menu principale.
- Quitter le programme.

# Interface Graphique:
Pour lancer l'interface du programme il suffit de se rendre dans la classe Interface où toute l'interface y est implémenté.
Aprés avoir lancer l'interface vous aurez une interface avec un dashboard à droite avec toutes les commandes possible comme dans la partie fonctionnalité. Et une zone de réponse où vous trouverez les résultats de vos manipulation.