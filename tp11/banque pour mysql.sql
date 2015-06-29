-- phpMyAdmin SQL Dump
-- version 2.6.1
-- http://www.phpmyadmin.net
-- 
-- Serveur: localhost
-- Généré le : Vendredi 12 Mai 2015 à 10:31
-- Version du serveur: 4.1.9
-- Version de PHP: 4.3.10
-- 
-- Base de données: 'banque'
-- 

-- --------------------------------------------------------

-- 
-- Structure de la table 'client'
-- 

CREATE TABLE client (
  ID int(10) NOT NULL default '0',
  NOM char(20) default NULL,
  PRENOM char(20) default NULL,
  LOGIN char(20) default NULL,
  MOTDEPASSE char(10) default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Contenu de la table 'client'
-- 

INSERT INTO client VALUES (1, 'Dupond', 'David', 'david', 'david');
INSERT INTO client VALUES (2, 'Durand', 'sandie', 'sandie', 'sandie');
INSERT INTO client VALUES (3, 'Martin', 'fabrice', 'fabrice', 'fabrice');

-- --------------------------------------------------------

-- 
-- Structure de la table 'compte'
-- 

CREATE TABLE compte (
  ID int(10) NOT NULL default '0',
  ID_CLIENT int(10) default NULL,
  DISCRIMINANT char(2) default NULL,
  LIBELLE char(20) default NULL,
  SOLDE float default NULL,
  DECOUVERTAUTORISE float default NULL,
  PLAFOND float default NULL,
  TAUX float default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Contenu de la table 'compte'
-- 

INSERT INTO compte VALUES (11, 1, 'CC', 'courant david 12', 2990, 2000, NULL, NULL);
INSERT INTO compte VALUES (12, 1, 'CC', 'courant david 2', 1010, 1000, NULL, NULL);
INSERT INTO compte VALUES (13, 2, 'CC', 'courant sandie 1', 7000, 3000, NULL, NULL);
INSERT INTO compte VALUES (14, 2, 'CC', 'courant sandie 2', 3000, 3000, NULL, NULL);
INSERT INTO compte VALUES (15, 3, 'CC', 'courant fabrice 1', 1000, 4000, NULL, NULL);
INSERT INTO compte VALUES (16, 3, 'CC', 'courant fabrice 2', 1500, 4000, NULL, NULL);
INSERT INTO compte VALUES (17, 1, 'CE', 'epargne david 1', 1000, NULL, 500, 0.1);
INSERT INTO compte VALUES (18, 1, 'CE', 'epargne david 2', 2000, NULL, 400, 0.2);
INSERT INTO compte VALUES (19, 3, 'CE', 'epargne fabrice 1', 1000, NULL, 500, 0.1);
INSERT INTO compte VALUES (20, 3, 'CE', 'epargne fabrice 2', 2000, NULL, 400, 0.2);

-- --------------------------------------------------------

-- 
-- Structure de la table 'config_generale'
-- 

CREATE TABLE config_generale (
  ID_CLIENT int(10) NOT NULL default '0',
  EMAIL char(30) default NULL,
  PRELEVEMENT char(5) default NULL,
  OPTIONS char(30) default NULL,
  CARTE char(30) default NULL,
  PRIMARY KEY  (ID_CLIENT)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Contenu de la table 'config_generale'
-- 

INSERT INTO config_generale VALUES (1, 'david.dupont@bankonet.com', 'true', 'INT,REL,', 'STANDARD');
INSERT INTO config_generale VALUES (2, 'sandie.durand@bankonet.com', 'false', 'INT,CLE', 'GOLD');
INSERT INTO config_generale VALUES (3, 'fabrice.martin@bankonet.com', 'true', 'REL,CLE', 'STANDARD');
        