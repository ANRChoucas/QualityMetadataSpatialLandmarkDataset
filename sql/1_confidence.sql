
----------------------------------------------------------------
-- This script computes the confidence measure (DQ_confidence)
-- It shows an example for one datasources (i.e. Camptocamp) 
----------------------------------------------------------------


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


