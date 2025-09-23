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

-- Q6 :
SELECT DISTINCT Guests.NCl, NomCl
FROM GUESTS, Bookings, Resorts, Rooms
WHERE guests.NCL = bookings.NCL
      AND bookings.NS = rooms.NS
      AND bookings.NH = rooms.NH
      AND bookings.NCH = rooms.NCH
      AND Resorts.NS = Rooms.NS
      AND resorts.types LIKE 'mer'
      AND rooms.typch LIKE 'D';
      
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
      AND r1. NH = r2.NH
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






