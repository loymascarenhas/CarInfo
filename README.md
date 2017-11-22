Project Name: car-data
Build Type: Maven
REST API - Jersey
Data stored in memory: Map

Setup
-----
Extract the zip file to your local machine


Server port set to 8080, if required can be changed at location: target/classes/application.properties

	--> server.port=8080

Run the application
-------------------
Open command prompt and change directory to he extracted project location (eg. cd path\car-data)

To start the application, use command

	--> mvn spring-boot:run

URI test using cURL
-------------------
Open command prompt to file location where the cars.json file exist (for adding cars)
	--> eg. cd zip-extracted-path\car-data

Add Car(s)
----------
curl -H "Content-Type:application/json" -X POST -d @cars.json  http://localhost:8080/cardata/car/add

	--> where 'cars.json' file contains multiple car details
	
Note: cars.json file should contain the car information and the above command should be executed from the same file location as the cars.json file is located.
cars.json file is attached in the folder for reference.

Get All Cars
------------
curl http://localhost:8080/cardata/car/get/all

Get Car by Id
-------------
curl http://localhost:8080/cardata/car/get/1

	--> where '1' is the ID
 
Get Cars by Year
----------------
curl http://localhost:8080/cardata/car/get/year/2010

	--> where '2010' is the year
Get Car by Make
---------------
curl http://localhost:8080/cardata/car/get/make/mercedes

	--> where 'mercedes' is the make of the car
	
Get Car by Type
---------------
curl http://localhost:8080/cardata/car/get/type/sedan

	--> where 'sedan' is the type of the car
	
Get Cars by Year and Make
-------------------------
curl http://localhost:8080/cardata/car/get/year/2010/make/audi

Get Cars by Year and Type
-------------------------
curl http://localhost:8080/cardata/car/get/year/2013/type/sedan

Get Cars by Make and Type
-------------------------
curl http://localhost:8080/cardata/car/get/make/mercedes/type/suv

Get Cars by Year, Make and Type
-------------------------------
curl http://localhost:8080/cardata/car/get/year/2015/make/mercedes/type/suv

Delete Car by Id
----------------
curl -X DELETE http://localhost:8080/cardata/car/delete/1

 --> where 1 is the ID