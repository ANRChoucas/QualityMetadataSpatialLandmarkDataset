
----------------------------------------------------------------
-- This script computes the NonQuantitativeAttributeAccuracy measures 
-- Mean Samal Distance; RootMeanSquareError all Samal Distance; Agreement Rate SamalDistance
----------------------------------------------------------------

-- Compute the NonQuantitativeAttributeAccuracy measures

--it computes the mean Samal distance for all sources 
select avg(samal::numeric) from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated'


--it computes the root mean square error Samal distance for all sources 
select sqrt(avg(power(samal::numeric, 2.0))) as accuracy_name from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated'


-- it computes the mean Samal distance for all sources and for LANDFORME types 
select avg(samal::numeric) from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' and uri_source in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')


-- it computes the root mean square error Samal distance for all sources and for LANDFORME types 
select sqrt(avg(power(samal::numeric, 2.0))) as accuracy_name from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated'  and uri_ref in ('gouffre', 'aven', 'grotte', 'caverne', 'cirque', 'vallée', 'gorge', 'ravin', 'arête', 'crête', 'aiguille', 'pic', 'sommet', 'rocher', 'plaine', 'versant', 'ravin', 'col')


-- it computes the agreement rate for all the sources :
Select (agreement.na/total.nb :: numeric)*100 as agreement_rate_camptocamp_org
From (select count(*) as nb from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated') as total,
     (select count (*) as na from matching_result_Camptocamp_and_bdtopo where type_of_matching_results = '1:1 validated' and samal::numeric <= 0.1) as agreement


	
	 
	
