
------------------------------------------------------------------------
-- This script load the file "matching_result" for Refuges.info dataset
------------------------------------------------------------------------


-- =====================================================================
--  Step 1: import data matching resultst between camptocamp and BDTOPO 
--          from zenodo

-- create a new empty table for the matching results
drop table if exists matching_result_refugeinfos_and_bdtopo;
create table matching_result_refugeinfos_and_bdtopo 
(id_source character varying (50), 
 uri_source character varying (100), 
 type_of_matching_results character varying (100), 
 id_candidat character varying (100),
 uri_candidat character varying (100),
 samal character varying (50)
);

-- import the cvs file into the database, the table just created before
copy matching_result_refugeinfos_and_bdtopo 
from 'ADD_Your_Path_Here\matching_result_RefugesInfo_and_BDTOPO.csv'
--from 'D:\4_CR1\Publications\AGILE\2022 Agile\reproductibility\matching\matching_result_RefugesInfo_and_BDTOPO.csv' 
with delimiter ',' csv header;





