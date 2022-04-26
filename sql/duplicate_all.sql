
select geom, count(*) as n , count(distinct id)
from osm 
group by geom 
order by n desc 


