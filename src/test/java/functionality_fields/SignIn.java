package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author Sanjai on 03/05/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class SignIn extends Test_Base {

    WebDriver driver;

    //    for login page fields
    @FindBy(name = "userName")
    WebElement user_name;

    @FindBy(name = "password")
    WebElement password;

    public SignIn(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login_validation(String userName, String userPassword) throws Exception{

//        for empty user name and password field
        try {
            user_name.clear();
        } catch (Throwable t){
            Log.error("User name field: " + t.getMessage());
        }
        password.clear();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_name_empty_error"))).getText().toLowerCase(), property.getString("user_name_empty_error").toLowerCase());
        }catch (Throwable t){
            Log.error(t);
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_password_empty_error"))).getText().toLowerCase(), property.getString("user_password_empty_error").toLowerCase());
        }catch (Throwable t){
            Log.error(t);
        }

        user_name.clear();
        password.clear();

//        for invalid password
        user_name.sendKeys("sanjaim@kmitsolutions.com");
        password.sendKeys("12587865");

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_invalid_error"))).getText().toLowerCase(), property.getString("user_password_invalid_error").toLowerCase());
        }catch (Throwable t){
            Log.error(t);
        }

        user_name.clear();
        password.clear();

//        for invalid user
        user_name.sendKeys("testemailid@kmitsolutions.com");
        password.sendKeys("12587865");

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("user_invalid_error"))).getText().toLowerCase(), property.getString("user_name_invalid_error").toLowerCase());
        }catch (Throwable t){
            Log.error(t);
        }

        user_name.clear();
        user_name.sendKeys(userName);
        Log.info("Tested: User Name field - given value is: " + userName);

        password.clear();
        password.sendKeys(userPassword);
        Log.info("Tested: Password Field - given value is: " + userPassword);

        driver.findElement(By.cssSelector(element.getString("login_btn"))).click();

        Thread.sleep(2000);
    }

}
