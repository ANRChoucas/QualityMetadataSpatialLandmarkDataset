# QualityMetadataSpatialLandmarkDataset

This project contains the procedures to reproduce the results of the paper *A method to produce metadata describing 
and assessing the quality of spatial landmark datasets in mountain area, M.-D. Van Damme, A.-M. Olteanu Raimond*

<!-- Metadata describing and assessing the quality of spatial landmark datasets in mountain area. -->



> README Contents
> - [Development & Contributions](#Development-&-Contributions)
> - [Procedure n°1 to reproduce table 3 (row Uncertainty) and table 4 ](#procedure-n1-to-reproduce-table-3-row-uncertainty-and-table-4)
>     * [Loading data](#loading-data-for-procedure-n1)
>     * [Reproduction of the row *Uncertainty* of table 3](#reproduction-of-the-row-uncertainty-of-table-3)
>     * [Reproduction of table 4](#reproduction-of-table-4)
> - [Procedure n°2 to reproduce data matching and then to have the results of a section of table 3](#procedure-n2-to-reproduce-data-matching-and-then-to-have-the-results-of-a-section-of-table-3)
>     * [Loading data](#loading-data-for-procedure-n2)


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


## Loading data for procedure n°1

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
	
	* Step 3: import all the needed data in the postgres database: run the SQL script **sql/0_loading_data.sql**

		
<br/>

## Reproduction of the row *Uncertainty* of table 3

- Run the first request in the script SQL **sql/1_confidence.sql** to get the DQ_confidence for all the scope.

- Note: the two other scripts compute the DQ_confidence for a subset of the types. This is an example for on demand metadata; 
  for example if the user needs to assess only the confidence of the matching algorithm for a specific types of landmarks 
  (e.g. those corresponding the the ontology class "isolated accomodation") 

<br/>

## Reproduction of table 4

#### MeanAdsolute2D, RootMeanSquareError, and AgreementRate Threshold rows 

- Run the script SQL **sql/2_spatial_accuracy.sql**

#### Overall accuracy and Confusion Matrix rows

- Run the script SQL **sql/3_confusion_matrix_all.sql**
- Import the result in a tabular software like Excel or OpenOffice
- Create a cross table: the values of the first column correspond to the line, 
  the values of the second column correspond to the column and the values of 
  the third column correspond to the quantitative values of the cross table
- Several couple of values, not in the diagonal, are correctly classified items:  
	(hébergement_isolé, abri), (lieu-dit, col), (lieu-dit, croix), (lieu-dit, massif_boisé),
	(lieu-dit, rocher), (lieu-dit,  surface_neige_et_glace), (lieu-dit, vallée), (lieu-dit, abri), 
	(lieu-dit, hébergement_isolé), (hébergement_isolé, grange), (hébergement_accessible, gîte), 
	(hébergement_isolé', 'refuge'); 
  these pairs are used also to compute overall accuracy. 
- The overall accuracy is the sum of items on the main diagonal + items correctly classified) 
  divided by the sum of all items from the matrix

#### Duplicate row 

- Run the script SQL **sql/4_duplicate_all** by changing each time the name of the dataset table

#### Non quantitative attribute accuracy measures

- Run the script SQL **sql/5_Samal_distance.sql** 

#### Missing class "nom"

- Run the script SQL **sql/6_missing_class.sql** 


#### Excess and Missing items rows


- You have to create a worksheet in a tabular software like Excel or OpenOffice

- Prepare the worksheet by creating these columns:

![GitHub Logo](/img/completeness.png)

- Run each request in the script SQL **sql/7_completeness.sql** and put the result column per column

- Calculate the sum of elements in each column, for example the sum are stored in line 115.

- Then, you have:

	* Excess = (B115+C115)/E115
	* Missing items = F115/H115


<br/>

<!-- ===================================================================================================== -->
# Procedure n°2 to reproduce data matching and then to have the results of a section of table 3


## Loading data for procedure n°2

1. Input ressources:

- The six dataset files : [Five spatial landmark datasets" downloaded on the plateform Zenodo (version 1.0)](https://zenodo.org/record/6514812)
- The five files : [Alignment between type of landmark in different sources and the concept in the spatial reference objects ontology](https://zenodo.org/record/6481339)

2. The current Java project “QualityMetadataSpatialLandmarkDataset”. There is not need You don’t need to install 
   *MultiCriteriaMatching* code. It is a depedency library of the project QualityMetadataSpatialLandmarkDataset (maven project). 


## Step n°1: installation of the Java project 

- Java Install:
	* Download and install the Java Development Kit (JDK) (jdk 8) from the Oracle website
- Eclipse
	* Download and install the IDE Eclipse
- Download the project *QualityMetadataSpatialLandmarkDataset* on your local system
- Import the project in Eclipse like a maven project


## Step n°2: import dataset files in the project

- drop the six landmark dataset files in the data/dataset folder
- drop the five alignements files in the data/alignment folder

## Step n°3, launch data matching script

Launch the Java main file MainMatchingCamptocampBdtopo.java. 
This program loads data and computes the matching links between the sources of datasets and the BDTOPO dataset.

At the end of the computation, the data are matched and the results are stored as a CSV file (e.g. c2c-bdtopo-XXX.csv”) in the resultat folder. 
Note : rows one (1:0)  and two (1:1) of Table 3 are obtained directly from the Java console print


## Step  n°4, Validate the data matching results (manually)

1. Launch QGIs 
2. Install the plugIn 
	* Copy the [visu_valide_MultiCriteriaMatching plugIn](https://github.com/ANRChoucas/VisuValideMultiCriteriaMatching) in the QGIS folder 
	* Open QGIS; 
	* In the QGIS Extensions look for the visu_valide_MultiCriteriaMatching plugIn;  a small icon is added on the QGIS ‘s  plugIn  toolbar  
3. Execute the plugIn visu_valide_MultiCriteriaMatching by click on the button in toolbar
4. Import the file creating in the step before. 
5. Validate landmark by landmark
6. The results are store in a shapefile


<!-- ## 4. To launch the creation of XML metadata files:
The main is into MainMetadataChoucas.java. You have to specify the source. -->


