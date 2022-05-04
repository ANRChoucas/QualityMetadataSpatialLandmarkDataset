
----------------------------------------------------------------
-- This script computes the confusion matrix 
-- It shows an example for one datasources (i.e. Camptocamp) 
----------------------------------------------------------------

-- compute the confusion matrix  

-- MATRICE CONFUSION C2C

---------------------------------------------------------------------------------
-- ALL
select pc.uri1, pc.uri2, count (c.*) as n
from ( select distinct u1.uri as uri1, u2.uri as uri2
	   From ( select uri_source as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' union 
              select uri_candidat as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated') as u1,
            ( select uri_source as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' union 
              select uri_candidat as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated') as u2 ) pc
     left outer join matching_result_Camptocamp_and_bdtopo c on pc.uri1 = c.uri_source and pc.uri2 = c.uri_candidat and  c.type_of_matching_results = '1:1 validated' 
group by pc.uri1, pc.uri2 
order by 1 desc,2 desc


---------------------------------------------------------------------------------
-- ISOLATED ACCOMODATION 

select pc.uri1, pc.uri2, count (c.*) as n
from ( select distinct u1.uri as uri1, u2.uri as uri2
	   From ( select uri_source as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' and uri_source in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u1,
            ( select uri_source as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' and uri_source in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') union 
              select uri_candidat as uri from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' and uri_candidat in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')) as u2 ) pc
     left outer join matching_result_Camptocamp_and_bdtopo c on pc.uri1 = c.uri_source and pc.uri2 = c.uri_candidat and  c.type_of_matching_results = '1:1 validated' 
group by pc.uri1, pc.uri2 
order by 1 desc,2 desc
