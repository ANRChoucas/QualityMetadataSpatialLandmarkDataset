----------------------------------------------------------------
-- This script computes the confidence measure (DQ_confidence)
-- It shows an example for one datasources (i.e. Camptocamp) 
----------------------------------------------------------------

-- =====================================================================
-- STEP 1 : compute the MeanAdsolute2D, RootMeanSquareError, and AgreementRate Threshold rows measure; 
-- three cases are given as example : 
-- (1) for all the scop; 
-- (2) for ISOLATED ACCOMODATION and 
-- (3) for LANDFORM

---------------------------------------------------------------------------------
-- ALL
-- it computes the DQ_confidence for all the scope
-- this result is associated with the metadata file "ADD THE NAME OF THE FILE"
---------------------------------------------------------------------------------
-- MeanAdsolute2D
select avg(st_length(ST_MakeLine(c.geom, b.geom)))as mean 
from matching_result_camptocamp_and_bdtopo m
     inner join dataset_camptocamp_org c on c.id = m.id_source
	 inner join dataset_bdtopo_org b on b.id = m.id_candidat
where type_of_matching_results = '1:1 validated';

-- RootMeanSquareError
select sqrt(avg(power(st_length(ST_MakeLine(c.geom, b.geom)), 2.0))) as accuracy 
from matching_result_camptocamp_and_bdtopo m
     inner join dataset_camptocamp_org c on c.id = m.id_source
	 inner join dataset_bdtopo_org b on b.id = m.id_candidat
where type_of_matching_results = '1:1 validated';

-- AgreementRate Threshold
select 1.0 * count(*) / (select count(*) from matching_result_camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' ) 
from matching_result_camptocamp_and_bdtopo m
     inner join dataset_camptocamp_org c on c.id = m.id_source
	 inner join dataset_bdtopo_org b on b.id = m.id_candidat
where type_of_matching_results = '1:1 validated' 
  and st_length(ST_MakeLine(c.geom, b.geom)) <= 30 ;


---------------------------------------------------------------------------------
-- ISOLATED ACCOMODATION - 
-- It computes the DQ_confidence for a subset of the types 
-- This is an example for on demand metadata; for example if the user needs to assess only the confidence of the matching algorithm for 
-- a specific types of landmarks (e.g. those corresponding the the ontology class "isolated accomodation") 
-- this result is associated with the metadata file "ADD THE NAME OF THE FILE"
---------------------------------------------------------------------------------
-- MeanAdsolute2D
select avg(st_length(ST_MakeLine(c.geom, b.geom)))as mean 
from matching_result_camptocamp_and_bdtopo m
     inner join dataset_camptocamp_org c on c.id = m.id_source
	 inner join dataset_bdtopo_org b on b.id = m.id_candidat
where type_of_matching_results = '1:1 validated'
  and uri_source in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine');

-- RootMeanSquareError
select sqrt(avg(power(st_length(ST_MakeLine(c.geom, b.geom)), 2.0))) as accuracy 
from matching_result_camptocamp_and_bdtopo m
     inner join dataset_camptocamp_org c on c.id = m.id_source
	 inner join dataset_bdtopo_org b on b.id = m.id_candidat
where type_of_matching_results = '1:1 validated'
  and uri_source in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine');


---------------------------------------------------------------------------------
-- LANDFORM
-- It computes the DQ_confidence for a subset of the types 
-- This is an example for on demand metadata; for example if the user needs to assess only the confidence of the matching algorithm for 
-- a specific types of landmarks (e.g. those corresponding the the ontology class "landform") 
-- this result is associated with the metadata file "ADD THE NAME OF THE FILE"
---------------------------------------------------------------------------------
-- MeanAdsolute2D
select avg(st_length(ST_MakeLine(c.geom, b.geom)))as mean 
from matching_result_camptocamp_and_bdtopo m
     inner join dataset_camptocamp_org c on c.id = m.id_source
	 inner join dataset_bdtopo_org b on b.id = m.id_candidat
where type_of_matching_results = '1:1 validated'
  and uri_source in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 
					 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
					 
-- RootMeanSquareError
select sqrt(avg(power(st_length(ST_MakeLine(c.geom, b.geom)), 2.0))) as accuracy 
from matching_result_camptocamp_and_bdtopo m
     inner join dataset_camptocamp_org c on c.id = m.id_source
	 inner join dataset_bdtopo_org b on b.id = m.id_candidat
where type_of_matching_results = '1:1 validated'
  and uri_source in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 
					 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')




