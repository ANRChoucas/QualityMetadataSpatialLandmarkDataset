
----------------------------------------------------------------
-- This script computes the missing class 'nom' measures 
-- 
----------------------------------------------------------------

-- Camptocamp
-- select * from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated';

select (1 - count(*) )
from matching_result_Camptocamp_and_bdtopo m
inner join dataset_camptocamp_org c on c.id = m.id_source
where type_of_matching_results = '1:1 validated'
  and c.nom is null

-- select * from app_c2c_ign_link1_1 where validation = '1' and nom_candidat is null 

-- 100% Toponym completeness for both c2c and bdtopo; 
