set DIR_HOME=%~dp0
cd %DIR_HOME%
set classpath=%DIR_HOME%\out\production\Framework;%DIR_HOME%\lib\*
java org.testng.TestNG %DIR_HOME%\src\testng.xml
pause