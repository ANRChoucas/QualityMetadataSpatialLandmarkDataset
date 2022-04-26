/*
-- PARC
select pc.uri1, pc.uri2, count (c.*) as n
from ( select distinct u1.uri as uri1, u2.uri as uri2
	   From ( select uri_ref as uri from app_parc_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_parc_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u1,
            ( select uri_ref as uri from app_parc_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_parc_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u2 ) pc
     left outer join app_parc_ign_link1_1 c on pc.uri1 = c.uri_ref and pc.uri2 = c.uri_candidat and  c.validation = 1
group by pc.uri1, pc.uri2 
order by 1 desc,2 desc
*/
/*
-- C2C
select pc.uri1, pc.uri2, count (c.*) as n
from ( select distinct u1.uri as uri1, u2.uri as uri2
	   From ( select uri_ref as uri from app_c2c_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_c2c_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u1,
            ( select uri_ref as uri from app_c2c_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_c2c_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u2 ) pc
     left outer join app_c2c_ign_link1_1 c on pc.uri1 = c.uri_ref and pc.uri2 = c.uri_candidat and  c.validation = 1
group by pc.uri1, pc.uri2 
order by 1 desc,2 desc
*/
/*
-- REF info
select pc.uri1, pc.uri2, count (c.*) as n
from ( select distinct u1.uri as uri1, u2.uri as uri2
	   From ( select uri_ref as uri from app_refinfos_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_refinfos_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u1,
            ( select uri_ref as uri from app_refinfos_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_refinfos_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u2 ) pc
     left outer join app_refinfos_ign_link1_1 c on pc.uri1 = c.uri_ref and pc.uri2 = c.uri_candidat and  c.validation = 1
group by pc.uri1, pc.uri2 
order by 1 desc,2 desc
*/

-- OSM
select pc.uri1, pc.uri2, count (c.*) as n
from ( select distinct u1.uri as uri1, u2.uri as uri2
	   From ( select uri_ref as uri from app_osm_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_osm_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u1,
            ( select uri_ref as uri from app_osm_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from app_osm_ign_link1_1 where validation = 1 and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u2 ) pc
     left outer join app_osm_ign_link1_1 c on pc.uri1 = c.uri_ref and pc.uri2 = c.uri_candidat and  c.validation = 1
group by pc.uri1, pc.uri2 
order by 1 desc,2 desc


