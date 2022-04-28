
------------------------------------------------------
--  Camptocamp
/*
-- ALL
Select round(100 - ((conflit.na + wrongmatch.wm)/total.nb :: numeric)*100, 0) as confidence
From (select count(*) as nb from c2c) as total,
     (select count(distinct(id_ref)) as na from app_c2c_ign where decision ='indécis') as conflit,
	 (select count(*) as wm from app_c2c_ign_link1_1 where validation=0) as wrongmatch;
*/
/*
-- ISOLATED ACCOMODATION
Select round(100 - ((conflit.na + wrongmatch.wm)/total.nb :: numeric)*100, 0) as confidence
From (  select count(*) as nb 
	    from c2c 
	    where replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') 
	 ) as total,
     (  select count(distinct(id_ref)) as na 
	    from app_c2c_ign 
	    where decision = 'indécis'
	      and replace(replace(uri_ref, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') 
	 ) as conflit,
	 ( select count(*) as wm 
	   from app_c2c_ign_link1_1 
	   where validation = 0
	     and uri_ref in ('abri', 'bergerie', 'cabane', 'fort', 'refuge', 'ruine') 
	 ) as wrongmatch;
*/
/*
-- LANDFORM
Select round(100 - ((conflit.na + wrongmatch.wm)/total.nb :: numeric)*100, 0) as confidence
From (  select count(*) as nb 
	    from c2c 
	    where replace(replace(uri, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
	 ) as total,
     (  select count(distinct(id_ref)) as na 
	    from app_c2c_ign 
	    where decision = 'indécis'
	      and replace(replace(uri_ref, 'http://purl.org/choucas.ign.fr/oor#', '') , 'http', '') in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
	 ) as conflit,
	 ( select count(*) as wm 
	   from app_c2c_ign_link1_1 
	   where validation = 0
	     and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')
	 ) as wrongmatch;
*/


