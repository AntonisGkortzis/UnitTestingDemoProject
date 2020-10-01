# Unit Testing demonstration project An amazing Project regarding unit testing.
[![Build Status](https://travis-ci.org/AntonisGkortzis/UnitTestingDemoProject.svg?branch=master)](https://travis-ci.org/AntonisGkortzis/UnitTestingDemoProject)
[![codecov](https://codecov.io/gh/AntonisGkortzis/UnitTestingDemoProject/branch/master/graph/badge.svg)](https://codecov.io/gh/AntonisGkortzis/UnitTestingDemoProject)
[![Coverage Status](https://coveralls.io/repos/github/AntonisGkortzis/UnitTestingDemoProject/badge.svg?branch=master&service=github)](https://coveralls.io/github/AntonisGkortzis/UnitTestingDemoProject)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
## Overview
This is a Java project serving as a brief demonstration for Unit Testing for the needs of the lab tutorials of the [Software Engineering in Practice](https://www2.dmst.aueb.gr/dds/sweng-en/) course. It makes use of Maven to automate the build process of the two available modules. 
## Requirements
This project requires:
- Java JDK [version 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (or later) and
- Maven [3.3](https://maven.apache.org/download.cgi) (or later)
## Build project
In order to build the project execute the following Maven command:
```
mvn clean install jacoco:report
```
This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path for each module:
```
target/site/jacoco
```

## Test project
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test
```
***Important:*** Note that only classes with a ```Test``` suffix located in the ```src/test``` will be executed and reported as Tests.

## Generate Test-coverage report
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test jacoco:report
```


## Continuous Integration service
This projects utilizes TravisCI services in other to test and build the application upon each ```git-push``` in the remote repository. 
There are multiple build environments in which the application will be tested and build. You can check these options under the ```jdk``` tag in the ```.travis.yml``` file. 

After each build, the badge is updated with the corresponding build status, ```green``` for passes and ```red``` for failures.

[Here](https://docs.travis-ci.com/user/getting-started/) is a TravisCI quick guide. It's free for public repositories! 

## Code coverage services
The repository is connected to two different **code coverage** analysis tools, [CodeCov](https://codecov.io/) and [Coveralls](https://coveralls.io/). Both code coverage services provide badges with the coverage percentages.

### CodeCov
Code coverage reports provided by CodeCov is available on the repository page in the CodeCov website. The analysis is executed after each successfully TravisCI build. 

CodeCov can use a more elaborated code coverage report that is produced by including the following plugin in your POM file. 
```
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>cobertura-maven-plugin</artifactId>
	<version>2.7</version>
	<configuration>
		<formats>
			<format>html</format>
			<format>xml</format>
		</formats>
		<check />
	</configuration>
</plugin>
```
In order to produce the cobertura coverage report include the ```cobertura:cobertura``` in your ```mvn``` command.

The command for triggering the code coverage analysis should be placed in the ```.travis.yml``` as illustrated below
```
after_success:
  - bash <(curl -s https://codecov.io/bash) -t your_token 
```
The ```-t your_token``` is required only for private respositories. 

In order to obtain a badge [![codecov](https://codecov.io/gh/AntonisGkortzis/UnitTestingDemoProject/branch/master/graph/badge.svg)](https://codecov.io/gh/AntonisGkortzis/UnitTestingDemoProject) in your README that reports the coverage of your project copy-paste the Markdown link provided by CodeCov in the repository's ```Settings-->Badge-->Markdown```. Note that if you have a private repository the badge requires a ```?token=a_token``` variable in the provided url. Otherwise it will always shows "unknown". 

[Here](https://github.com/codecov/example-java) is a short example for using CodeCov with TravisCI in a Java project.

### Coveralls
Coveralls is a stand alone code coverage analysis tool. However, it can be used as an analyser for the JaCoCo report produced during the ```package``` Maven command. In this repository we utilize Coveralls with its later functionality. 

For parsing the JaCoCo output and creating a code coverage report, the ```jacoco:report coveralls:report``` arguments should be added in the Maven command in the ```.travis.yml``` file. 
```
mvn clean package jacoco:report coveralls:report
```

Also, the Coveralls plug-in along with the repository *Token* (produced automatically by the Coveralls website) should be added in the ***pom.xml*** file like the following:
```
<plugin>
    <groupId>org.eluder.coveralls</groupId>
    <artifactId>coveralls-maven-plugin</artifactId>
    <version>4.3.0</version>
    <configuration>
        <repoToken>yourRepositotyToken</repoToken>
    </configuration>
</plugin>
```

*Important:* Coveralls is free only for public repositories.  

## Contributing
You are more than welcome to contribute in this project. Just have in mind that the repository aims at providing an overview of unit testing functionality and Continuous Integration plug-ins related to testing. 
- If you have any suggestions please open an issue. 
- If you want to actively contribute, please fork this repository and create a pull request after completing your addition/modification.

## License 
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
