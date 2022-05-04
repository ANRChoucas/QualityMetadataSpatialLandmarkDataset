/*
-- C2C
select avg(st_length(geom))as mean from app_c2c_ign_link1_1  where validation = 1 
select avg(st_length(geom))as mean from app_c2c_ign_link1_1  where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select avg(st_length(geom))as mean from app_c2c_ign_link1_1  where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_c2c_ign_link1_1 where validation = 1
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_c2c_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_c2c_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select 1.0 * count(*) / (select count(*) from app_c2c_ign_link1_1 where validation = 1) from app_c2c_ign_link1_1 where validation = 1 and st_length(geom) <= 30 
*/

/*
-- REFINFO
select avg(st_length(geom))as mean from app_refinfos_ign_link1_1  where validation = 1 
select avg(st_length(geom))as mean from app_refinfos_ign_link1_1  where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select avg(st_length(geom))as mean from app_refinfos_ign_link1_1  where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_refinfos_ign_link1_1 where validation = 1
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_refinfos_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_refinfos_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select 1.0 * count(*) / (select count(*) from app_refinfos_ign_link1_1 where validation = 1) from app_refinfos_ign_link1_1 where validation = 1 and st_length(geom) <= 30 
*/
/*
-- PARC
select avg(st_length(geom))as mean from app_parc_ign_link1_1  where validation = 1 
select avg(st_length(geom))as mean from app_parc_ign_link1_1  where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select avg(st_length(geom))as mean from app_parc_ign_link1_1  where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_parc_ign_link1_1 where validation = 1
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_parc_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_parc_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select 1.0 * count(*) / (select count(*) from app_parc_ign_link1_1 where validation = 1) from app_parc_ign_link1_1 where validation = 1 and st_length(geom) <= 30 
*/


-- OSM
select avg(st_length(geom))as mean from app_osm_ign_link1_1  where validation = 1 
select avg(st_length(geom))as mean from app_osm_ign_link1_1  where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select avg(st_length(geom))as mean from app_osm_ign_link1_1  where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_osm_ign_link1_1 where validation = 1
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_osm_ign_link1_1 where validation = 1 and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine')
select sqrt(avg(power(st_length(geom), 2.0))) as accuracy from app_osm_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')

select 1.0 * count(*) / (select count(*) from app_osm_ign_link1_1 where validation = 1) from app_osm_ign_link1_1 where validation = 1 and st_length(geom) <= 30 

