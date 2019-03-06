package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

/**
 * @author Sanjai on 03/06/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Membership_Fields extends Test_Base {

    WebDriver driver;

    @FindBy(name = "adultFirstName0")
    WebElement primaryFirstName;

    @FindBy(name = "adultLastName0")
    WebElement primaryLastName;

    @FindBy(name = "adultFirstName1")
    WebElement secondaryFirstName;

    @FindBy(name = "adultLastName1")
    WebElement secondaryLastName;

    @FindBy(id = "extracard1")
    WebElement extracard;

    @FindBy(css = ".counter-field")
    WebElement noOfChild;



    public Membership_Fields(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void primaryMemberName(){
        primaryFirstName.clear();
        primaryLastName.clear();

        driver.findElement(By.cssSelector(element.getString("buynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("primaryFirstname_error"))).getText().toLowerCase(), property.getString("MembershipFirstname_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Primary First Name field validation message not proper on empty field" + t.getMessage());
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("primaryLastname_error"))).getText().toLowerCase(), property.getString("MembershipLastname_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Primary Last Name field validation message not proper on empty field" + t.getMessage());
        }

        primaryLastName.clear();
        primaryFirstName.sendKeys(property.getString("primaryFirstName"));
        Log.info("Tested - Primary First Name with value: " + property.getString("primaryFirstName"));

        primaryLastName.clear();
        primaryLastName.sendKeys(property.getString("primaryLastname"));
        Log.info("Tested - Primary Last Name with value: " + property.getString("primaryLastname"));
    }

    public void secondaryMemberName(){
        secondaryFirstName.clear();
        secondaryLastName.clear();

        driver.findElement(By.cssSelector(element.getString("buynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("secondaryFirstname_error"))).getText().toLowerCase(), property.getString("MembershipFirstname_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Secondary First Name field validation message not proper on empty field" + t.getMessage());
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("secondaryLastname_error"))).getText().toLowerCase(), property.getString("MembershipLastname_error").toLowerCase());
        }catch (Throwable t){
            Log.error("Secondary Last Name field validation message not proper on empty field" + t.getMessage());
        }

        secondaryFirstName.clear();
        secondaryFirstName.sendKeys(property.getString("secondaryFirstName"));
        Log.info("Tested - Secondary First Name with value: " + property.getString("secondaryFirstName"));

        secondaryLastName.clear();
        secondaryLastName.sendKeys(property.getString("secondaryLastName"));
        Log.info("Tested - Secondary Last Name with value: " + property.getString("secondaryLastName"));
    }

    public void childCount(){
        Random random = new Random();
        int count = 0;
        if (test_site.equals("erie")){
            count = random.nextInt(10);
        }

        noOfChild.sendKeys(Integer.toString(count));
    }

}
