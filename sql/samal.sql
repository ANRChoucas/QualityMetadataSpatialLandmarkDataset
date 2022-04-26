
select avg(samal) from app_c2c_ign_link1_1 where validation = 1 
select avg(samal) from app_refinfos_ign_link1_1 where validation = 1 
select avg(samal) from app_parc_ign_link1_1 where validation = 1 
select avg(samal) from app_osm_ign_link1_1 where validation = 1 

select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_c2c_ign_link1_1 where validation = 1
select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_refinfos_ign_link1_1 where validation = 1
select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_parc_ign_link1_1 where validation = 1
select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_osm_ign_link1_1 where validation = 1

select avg(samal) from app_c2c_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
select avg(samal) from app_refinfos_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
select avg(samal) from app_parc_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
select avg(samal) from app_osm_ign_link1_1 where validation = 1 and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')


select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_c2c_ign_link1_1 where validation = 1  and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_refinfos_ign_link1_1 where validation = 1  and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_parc_ign_link1_1 where validation = 1  and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
select sqrt(avg(power(samal, 2.0))) as accuracy_name from app_osm_ign_link1_1 where validation = 1  and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')



select count (*) as agreement from app_parcs_ign_link1_1 where validation = 1 and samal <= 0.1 
select (179/251 :: numeric)*100 -- 71.31%