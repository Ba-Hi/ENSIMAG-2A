-- Q1 :
SELECT ns, noms, capch, types 
FROM resorts
WHERE types LIKE 'montagne';

-- Q2 :
SELECT NH, NomH, AdrH, TelH, CatH
FROM Hotels h, RESORTS r
WHERE h.NS = r.NS AND r.TypeS LIKE 'mer';

-- Q3 :
SELECT DISTINCT nomS
FROM Hotels h, RESORTS r
WHERE h.NS = r.NS 
      AND r.TypeS LIKE 'mer'
      AND h.CatH = 4;
      
-- Q4 :
SELECT DISTINCT NomCl, AdrCl
FROM GUESTS g, BOOKINGS b, RESORTS r
WHERE g.NCL = b.NCL
       AND b.NS = r.NS
       AND r.TypeS LIKE 'montagne';
       
-- Q5 :
SELECT DISTINCT rooms.NS, rooms.NH, rooms.NCh, rooms.prix
FROM rooms, hotels, resorts
WHERE hotels.CatH = 2
      AND resorts.TypeS LIKE 'montagne'
      AND rooms.Prix < 50
      AND rooms.NS = hotels.NS
      AND rooms.NH = hotels.NH
      AND resorts.NS = rooms.ns;

-- Q6 : *****
SELECT DISTINCT Guests.NCl, NomCl
FROM GUESTS, Bookings, Resorts, Rooms
WHERE guests.NCL = bookings.NCL
      AND bookings.NS = rooms.NS
      AND bookings.NH = rooms.NH
      AND bookings.NCH = rooms.NCH
      AND Resorts.NS = Rooms.NS
      AND resorts.types LIKE 'mer'
      AND rooms.typch IN ('D','DWC');
      
-- Q7 :
SELECT DISTINCT NomCl
From Hotels, Guests
WHERE AdrCl = AdrH;

-- Q8 :
SELECT hotels.NS, hotels.NH
FROM Hotels, rooms
WHERE CatH = 4
      AND Hotels.NS = Rooms.NS
      AND Hotels.NH = Rooms.NH
MINUS
SELECT hotels.NS, hotels.NH
FROM Hotels, rooms
WHERE CatH = 4
      AND Hotels.NS = Rooms.NS
      AND Hotels.NH = Rooms.NH
      AND rooms.TypCh NOT LIKE 'SDB';
      
-- Q9 :
SELECT DISTINCT h.nh, h.ns, h.nomh, h.adrH, h.cath
FROM hotels h, rooms r1, rooms r2
WHERE r1.NS = r2.NS
      AND r1.NH = r2.NH
      AND r1.NCH != r2.NCH
      AND r1.prix = r2.prix
      AND r1.NS = h.NS
      AND r1.NH = h.NH;
      
-- Q10 :
SELECT DISTINCT h.ns, h.nh, h.NomH, h.AdrH, h.CatH, count(*)
FROM hotels h, bookings b
WHERE h.ns = b.ns(+)
      AND h.nh = b.nh(+)
GROUP BY h.ns, h.nh, h.NomH, h.AdrH, h.CatH;

-- OU BIEN !!! :
SELECT DISTINCT h.ns, h.nh, h.NomH, h.AdrH, h.CatH, count(*)
FROM hotels h, bookings b
WHERE h.ns = b.ns
      AND h.nh = b.nh
GROUP BY h.ns, h.nh, h.NomH, h.AdrH, h.CatH
UNION
(SELECT h.ns, h.nh, h.NomH, h.AdrH, CatH, 0 AS NbReservation -- + même schéma
FROM hotels h
WHERE (h.ns, h.nh) NOT IN (SELECT DISTINCT ns, nh FROM Bookings)
);
-- Chercher les hotels not in booking + même schéma

-- Q11 :
SELECT h.ns,h.nh, h.adrH, h.nomh
FROM hotels h, resorts re, bookings b
WHERE re.noms LIKE 'Chamonix'
      AND h.ns = re.ns
      AND h.ns = b.ns
      AND h.nh = b.nh
      AND b.ncl != 0
GROUP BY h.adrH, h.nomh, h.ns, h.nh
HAVING count(*) = ( -- count(b.ncl) suffit)
SELECT max(count(*))
FROM hotels h, resorts re, bookings b
WHERE re.noms LIKE 'Chamonix'
      AND h.ns = re.ns
      AND h.ns = b.ns
      AND h.nh = b.nh
      AND b.ncl != 0
GROUP BY h.adrH, h.nomh, h.ns, h.nh
);

-- OU BIEN !!
SELECT h.ns,h.nh, h.adrH, h.nomh
FROM hotels h, resorts re, bookings b
WHERE re.noms LIKE 'Chamonix'
      AND h.ns = re.ns
      AND h.ns = b.ns
      AND h.nh = b.nh
      AND b.ncl != 0
GROUP BY h.adrH, h.nomh, h.ns, h.nh
HAVING count(*) >= ALL
(SELECT count(*)
FROM hotels h, resorts re, bookings b
WHERE re.noms LIKE 'Chamonix'
      AND h.ns = re.ns
      AND h.ns = b.ns
      AND h.nh = b.nh
      AND b.ncl != 0
GROUP BY h.adrH, h.nomh, h.ns, h.nh
);


-- Q12 :
SELECT b.jour
FROM hotels h, resorts re, bookings b
WHERE re.noms LIKE 'Chamonix'
      AND h.nomh LIKE '%Bon S��jour%'
      AND h.ns = re.ns
      AND h.ns = b.ns
      AND h.nh = b.nh
      AND b.ncl != 0
GROUP BY b.jour
HAVING count(*) = (
SELECT max(count(*))
FROM hotels h, resorts re, bookings b
WHERE re.noms LIKE 'Chamonix'
      AND h.nomh LIKE '%Bon S��jour%'
      AND h.ns = re.ns
      AND h.ns = b.ns
      AND h.nh = b.nh
      AND b.ncl != 0
GROUP BY b.jour)
;

-- Q13 :
SELECT DISTINCT h.nh, h.ns, h.nomh, h.adrh, h.cath
FROM Hotels h, Rooms r
WHERE h.ns = r.ns
      AND h.nh = r.nh
MINUS
(SELECT DISTINCT h.nh, h.ns, h.nomh, h.adrh, h.cath
FROM Hotels h, Rooms r
WHERE h.ns = r.ns
      AND h.nh = r.nh
      AND r.prix >= 40
);

-- Q14 :
SELECT MIN(ro.prix) AS prix_min
FROM Hotels h, Resorts re, Rooms ro
WHERE h.cath = 3
      AND re.types LIKE 'mer'
      AND h.ns = re.ns
      AND h.ns = ro.ns
      AND h.nh = ro.nh;
      
      
-- Q15 :
-- R ÷ S = πA(R) − πA( ( πA(R) × S ) − R )


-- Q16 :
SELECT DISTINCT nomCl
FROM guests g, Bookings b1, Bookings b2, Bookings b3
WHERE g.NCl = b1.NCl
      AND b1.NCl = b2.NCl
      AND b2.NCl = b3.NCl -- meme Client
      AND b1.NCH = b2.NCH
      AND b2.NCH = b3.NCH -- meme chambre
      AND b1.NH = b2.NH
      AND b2.NH = b3.NH -- meme Hotel
      AND b1.NS = b2.NS
      AND b2.NS = b3.NS -- meme station
      AND b1.jour = b2.jour + 1
      AND b1.jour = b3.jour + 2
;
