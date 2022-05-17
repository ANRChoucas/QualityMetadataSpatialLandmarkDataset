
-------------------------------------------------------------------
-- This script returns all samal distance for all matching links
-- It shows an example for one datasources (i.e. Refuges.Info)
-------------------------------------------------------------------

Select samal 
From matching_result_refugeinfos_and_bdtopo 
where type_of_matching_results = '1:1 validated'

