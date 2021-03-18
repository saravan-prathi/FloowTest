# FloowTest
Steps to follow for running this project

1) Clone the project's repository from https://github.com/saravan-prathi/FloowTest.git

2) Open the cloned project(as a maven project) with IntelliJ [>JVM 1.8] or a similar IDE, and using the maven plugin, click on "install"
			(or)
   Instead of opening the project in an IDE, from the folder containing the pom.xml file, run the maven's "mvn install" command [you must have maven installed on your machine for this]

3) With the above steps, Floowtest.jar would get created in the target folder. From the target folder, Run this command "java -jar Floowtest.jar" with a JVM [>1.8]

4) Project would be up and running with the above steps. Open Postman and test the project on localhost in 8080 port.

Eg: http://localhost:8080/driver/create
    http://localhost:8080/drivers
    http:localhost:8080/drivers/byDate?date=1981-06-01
[please ensure you first create the records with the first link, before you query the results using the second/third links]
