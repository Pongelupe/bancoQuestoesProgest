# bancoQuestoesProgest
Banco questões para o Progest
*/
@Author: @pongelupe
@Date: 28-01-2017

Welcome stranger,

this file gives instruction how to run this project.

First you need to install some tools on the server:

1° - Java 8
2° - Java Development Kit (JDK) 8 
3º - Apache Maven =< 3.3.9
4º - MySql =< 5.7.21  

After that, it's time to run the project:

1°: Go to project's root directory (the one with the Maven file pom.xml)
2º: Run Maven clean
	mvn clean
3º: Run Maven package
	mvn package
4º: Run the fat jar
	java -jar target/bancoQuestoes-0.0.1-SNAPSHOT.jar
5º: Project now running at localhost:8080


Observations:

- At the first deploy, you should init the MySql database, running this command:

	 mysql -u ${database.user} -p < databaseInit.sql

then log with a user from your database. Ex. root.

- The MySql credentials are configured at
	/src/main/resources/application.properties

- This project runs at 8080, if you have to change that, it's configured at /src/main/resources/application.properties


/*
