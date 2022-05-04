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
	
	* Step 3: import all the needed data in the postgres database: run the SQL script 
		
		**sql/0_loading_data.sql**

		
<br/>

## Reproduction of the row **Uncertainty** of table 3

- Run the script SQL **sql/1_confidence.sql**


## Reproduction of table 4

#### MeanAdsolute2D, RootMeanSquareError, and AgreementRate Threshold rows 

- Run the script SQL **sql/spatial_accuracy.sql**

#### Overall accuracy and Confusion Matrix rows

- run mc-all.sql
- import the result in a tabular software like Excel or OpenOffice
- create a cross table: the values of the first column correspond to the line, 
  the values of the second column correspond to the column and the values of 
  the third column correspond to the quantitative values of the cross table
- Several couple of values, not in the diagonal, are correctly classified items:  
	(hébergement_isolé, abri), (lieu-dit, col), (lieu-dit, croix), (lieu-dit, massif_boisé),
	(lieu-dit, rocher), (lieu-dit,  surface_neige_et_glace), (lieu-dit, vallée), (lieu-dit, abri), 
	(lieu-dit, hébergement_isolé), (hébergement_isolé, grange), (hébergement_accessible, gîte), 
	(hébergement_isolé', 'refuge'); 
  these pairs are used also to compute overall accuracy. 
- The overall accuracy is the sum of items on the main diagonal 
   + items correctly classified) divided by the sum of all items from the matrix



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


