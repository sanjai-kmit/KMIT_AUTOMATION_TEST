package functionality_fields;

import base_test.Test_Base;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

/**
 * @author Sanjai on 03/04/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class SignUp extends Test_Base {

    WebDriver driver;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "phoneNumber")
    WebElement phoneNumber;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "City")
    WebElement city;

    @FindBy(name = "ZIPCODE")
    WebElement zipcode;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(name = "customerCode")
    WebElement customerCode;


    public SignUp(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void firstName() throws Exception{

        //Validate for empty field
        firstName.clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("firstName_error"))).getText().toLowerCase(), property.getString("firstName_error").toLowerCase());
        }catch (Throwable t){
            Log.error("First Name Error message is not proper on Empty data: " + t.getMessage());
        }
        firstName.clear();
        firstName.sendKeys(property.getString("firstName"));

        Log.info("Tested signup page: First Name field - given value is: " + property.getString("firstName"));
    }

    //    for lastname
    public void lastName() throws Exception{

        //Validate for empty field
        lastName.clear();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("lastName_error"))).getText().toLowerCase(), property.getString("lastName_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Last Name Error message is not proper on Empty data: " + t.getMessage());
        }
        lastName.clear();
        lastName.sendKeys(property.getString("lastName"));

        Log.info("Tested signup page: Last Name field - given value is: " + property.getString("lastName"));
    }


    //    for phoneNumber
    public void phoneNumber() throws Exception{

        phoneNumber.clear();
        phoneNumber.sendKeys("123456789");
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("phoneNumber_error"))).getText().toLowerCase(), property.getString("phoneNumber_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Phone Number Error message is not proper on Invalid data: " + t.getMessage());
        }
        phoneNumber.clear();
        phoneNumber.sendKeys(property.getString("phoneNumber"));

        Log.info("Tested signup page: Phone Number field - given value is: " + property.getString("phoneNumber"));
    }


    //    for email
    public void email() throws  Exception{
        email.clear();
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("email_error_empty"))).getText().toLowerCase(), property.getString("email_error_empty").toLowerCase());
        }catch (Throwable t){
            Log.error("Email Field Error message is not proper on Empty data: " + t.getMessage());
        }

        email.sendKeys("test");
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("email_error_invalid"))).getText().toLowerCase(), property.getString("email_error_invalid").toLowerCase());
        }catch (Throwable t){
            Log.error("Email Field Error message is not proper on Invalid data: " + t.getMessage());
        }
        email.clear();
        email.sendKeys(emailId);

        Log.info("Tested signup page: Email field - given value is: " + emailId);
    }

    //    for address
    public void address(){
        address.clear();
        address.sendKeys(property.getString("addressLine_1"));

        Log.info("Tested signup page: Address field - given value is: " + property.getString("addressLine_1"));
    }

    //    for city
    public void city(){
        city.clear();
        city.sendKeys(property.getString("city"));

        Log.info("Tested signup page: City field - given value is: " + property.getString("city"));
    }

    //    for zipcode
    public void zipCode() throws Exception{
        zipcode.clear();
        zipcode.sendKeys("1");
        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("zipcode_error"))).getText().toLowerCase(), property.getString("zipcode_error").toLowerCase());
        }catch (Throwable t){
            Log.error("ZipCode Field Error message is not proper on Invalid data: " + t.getMessage());
        }
        zipcode.clear();
        zipcode.sendKeys(property.getString("zipcode"));

        Log.info("Tested signup page: Zipcode field - given value is: " + property.getString("zipcode"));
    }


    // for password
    public void password_confirmPassword() throws Exception{
//  validation for empty field
        password.clear();
        confirmPassword.clear();

        WebElement createBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element.getString("create_btn"))));
//        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();
        createBtn.click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_error"))).getText().toLowerCase(), property.getString("password_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Password Field Error message is not proper on Empty data: " + t.getMessage());
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("confirmPassword_error"))).getText().toLowerCase(), property.getString("confirmPassword_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Confirm Password Field Error message is not proper on Empty data: " + t.getMessage());
        }


//   validation for invalid password
        String j = "s";
        for (int i = 2; i < 6; i++){
            password.clear();
            confirmPassword.clear();
            password.sendKeys(j);
            confirmPassword.sendKeys(j);
            j += Integer.toString(i);

            driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

            if (i == 2) {
                Thread.sleep(2000);
            }
            try {
                Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_limit_error"))).getText().toLowerCase(), property.getString("password_limit_error").toLowerCase());
            }catch (Throwable t){
                Log.error("Password Limit Error message is not proper: " + t.getMessage());
            }
        }

        password.clear();
        confirmPassword.clear();

//        validation for password not match
        password.sendKeys("01234567");
        confirmPassword.sendKeys("987654321");
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("password_not_match_error"))).getText().toLowerCase(), property.getString("password_not_match_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Password Match Error message is not proper: " + t.getMessage());
        }

        password.clear();
        confirmPassword.clear();

        password.sendKeys(property.getString("password"));
        Log.info("Tested signup page: Password field - given value is: " + property.getString("password"));

        confirmPassword.sendKeys(property.getString("confirmPassword"));
        Log.info("Tested signup page: Confirm Password field - given value is: " + property.getString("confirmPassword"));

        driver.findElement(By.cssSelector(element.getString("create_btn"))).click();

        Thread.sleep(10000);
    }


}
