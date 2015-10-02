USE `open_crip` ;

-- -----------------------------------------------------
-- Table `open_crip`.`Client`
-- -----------------------------------------------------
-- DELETE FROM `open_crip`.`Client`;

INSERT INTO `open_crip`.`Client` (`nom`,`prenom`) VALUES ('Vossough', 'Adrien');
INSERT INTO `open_crip`.`Client` (`nom`,`prenom`) VALUES ('Dupenne','Arnaud');
INSERT INTO `open_crip`.`Client` (`nom`,`prenom`) VALUES ('MOZAR','Eddy');
INSERT INTO `open_crip`.`Client` (`nom`,`prenom`) VALUES ('Ghanem','Alexandre');

-- -----------------------------------------------------
-- Table `open_crip`.`Fournisseur`
-- -----------------------------------------------------

INSERT INTO `open_crip`.`Fournisseur` (`nom_enseigne`, `chiffre_affaire`) VALUES ('Au Bon Bif Stek', 50000.00);
INSERT INTO `open_crip`.`Fournisseur` (`nom_enseigne`, `chiffre_affaire`) VALUES ('My KiPape', 40000.00);
INSERT INTO `open_crip`.`Fournisseur` (`nom_enseigne`, `chiffre_affaire`) VALUES ('Boulangerie de la Gare', 75000.00);
INSERT INTO `open_crip`.`Fournisseur` (`nom_enseigne`, `chiffre_affaire`) VALUES ('Aston Restau', 26000.00);


-- -----------------------------------------------------
-- Table `open_crip`.`Adresse`
-- -----------------------------------------------------
-- DROP TABLE IF EXISTS `open_crip`.`Adresse` ;
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (20, 'rue Emile Raspail', NULL, '94110', 'Arcueil Cachan', 'France', null, null);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (3, 'bd Haussman', NULL, '75002', 'PARIS', 'France', null, null);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (17, 'Rue des Rosiers', NULL, '75011', 'PARIS', 'France', null, null);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (120, 'bd Strasbourg Saint Denis', NULL, '75001', 'PARIS', 'France', null, null);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (14, 'bd du 11 septembre', NULL, '92160', 'ANTONY', 'France', null, null);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (1, 'rue de docteur Gosselin', NULL, '94110', 'Arcueil Cachan', 'France', 48.798605, 2.327915);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (25, 'avenue Carnot', NULL, '94230', 'Cachan', 'France', 48.798108, 2.328401);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (19, 'rue du 8 mai 1945', NULL, '94110', 'Arcueil Cachan', 'France', 48.7982171, 2.328266);
INSERT INTO `open_crip`.`Adresse` (`numero`, `adresse_1`, `adresse_2`, `code_postal`, `ville`, `pays`, `latitude`, `longitude`)
VALUES (4, 'Rue du Dr Gosselin', NULL, '94230', 'Cachan', 'France', 48.800996, 2.328692);

-- -----------------------------------------------------
-- Table `open_crip`.`Utilisateur`
-- -----------------------------------------------------
INSERT INTO `open_crip`.`Utilisateur` (`identifiant`, `mot_de_passe`, `email`, `telephone`, `date_inscription`,
  `date_derniere_connexion`, `id_adresse`, `id_client`, `id_fournisseur`)
VALUES ('advos', 'advos', 'adrienvossough@gmail.com', '06 79 44 33 34', '20150923', NULL, 1, 1, NULL);

INSERT INTO `open_crip`.`Utilisateur` (`identifiant`, `mot_de_passe`, `email`, `telephone`, `date_inscription`,
  `date_derniere_connexion`, `id_adresse`, `id_client`, `id_fournisseur`)
VALUES ('ardup', 'ardup', 'adupenne@gmail.com', '06 47 88 38 22', '20150923', NULL, 2, 2, NULL);

INSERT INTO `open_crip`.`Utilisateur` (`identifiant`, `mot_de_passe`, `email`, `telephone`, `date_inscription`,
  `date_derniere_connexion`, `id_adresse`, `id_client`, `id_fournisseur`)
VALUES ('edmoz', 'edmoz', 'eddy.mozar@free.fr', '06 22 34 94 91', '20150923', NULL, 3, 3, NULL);

