package test;

import Utils.CONSTANTS;
import Utils.Excel;
import base.BaseTest;
import com.aventstack.extentreports.Status;
import object.DemoObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class DemoTest extends BaseTest {

    DemoObject demoObject;

    @BeforeMethod
    public void beforeMethod(){
        demoObject = new DemoObject();
    }

    @DataProvider(name = "login")
    public static Object[][] credentials(){
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("username", "user");
        data.put("password", "pass");

        LinkedHashMap<String, String> data1 = new LinkedHashMap<>();
        data1.put("username", "user1");
        data1.put("password", "pass1");
        return new Object[][]{{data}, {data1}};
    }

    @DataProvider(name = "excel")
    public static Object[][] creds() throws Exception{
        Object[][] dataArray = Excel.getBulkTestDataExecutionFlag(CONSTANTS.dataSheet);
        return dataArray;
    }

    /*@Test()
    public void test1(){
        logger.log(Status.PASS,"test pass");
        Assert.assertEquals("pass","fail");
        System.out.println("after assert fail");
    }

    @Test
    public void test2(){
        logger.log(Status.INFO, "this is info");
        logger.log(Status.FAIL, "this is fail");
        logger.log(Status.INFO, "this is info");
        logger.log(Status.PASS,"test pass");
    }*/

    @Test(dataProvider = "excel")
    public void loginTest(LinkedHashMap<String, String> dataArray){
//        LinkedHashMap<String, String> dataMap = dataArray[0];
        System.out.println("Running for Data : " + dataArray);
        demoObject.openApplication();
        demoObject.login(dataArray.get("UserName"),dataArray.get("Password"));
//        Assert.fail();
    }

    /*@Test
    public void loginTest(){
        demoObject.openApplication();
        demoObject.login("username","password");
    }*/
}
