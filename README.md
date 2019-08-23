# TestNG-Hybrid-Framework-using-extent-report
A java test automation framework developed using TestNG, extent report and Page Factory

Packages :
	Base Package - This package has two class BaseTest and BaseObject.
		BaseTest has implementations for TestNG annotations, driver initialisation etc.
		BaseObject has common methods which can be used while writing functions in PageFactory class
		
	Object Package - This package will have all the PageFactory classes i.e it will have all the objects and methods for the objects. There should be different object class for each UI Screen
		Every Class in Object Page needs to extend BaseObject
		
	Test Package - This package will have all the Test classes.
		Every test class needs to extend BaseTest
		
	Utils - This package have utilities classes like reading data from excel, listners and all.
	
Reporting :
	This framework creates extent report for every suite.
	To add any log use "logger" which is the instance of ExtentTest
	To add a screenshot simply call the takeScreenshot methods
	To fail a test case simply call Assert.fail();
	Screenshot will be auto added whenever a test case fails
	We are using extent report 4 so no config file is required.
	
Test Data : 
	Test Data will be stored in Data.xlsx
	@DataProvider is used to for supplying data to test script, so for running a test case against multiple data doesn't need any coding effort.
	ExecutionFlag field needs to be yes in excel for a test to run, otherwise it will be skipped by @DataProvider
	
Multi Browser Testing :
	"browser" parameter in suite xml file decides on which browser the test will run.
	
	
Following is the list of jars used in this project ( I plan to convert this into maven) : 
	activation-1.1.1
	bsh-2.0b4
	bson-3.3.0
	byte-buddy-1.8.15
	client-combined-3.141.59
	client-combined-3.141.59-sources
	commons-codec-1.9
	commons-codec-1.11
	commons-collections4-4.2
	commons-compress-1.18
	commons-exec-1.3
	commons-io-2.6
	commons-logging-1.2
	commons-math3-3.6.1
	curvesapi-1.05
	extentreports-4.0.9
	freemarker-2.3.23
	gson-2.8.5
	guava-25.0-jre
	httpclient-4.5.2
	httpcore-4.4.4
	httpmime-4.5.2
	jaxb-api-2.3.0
	jaxb-core-2.3.0.1
	jaxb-impl-2.3.0.1
	jcommander-1.48
	jsoup-1.11.2
	junit-4.12
	log4j-1.2.17
	mongodb-driver-3.3.0
	mongodb-driver-core-3.3.0
	okhttp-3.11.0
	okio-1.14.0
	page-factory-1.3.0
	poi-4.0.1
	poi-examples-4.0.1
	poi-excelant-4.0.1
	poi-ooxml-4.0.1
	poi-ooxml-schemas-4.0.1
	poi-scratchpad-4.0.1
	testng-6.9.10
	xmlbeans-3.0.2