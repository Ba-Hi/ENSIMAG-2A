-- ATOMICITÉ :

-- PARTIE 1: Exercice 1 

DROP TABLE Comptes;
CREATE TABLE Comptes(
    NC INT,
    Nom VARCHAR(30),
    Solde FLOAT CHECK (Solde >=0)
);

INSERT INTO Comptes VALUES (1, 'Paul', 1000);
INSERT INTO Comptes VALUES (2, 'Paul', 2000);
                           
SELECT SUM(Solde)
FROM Comptes;

ROLLBACK;

SELECT SUM(Solde)
FROM Comptes;

-- PARTIE 1: Exercice 2

INSERT INTO Comptes VALUES (3, 'Pierre', 100);
INSERT INTO Comptes VALUES (4, 'Pierre', 2000);

COMMIT ;

INSERT INTO Comptes VALUES (5, 'Paul', 5000);
INSERT INTO Comptes VALUES (6, 'Paul', 6000);


SELECT SUM(Solde), Nom
FROM Comptes
GROUP BY Nom;

ROLLBACK;

SELECT SUM(Solde), Nom
FROM Comptes
GROUP BY Nom;

-- PARTIE 1: Exercice 3

SET AUTOCOMMIT ON;

INSERT INTO Comptes VALUES (7, 'Jacques', 30);
INSERT INTO Comptes VALUES (8, 'Jacques', 40);

SELECT SUM(Solde)
FROM Comptes;

ROLLBACK;

SELECT SUM(Solde)
FROM Comptes;

-- PARTIE 1: Exercice 4
SET AUTOCOMMIT OFF;

INSERT INTO Comptes VALUES (9, 'Jean', 170);
INSERT INTO Comptes VALUES (10, 'Jean', 20);

SAVEPOINT DeuxInserts;

INSERT INTO Comptes VALUES (11, 'Jean', 7000);
INSERT INTO Comptes VALUES (12, 'Jean', 1000);

SELECT SUM(Solde)
FROM Comptes
WHERE Nom LIKE 'Jean';

ROLLBACK TO DeuxInserts;

SELECT SUM(Solde)
FROM Comptes
WHERE Nom LIKE 'Jean';

ROLLBACK;

SELECT SUM(Solde)
FROM Comptes
WHERE Nom LIKE 'Jean';


-- COHÉRENCE :

-- PARTIE 2 : Exercice 1

SELECT *
FROM Comptes;

INSERT INTO Comptes VALUES (1, 'Claude', 100);
INSERT INTO Comptes VALUES (2, 'Henri', 200);

UPDATE Comptes
SET Solde = Solde + 50
WHERE Nom = 'Henri';

UPDATE Comptes
SET Solde = Solde - 150
WHERE Nom = 'Claude';

SELECT Nom, Solde
FROM Comptes
WHERE Nom IN ('Henri', 'Claude');

COMMIT;

SELECT *
FROM Comptes;

