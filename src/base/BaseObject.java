package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.model.MediaType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.text.SimpleDateFormat;

public class BaseObject {
    public static WebDriver driver;
    public static ExtentTest logger;

    public void openURL(String URL){
        driver.get(URL);
        logger.log(Status.PASS, URL +" opened successfully");
    }

    public void click(WebElement element){
        element.click();
        logger.log(Status.PASS, "Element clicked successfully");
    }

    public void click(WebElement element, String elementName){
        element.click();
        logger.log(Status.PASS, elementName +" clicked successfully");
    }



    public void enterText(WebElement element, String text){
        element.sendKeys(text);
        logger.log(Status.INFO,text + " entered successfully");
    }

    public void enterText(WebElement element, String text, String elementName){
        element.sendKeys(text);
        logger.log(Status.INFO,text + " entered successfully in " + elementName);
    }

    public static void takeScreenshot(String comment) throws Exception{
        String screenshotfolder = BaseTest.testScreenshot;
        TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
        File image = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotPath = screenshotfolder +"/" + comment +  " " + getTimeStamp1() +".png";
        File screen = new File(screenshotPath);
        FileUtils.copyFile(image, new File(screenshotPath));
        screenshotPath = screenshotPath.replace("./Reports/","");
        logger.info(comment, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

    }
    public static void takeScreenshot() throws Exception{
        String screenshotfolder = BaseTest.testScreenshot;
        TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
        File image = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotPath = screenshotfolder +"/"  + getTimeStamp1() +".png";
        FileUtils.copyFile(image, new File(screenshotPath));

        screenshotPath = screenshotPath.replace("./Reports/","");
        logger.info("Screenshot : ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new java.util.Date());

    }

    public static String getTimeStamp1() {
        return new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());

    }
}
