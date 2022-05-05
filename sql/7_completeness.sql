
----------------------------------------------------------------
-- This script computes the excess and Missing items rows 
-- 
----------------------------------------------------------------


-- COLUMN 1 : ALL URI CONCERNED
Select distinct replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') as uri
From ( select uri as uri from c2c union 
       select uri as uri from bdtopo ) g
Order by 1





/*
-- SANS CANDIDAT
Select replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') as uri, count(distinct id) as nb_sans_candidat
From c2c
Where id not in (select distinct id_ref from app_c2c_ign)
Group by replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') 
*/
/*
-- NON APPARIE
Select replace(replace(uri_ref, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') as uri, 
       count (distinct a.id_ref) as nb_non_app
From app_c2c_ign a
Where decision = 'true' 
  and id_candidat = 'NA' 
Group by replace(replace(uri_ref, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') 
*/
/*
-- APPARIEMENT VALIDE
select c.uri_ref, 
       count (c.*) as n
from app_c2c_ign_link1_1 c 
where validation = 1
group by c.uri_ref
order by 1 
*/

/*
-- NON APP
Select replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') as uri, 
       count(distinct id) as nb_sans_candidat
From bdtopo
Where id not in (select distinct id_candidat from app_c2c_ign_link1_1 where validation = 1)
Group by replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', ''), 'http', '') 
*/

/*
-- APPARIEMENT VALIDE
-- select count (c.*) as n
Select c.uri_candidat, count (c.*) as n
From app_c2c_ign_link1_1 c 
Where validation = 1
Group by c.uri_candidat
Order by 1 
*/

