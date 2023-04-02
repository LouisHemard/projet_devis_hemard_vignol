SET foreign_key_checks = 0;
DROP TABLE IF EXISTS devis_produits;
DROP TABLE IF EXISTS deviss;
DROP TABLE IF EXISTS produits;
DROP TABLE IF EXISTS client;
SET foreign_key_checks = 1;

CREATE TABLE client (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        societe_nom VARCHAR(250) NOT NULL,
                        mail VARCHAR(250),
                        tel VARCHAR(10) NOT NULL,
                        adresse VARCHAR(250) NOT NULL,
                        code_postal VARCHAR(250)NOT NULL,
                        ville VARCHAR(250)NOT NULL,
                        pays VARCHAR(250)NOT NULL
);



CREATE TABLE produits (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nom VARCHAR(250) NOT NULL,
                         description VARCHAR(250) NOT NULL,
                         largeur DECIMAL,
                         longueur DECIMAL,
                         hauteur DECIMAL,
                         ecart DECIMAL,
);




CREATE TABLE deviss (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       client_id INT,
                       date_creation DATE NOT NULL,
                       description VARCHAR(250),
                       FOREIGN KEY (client_id) REFERENCES client(id)
);


CREATE TABLE devis_produits (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               devis_id INT NOT NULL,
                               produit_id INT NOT NULL,
                               quantite INT NOT NULL,
                               unite varchar,
                               FOREIGN KEY (devis_id) REFERENCES deviss(id),
                               FOREIGN KEY (produit_id) REFERENCES produits(id)
);


INSERT INTO client (societe_nom, mail, tel, adresse, code_postal, ville, pays) VALUES
                                                                  ('HEMARD&VIGNOL', 'hemard.vignol@orange.fr', '0767667723', '32 bord', '87700', 'Busiere Galant', 'France'),
                                                                  ('Test&VIGNOL', 'hemard.vignol@orange.fr', '0767667723', '32 bord', '87700', 'Busiere Galant', 'France'),
                                                                  ('HEMARD&Test', 'hemard.vignol@orange.fr', '0767667723', '32 bord', '87700', 'Busiere Galant', 'France');

INSERT INTO produits (nom, description, largeur, longueur, hauteur, ecart) VALUES
                                                                ('Barriere jointe maille carree', 'Barriere jointe maille carree', '1.85','1','2','1'),
                                                                ('Barriere Murale', 'Barriere jointe pour Mur', '0.54','1','2','1');


INSERT INTO deviss (client_id, date_creation, description) VALUES
                                                    ('1','2023-01-25','Devis de plusieur barrière pour un jardin');

INSERT INTO devis_produits (devis_id, produit_id, quantite, unite) VALUES
                                                         ('1', '1', '4','unit');