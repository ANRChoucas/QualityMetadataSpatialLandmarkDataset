

----------------------------------------------------------------
-- This script computes the duplicate measure
-- It shows an example for one datasources (i.e. Camptocamp) 
----------------------------------------------------------------

select geom, count(*) as n , count(distinct id)
from dataset_camptocamp_org 
group by geom 
having count(*) > 1
order by n desc 