INSERT INTO `open_crip`.`Utilisateur` (`identifiant`, `mot_de_passe`, `email`, `telephone`, `date_inscription`,
  `date_derniere_connexion`, `id_adresse`, `id_client`, `id_fournisseur`)
VALUES ('algha', 'algha', 'alexandreghanem66@gmail.com', '06 52 60 81 12', '20150923', NULL, 4, 4, null);



-- -----------------------------------------------------
-- Table `open_crip`.`Produit`
-- -----------------------------------------------------
-- 'Au Bon Bif Stek', id_fournisseur=1
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('EN01-Taboule', 3.0, 1); -- 1
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('EN02-Salade Oeuf Mayo', 3.0, 1); -- 2
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('EN03-Assiete Charcuterie', 3.0, 1); -- 3
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PL01-Steak Hache Pomme Frite', 7.0, 1); -- 4
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PL02-Onglet Sauce Poivre', 10.0, 1); -- 5
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PL03-Bavette d\'Aloyau au Plancha', 15.0, 1); -- 6

-- 'My KiPape', id_fournisseur=2
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('EN01-Sandwich Kebab Poulet', 4.0, 2); -- 7
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('EN02-Sandwich Kebab Mouton', 4.0, 2); -- 8
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('EN03-Sandwich Kebab Merquez', 3.0, 2); -- 9
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PL01-Poulet Doner', 7.0, 2); -- 10
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PL02-Menu Kebab', 10.0, 2); -- 11
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PL03-Pizza Fromage', 6.0, 2); -- 12

-- 'Boulangerie de la Gare', id_fournisseur=3
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PA01-Eclaire au Chocolat', 3.0, 3); -- 13
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PA02-Flan Nature', 3.0, 3); -- 14
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('PA03-Fraisier', 3.0, 3); -- 15
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('SW01-Sandwich au Poulet', 4.0, 3); -- 16
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('SW02-Sandwich Pate', 5.0, 3); -- 17
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('SW03-Sandwich Jambon Beurre', 5.0, 3); -- 18

-- 'Aston Restau', id_fournisseur=4
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('ME01-Menu Java JEE', 4.0, 4); -- 19
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('ME02-Menu PHP', 4.0, 4); -- 20
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('ME03-Menu DotNET', 4.0, 4); -- 21
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('SW01-Menu MSI', 10.0, 4); -- 22 
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('SW02-Menu Enseignant', 10.0, 4); -- 23
INSERT INTO  `open_crip`.`Produit` (`reference_produit`, `prix_unitaire`, `id_fournisseur`)
VALUES ('SW03-Menu AQ', 3.0, 4); -- 24

-- -----------------------------------------------------
-- Table `open_crip`.`Paiement`
-- -----------------------------------------------------
INSERT INTO `open_crip`.`Paiement` (`date_paiement`, `mode_paiement`) 
VALUES ('2015-09-23 12:13:00', 'CB');
INSERT INTO `open_crip`.`Paiement` (`date_paiement`, `mode_paiement`) 
VALUES ('2015-09-23 12:15:00', 'CB');

-- -----------------------------------------------------
-- Table `open_crip`.`Commande` / `CommandeProduit`
-- -----------------------------------------------------
INSERT INTO `open_crip`.`Commande` (`prix_total`, `date_commande`, `date_validation`, `id_client`, `id_paiement`)
VALUES (7.0, '2015-09-23 12:10:00', '2015-09-23 12:11:00', 1, 1);

INSERT INTO `open_crip`.`CommandeProduit` (`prix_unitaire`, `quantite`, `id_commande`, `id_produit`)
VALUES (3.0, 1, 1, 13); 
INSERT INTO `open_crip`.`CommandeProduit` (`prix_unitaire`, `quantite`, `id_commande`, `id_produit`)
VALUES (4.0, 1, 1, 16); 

INSERT INTO `open_crip`.`Commande` (`prix_total`, `date_commande`, `date_validation`, `id_client`, `id_paiement`)
VALUES (7.0, '2015-09-23 12:10:00', '2015-09-23 12:11:00', 2, 2);

INSERT INTO `open_crip`.`CommandeProduit` (`prix_unitaire`, `quantite`, `id_commande`, `id_produit`)
VALUES (7.0, 1, 2, 4); 
