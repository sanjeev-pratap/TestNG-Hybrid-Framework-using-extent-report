package object;

import Utils.CONSTANTS;
import base.BaseObject;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoObject extends BaseObject {

    public DemoObject(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "mainform:userId")
    private WebElement txtUserName;

    @FindBy(id = "mainform:userPassword")
    private WebElement txtPassword;

    @FindBy(id = "mainform:loginAction")
    private WebElement btnLogin;

    public void openApplication(){
        openURL(CONSTANTS.applicationURL);
    }

    public void login(String userName, String password){
        try {
            enterText(txtUserName, userName);
            enterText(txtPassword, password);
            click(btnLogin);
            takeScreenshot();
            takeScreenshot("login page");
        }
        catch (Exception e){
            logger.log(Status.FAIL, "Exception in login : " + e.toString());
            logger.log(Status.INFO, "");
        }
    }
}
