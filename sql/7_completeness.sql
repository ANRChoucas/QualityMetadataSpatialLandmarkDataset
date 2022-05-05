
----------------------------------------------------------------
-- This script computes the excess and Missing items rows 
-- 
----------------------------------------------------------------


-- COLUMN 1 : ALL URI CONCERNED
Select distinct replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') as uri
From ( select uri as uri from dataset_camptocamp_org union 
       select uri as uri from dataset_bdtopo_org ) g
Order by 1


-- COLUMN 2 : Without candidates - CAMPTOCAMP
Select uri, count(distinct id) as nb_sans_candidat
From dataset_camptocamp_org
Where id not in ( select distinct id_source 
                  from matching_result_camptocamp_and_bdtopo 
                  where type_of_matching_results = '1:1 validated' 
				    or type_of_matching_results = '1:1 non validated'
				    or type_of_matching_results = '1:0'
				    or type_of_matching_results = 'uncertain')
Group by uri;

-- COLUMN 3 : [1:0] - CAMPTOCAMP
Select uri_source, count (distinct a.id_source) as nb_non_app
From matching_result_camptocamp_and_bdtopo a
Where type_of_matching_results = '1:0'
Group by uri_source


-- COLUMN 4 : [1:1] - CAMPTOCAMP
select c.uri_source, count (c.*) as n
from matching_result_camptocamp_and_bdtopo c 
where type_of_matching_results = '1:1 validated' 
group by c.uri_source
order by 1 ;


-- COLUMN 5 : TOTAL Completeness
-- Do in excel, COLUMN 2 + COLUMN 3 + COLUMN 4


-- COLUMN 6 : Without candidates - BDTOPO
Select uri, count(distinct id) as nb_sans_candidat
From dataset_bdtopo_org
Where id not in ( select distinct id_candidat 
                  from matching_result_camptocamp_and_bdtopo 
                  where type_of_matching_results = '1:1 validated')
Group by uri


-- COLUMN 7 : [1:1] - BDTOPO
Select c.uri_candidat, count (c.*) as n
From matching_result_camptocamp_and_bdtopo c 
Where type_of_matching_results = '1:1 validated'
Group by c.uri_candidat
Order by 1 


-- COLUMN 8 : TOTAL Completeness
-- Do in excel, COLUMN 6 + COLUMN 7




