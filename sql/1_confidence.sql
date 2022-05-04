
----------------------------------------------------------------
-- This script computes the confidence measure (DQ_confidence)
-- It shows an example for one datasources (i.e. Camptocamp) 
----------------------------------------------------------------


-- =====================================================================
-- Step 1: import camptocamp dataset from zenodo
-- create a new empty table for the camptocamp dataset
drop table if exists dataset_camptocamp_org;
create table dataset_camptocamp_org 
(id character varying (50), nom character varying (100), type character varying (50),geom character varying (100));

-- import the cvs file into the database, the table just created before
copy dataset_camptocamp_org 
from 'ADD_Your_Path_Here\Dataset_Camptocamp_org.csv.csv' 
--from 'D:\4_CR1\Publications\AGILE\2022 Agile\reproductibility\datasets\Dataset_Camptocamp_org.csv' - supprimer ICI
with delimiter ',' csv header;


-- =====================================================================
-- Step 2: import data matching resultst between camptocamp and BDTOPO 
--         from zenodo
-- create a new empty table for the matching results
drop table if exists matching_result_Camptocamp_and_bdtopo;
create table matching_result_Camptocamp_and_bdtopo 
(id_source character varying (50), 
 uri_source character varying (100), 
 type_of_matching_results character varying (100), 
 id_candidat character varying (100),
 uri_candidat character varying (100),
 samal character varying (50)
);

--import the cvs file into the database, the table just created before
copy matching_result_Camptocamp_and_bdtopo 
from 'ADD_Your_Path_Here\matching_result_Camptocamp_and_BDTOPO.csv'
--from 'D:\4_CR1\Publications\AGILE\2022 Agile\reproductibility\matching\matching_result_Camptocamp_and_BDTOPO.csv' -suprimmer ICI
with delimiter ',' csv header;


-- =====================================================================
-- Step 3: import the alignement file representing the semantic alignement 
--         between camptocamp types features and OOR concepts
-- create a new empty table for the camptocamp dataset
drop table if exists alignment_camptocamp_oor;
create table alignment_camptocamp_oor 
(type character varying (50), uri character varying (100));

-- import the cvs file into the database, the table juste created before
copy alignment_camptocamp_oor 
from 'ADD_Your_Path_Here\matching_result_Camptocamp_and_BDTOPO.csv'
--from 'D:\4_CR1\Publications\AGILE\2022 Agile\reproductibility\alignements\Alignment_Camptocamp_OOR.csv' -suprimmer ICI
with delimiter ',' csv header;

--add the uri to the initial data source
alter table dataset_camptocamp_org add column uri character varying (100);
update dataset_camptocamp_org a set uri= (select uri from alignment_camptocamp_oor b where a.type=b.type)


-- =====================================================================
-- STEP 4 : compute the confidence measure; three cases are given as example : 
-- (1) for all the scop; (2) for ISOLATED ACCOMODATION and (3) for LANDFORM

---------------------------------------------------------------------------------
-- ALL
-- it computes the DQ_confidence for all the scope
-- this result is associated with the metadata file "ADD THE NAME OF THE FILE"
---------------------------------------------------------------------------------
Select round(100.0 - ((conflit.na + wrongmatch.wm)/total.nb :: numeric)*100, 0) as confidence
From (select count(*) as nb from dataset_camptocamp_org) as total,
     (select count(distinct(id_source)) as na from matching_result_Camptocamp_and_bdtopo where type_of_matching_results ='uncertain') as conflit,
	 (select count(*) as wm from matching_result_Camptocamp_and_bdtopo where type_of_matching_results='1:1 non validated') as wrongmatch;

---------------------------------------------------------------------------------
-- ISOLATED ACCOMODATION - 
-- It computes the DQ_confidence for a subset of the types 
-- This is an example for on demand metadata; for example if the user needs to assess only the confidence of the matching algorithm for 
-- a specific types of landmarks (e.g. those corresponding the the ontology class "isolated accomodation") 
-- this result is associated with the metadata file "ADD THE NAME OF THE FILE"
---------------------------------------------------------------------------------
Select round(100.0 - ((conflit.na + wrongmatch.wm)/total.nb :: numeric)*100, 0) as confidence
From (  select count(*) as nb 
	    from dataset_camptocamp_org 
	    where replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') 
	 ) as total,
     (  select count(distinct(id_source)) as na 
	    from matching_result_Camptocamp_and_bdtopo 
	  	where type_of_matching_results ='uncertain'
	      and replace(replace(uri_source, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') 
	 ) as conflit,
	 ( select count(*) as wm 
	   from matching_result_Camptocamp_and_bdtopo 
	   where type_of_matching_results='1:1 non validated'
	     and uri_source in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') 
	 ) as wrongmatch;
	 
---------------------------------------------------------------------------------
-- LANDFORM
-- It computes the DQ_confidence for a subset of the types 
-- This is an example for on demand metadata; for example if the user needs to assess only the confidence of the matching algorithm for 
-- a specific types of landmarks (e.g. those corresponding the the ontology class "landform") 
-- this result is associated with the metadata file "ADD THE NAME OF THE FILE"
---------------------------------------------------------------------------------
Select round(100.0 - ((conflit.na + wrongmatch.wm)/total.nb :: numeric)*100, 0) as confidence
From (  select count(*) as nb 
	    from dataset_camptocamp_org 
	    where replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
	 ) as total,
     (  select count(distinct(id_source)) as na 
	    from matching_result_Camptocamp_and_bdtopo 
	  	where type_of_matching_results ='uncertain'
	      and replace(replace(uri_source, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
	 ) as conflit,
	 ( select count(*) as wm 
	   from matching_result_Camptocamp_and_bdtopo 
	   where type_of_matching_results='1:1 non validated'
	     and uri_source in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
	 ) as wrongmatch;


