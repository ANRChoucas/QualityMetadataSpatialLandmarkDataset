# QualityMetadataSpatialLandmarkDataset

This project contains two procedures to reproduce the results of the paper *M.-D. Van Damme, A.-M. Olteanu Raimond A method to produce metadata describing 
and assessing the quality of spatial landmark datasets in mountain area*

<!-- Metadata describing and assessing the quality of spatial landmark datasets in mountain area. -->



> README Contents
> - [Development & Contributions](#Development-&-Contributions)
> - [Procedure n°1 to reproduce data matching and then to have the results of a section of table 3](#procedure-n1-to-reproduce-data-matching-and-then-to-have-the-results-of-a-section-of-table-3)
> - [Procedure n°2 to reproduce table 3 (row Uncertainty) and table 4 ](#procedure-n2-to-reproduce-table-3-row-uncertainty-and-table-4)
>     * [Reproduction of the row **Uncertainty** of table 3](#reproduction-of-the-row-uncertainty-of-table-3)
>     * [Reproduction of table 4](#reproduction-of-table-4)

# Development & Contributions
* Institute: LASTIG, Univ Gustave Eiffel, ENSG, IGN
* License: Cecill-C
* Authors:
	- Marie-Dominique Van Damme
	- Ana-Maria Raimond

<br/>

# Procedure n°1 to reproduce data matching and then to have the results of a section of table 3

1. Input ressourcesSource material:

The six dataset files : "Five spatial landmark datasets" downloaded on the plateform Zenodo (version 1.0)
The five files : "Alignment between type of landmark in different sources and the concept in the spatial reference objects ontology" on the plateform Zenodo (version 1.0)

Installation of the Java project “QualityMetadataSpatialLandmarkDataset”. See the readme:
https://github.com/ANRChoucas/QualityMetadataSpatialLandmarkDataset. There is not need You don’t need to install MultiCriteriaMatching code. It is a depedency library of the project  QualityMetadataSpatialLandmarkDataset (maven project). 


<br/>

# Procedure n°2 to reproduce table 3 (row Uncertainty) and table 4 

## Reproduction of the row **Uncertainty** of table 3

- Input data : 
	* initial dataset (e.g. dataset_camptocamp_org)
	* data matching links results (e.g. matching_result_Camptocamp_and_BDTOPO.csv )
	* alignement file between the dataset and the OOR ontology (e.g. alignment_camptocamp_oor)
- Code : sql file
```sh
sql/1_confidence.sql
```
- Coding environnement: PostGreSQL/POSTGIS
- Steps to follow
	* Step 1: create a database in PostGreSQL (e.g. agile_metadata_2022)
	* Step 2: install postgis extension for this new database (see Extension menu)
	* Step 3: 
		- Import all the needed data in the postgres database: run SCRIPT.sql
		- run the script 1_confidence.sql



## Reproduction of table 4
