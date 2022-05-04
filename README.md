# QualityMetadataSpatialLandmarkDataset

This project contains two procedures to reproduce the results of the paper *A method to produce metadata describing 
and assessing the quality of spatial landmark datasets in mountain area, M.-D. Van Damme, A.-M. Olteanu Raimond*

<!-- Metadata describing and assessing the quality of spatial landmark datasets in mountain area. -->



> README Contents
> - [Development & Contributions](#Development-&-Contributions)
> - [Procedure n°1 to reproduce table 3 (row Uncertainty) and table 4 ](#procedure-n1-to-reproduce-table-3-row-uncertainty-and-table-4)
>     * [Loading data](#Loading-data)
>     * [Reproduction of the row **Uncertainty** of table 3](#reproduction-of-the-row-uncertainty-of-table-3)
>     * [Reproduction of table 4](#reproduction-of-table-4)
> - [Procedure n°2 to reproduce data matching and then to have the results of a section of table 3](#procedure-n2-to-reproduce-data-matching-and-then-to-have-the-results-of-a-section-of-table-3)

# Development & Contributions
* Institute: LASTIG, Univ Gustave Eiffel, ENSG, IGN
* License: Cecill-C
* Authors:
	- Marie-Dominique Van Damme
	- Ana-Maria Raimond

<br/>

<!-- ===================================================================================================== -->
# Procedure n°1 to reproduce table 3 (row Uncertainty) and table 4 

All the steps described below concern the camptocamp.org data source. To get the results of the other data sources 
(OpenStreeetMap.org, Refuges.info, rando.ecrins-parcnational.fr and rando.parc-du-vercors.fr), it will be necessary 
to adapt the link of dataset to download and the table names in the SQL scripts. 

## Loading data

These instructions will be executed before the first or the second reproducing that follow.

- Input data : 
	* initial datasets: 
		- [Dataset_Camptocamp_org.csv](https://zenodo.org/record/6514812/files/Dataset_Camptocamp_org.csv?download=1)
		- [Dataset_POI_BDTopo.csv](https://zenodo.org/record/6514812/files/Dataset_POI_BDTopo.csv?download=1)
	* data matching links results: [matching_result_Camptocamp_and_BDTOPO.csv](https://zenodo.org/record/6518363/files/matching_result_Camptocamp_and_BDTOPO.csv?download=1) 
	* alignement file between the dataset and the OOR ontology: [Alignment_Camptocamp_OOR.csv](https://zenodo.org/record/6481339/files/Alignment_Camptocamp_OOR.csv?download=1)

- Coding environnement: PostGreSQL/POSTGIS

- Steps to follow
	* Step 1: create a database in PostGreSQL:
		```sql
		CREATE DATABASE agile_metadata_2022
		```
	* Step 2: install postgis extension for this new database (see Extension menu)
	
	* Step 3: import all the needed data in the postgres database: run the SQL script:
        ```sh
        sql/0_loading_data.sql
        ```
		

## Reproduction of the row **Uncertainty** of table 3


- Run the script SQL:

```sh
sql/1_confidence.sql
```

## Reproduction of table 4




<br/>

<!-- ===================================================================================================== -->
# Procedure n°2 to reproduce data matching and then to have the results of a section of table 3

1. Input ressourcesSource material:

The six dataset files : "Five spatial landmark datasets" downloaded on the plateform Zenodo (version 1.0)
The five files : "Alignment between type of landmark in different sources and the concept in the spatial reference objects ontology" on the plateform Zenodo (version 1.0)

Installation of the Java project “QualityMetadataSpatialLandmarkDataset”. See the readme:
https://github.com/ANRChoucas/QualityMetadataSpatialLandmarkDataset. There is not need You don’t need to install MultiCriteriaMatching code. It is a depedency library of the project  QualityMetadataSpatialLandmarkDataset (maven project). 





<!-- ## 4. To launch the creation of XML metadata files:
The main is into MainMetadataChoucas.java. You have to specify the source. -->


