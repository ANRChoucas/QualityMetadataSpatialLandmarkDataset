
----------------------------------------------------------------
-- This script load the 3 files for camptocamp dataset
----------------------------------------------------------------


-- =====================================================================
--  Step 1: import camptocamp dataset from zenodo
--

-- create a new empty table for the camptocamp dataset
drop table if exists dataset_camptocamp_org;
create table dataset_camptocamp_org 
(id character varying (50), nom character varying (100), 
type character varying (50),geom character varying (100));

-- import the cvs file into the database, the table just created before
copy dataset_camptocamp_org 
from 'ADD_Your_Path_Here\Dataset_Camptocamp_org.csv' 
--from 'D:\4_CR1\Publications\AGILE\2022 Agile\reproductibility\datasets\Dataset_Camptocamp_org.csv' 
with delimiter ',' csv header;


-- =====================================================================
--  Step 2: import data matching resultst between camptocamp and BDTOPO 
--          from zenodo

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

-- import the cvs file into the database, the table just created before
copy matching_result_Camptocamp_and_bdtopo 
from 'ADD_Your_Path_Here\matching_result_Camptocamp_and_BDTOPO.csv'
--from 'D:\4_CR1\Publications\AGILE\2022 Agile\reproductibility\matching\matching_result_Camptocamp_and_BDTOPO.csv' 
with delimiter ',' csv header;


-- =====================================================================
--  Step 3: import the alignement file representing the semantic alignement 
--          between camptocamp types features and OOR concepts

-- create a new empty table for the camptocamp dataset
drop table if exists alignment_camptocamp_oor;
create table alignment_camptocamp_oor 
(type character varying (50), uri character varying (100));

-- import the cvs file into the database, the table juste created before
copy alignment_camptocamp_oor 
from 'ADD_Your_Path_Here\Alignment_Camptocamp_OOR.csv'
--from 'D:\4_CR1\Publications\AGILE\2022 Agile\reproductibility\alignements\Alignment_Camptocamp_OOR.csv' 
with delimiter ',' csv header;

-- add the uri to the initial data source
alter table dataset_camptocamp_org add column uri character varying (100);
update dataset_camptocamp_org a set uri= (select uri from alignment_camptocamp_oor b where a.type=b.type)

-- simplify uri


-- geometry

