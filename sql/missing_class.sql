
-- Camptocamp
select * from app_c2c_ign_link1_1 where validation = '1' 
select * from app_c2c_ign_link1_1 where validation = '1' and nom_ref is null
select * from app_c2c_ign_link1_1 where validation = '1' and nom_ref is not null
select * from app_c2c_ign_link1_1 where validation = '1' and nom_candidat is null 
select * from app_c2c_ign_link1_1 where validation = '1' and nom_candidat is not null 
-- 100% Toponym completeness for both c2c and bdtopo; 