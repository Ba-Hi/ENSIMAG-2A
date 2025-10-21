CREATE TABLE Navire(
    CodeN INT PRIMARY KEY,
    RayonA NUMERIC CHECK(RayonA > 0),
    NbPilote INT CHECK(NbPilote > 0),
    VitesseM NUMERIC CHECK(VitesseM > 0)
);

CREATE TABLE Pilote(
    CodeP INT PRIMARY KEY,
    Prenom varchar(30) NOT NULL,
    Nom varchar(30) NOT NULL,
    Age INT CHECK(Age>=18),
    Grade INT CHECK(Grade > 0)
); 

CREATE TABLE Equipage(
    CodeEq INT PRIMARY KEY,
    Effectif INT CHECK(Effectif > 0)
);

CREATE TABLE Mission(
    CodeM INT PRIMARY KEY,
    DateM Date,
    NbV INT CHECK(NbV > 0),
    VitesseMinBat NUMERIC CHECK(VitesseMinBat > 0),
    RayonE NUMERIC CHECK(RayonE > 0)
);


CREATE TABLE Milieu(
    CompoM VARCHAR(10) PRIMARY KEY CONSTRAINT CmilieuIN CHECK(CompoM IN ('acide', 'basique', 'neutre'))
);

CREATE TABLE TypeM(
    CodeTypeM VARCHAR(20) PRIMARY KEY CONSTRAINT CcodeTypeM CHECK(CodeTypeM IN ('Transport', 'Combat', 'Pillage', 'Interception'))
);

CREATE TABLE Galaxie(
    CodeGalaxie INT PRIMARY KEY,
    NomGalaxie VARCHAR(30) NOT NULL,
    DistanceGalaxie NUMERIC CHECK(DistanceGalaxie > 0)
);


---------------- SOUS TYPES D'ENTITÉS SIMPLES -----------------

CREATE TABLE NavireTransport(
    CodeN INT PRIMARY KEY,
    CONSTRAINT fk_NT_navire FOREIGN KEY (CodeN)
    REFERENCES Navire(CodeN)
    ON DELETE Cascade,
    Cap NUMERIC CHECK(Cap > 0)
);


CREATE TABLE NavireCombat(
    CodeN INT PRIMARY KEY,
    CONSTRAINT fk_NC_navire FOREIGN KEY (CodeN)
    REFERENCES Navire(CodeN)
    ON DELETE Cascade,
    EqMin INT CHECK(EqMin > 0),
    EqMax INT CHECK(EqMax > 0),
    CONSTRAINT Cordre CHECK(EqMin < EqMax)
);


------------------------- ENTITTÉS FAIBLES ----------------------

CREATE TABLE Planete(
    CodeGalaxie INT,
    CONSTRAINT fk_codeG FOREIGN KEY (CodeGalaxie)
    REFERENCES Galaxie(CodeGalaxie)
    ON DELETE Cascade,
    CodePlanete INT UNIQUE NOT NULL,
    NomPlanete VARCHAR(30) NOT NULL,
    VitesseL NUMERIC CHECK(VitesseL > 0),
    Statut VARCHAR(20) CHECK(Statut IN ('non explorée', 'reconnue', 'integrée à lincal'))
);


