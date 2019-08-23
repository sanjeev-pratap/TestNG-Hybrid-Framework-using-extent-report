package base;

import Utils.CONSTANTS;
import Utils.TestListener;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class BaseTest {
    public ExtentHtmlReporter html;
    public ExtentReporter extentReporter;
    public ExtentReports extent;
    public static ExtentTest logger;
    public static WebDriver driver;
    public static String timeStamp;
    public static String suiteScreenshot;
    public static String testScreenshot;
    public static long start;
    public static long end;

    @BeforeSuite
    public void beforeSuite(ITestContext ctx){
        start = Instant.now().getEpochSecond();
        String suiteName = ctx.getSuite().getName();
        timeStamp = getTimeStamp();
        html = new ExtentHtmlReporter("./Reports/" + suiteName + timeStamp +".html");
        suiteScreenshot = "./Reports/Screenshot/"+ suiteName + timeStamp;
        new File(suiteScreenshot).mkdir();
        extent = new ExtentReports();
        extent.attachReporter(html);
    }

    @BeforeClass
    public void beforeClass(){

    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(Method result, String browser){
        System.out.println("Test Case : " + result.getName() + " started.");
        testScreenshot = suiteScreenshot + "/" + result.getName() + getTimeStamp1();
        new File(testScreenshot).mkdir();
        initBrowser(browser);
        logger= extent.createTest(result.getName());
        setDriverInstance();
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        try{
            driver.quit();
        }
        catch (Exception e){

        }
        if(result.getStatus() == ITestResult.FAILURE || logger.getStatus().equals(Status.FAIL)){
            logger.fail("Test Failed");
        }
        else if(result.getStatus() == ITestResult.SUCCESS || logger.getStatus().equals(Status.PASS)){
            logger.pass("Test Passed");
        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.skip("Test Skipped");
        }
        else{
            logger.skip("Status Unknown");
        }
    }

    @AfterClass
    public void afterClass(){

    }

    @AfterSuite
    public void afterSuite(){
        extent.flush();
        end = Instant.now().getEpochSecond();
        System.out.println("Execution Time : " + (end-start) + " seconds");
    }

    public void initBrowser(String browserName){

        switch (browserName){
            case "internetexplorer":
                initIE();
                break;
            case "chrome":
                initChrome();
                break;
            default:
                System.out.println("No Browser entered in parameter");
        }
    }

    public void initIE(){
        System.setProperty("webdriver.ie.driver", CONSTANTS.ieDriverPath);
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        System.out.println("Internet Explorer started successfully");
    }

    public void initChrome(){
        System.setProperty("webdriver.chrome.driver", CONSTANTS.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Chrome started successfully");
    }

    public void setDriverInstance(){
        BaseObject.driver = driver;
        BaseObject.logger = logger;
    }


    public String getTimeStamp() {
        return new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new java.util.Date());

    }

    public String getTimeStamp1() {
        return new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());

    }






}
