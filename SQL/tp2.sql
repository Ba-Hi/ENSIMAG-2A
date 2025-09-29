DROP TABLE Comptes ;
CREATE TABLE Comptes(
    NC INT,
    Nom VARCHAR(30),
    Solde FLOAT CHECK (Solde >=0)
);
