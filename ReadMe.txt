prerequisits

clone project
setup selenium and testNG in eclipse
confirm maven installed on your machine using mvn -version command

Navigate to pom.xml file and run below command

mvn test -P ErrorValidation
	running ErrorValidation profile which is defined in the POM.xml
	
mvn test -P Regression -Dbrowser=Firefox
	running Regression profile which is defined in the POM.xml
	passing parameter from maven to selenium 
	
surefire plugin
		maven-surefire plugin is used to configure the TestNG and Maven POM