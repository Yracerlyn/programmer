# Projet Java
Ce projet vous permet d'intéragir avec une base de donnée de programmeur.

# Lancement de l'application
Vérifier dans la classe Constante que vos constantes de connexion à la base de donnée soit bien mis à jour pour la connexion à votre base.
Le lancement se fait dans la classe Start.

# Choix du SGBD
Rapide, fiable et facile à apprendre, MySQL est le SGBD parfait pour ce genre projet. De plus MySQL est bien pris en charge par Java grâce à des pilotes JDBC (Java Database Connectivity) robustes. MySQL propose aussi des fonctionnalités de sécurité telles que l'authentification, les autorisations d'accès et le chiffrement des données pour protéger votre base de données.
MySQL est l'un des SGBD open source les plus populaires au monde, ce qui signifie qu'il bénéficie d'une grande communauté d'utilisateurs et de développeurs. Ainsi il est facile de trouver les solutions au problèmes que vous rencontrez.

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

# Axe d'amélioration:



