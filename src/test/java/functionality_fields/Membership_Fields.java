package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(id = "extra_qty")
    WebElement extra_qty;

    @FindBy(css = ".counter-field")
    WebElement noOfChild;

    @FindBy(id = "alaCartCountLimit")
    WebElement careGiver;

    @FindBy(name = "alaCartFirstName00")
    WebElement careGiverFirstName1;

    @FindBy(name = "alaCartLn00")
    WebElement careGiverLastName1;

    @FindBy(name = "alaCartFirstName01")
    WebElement careGiverFirstname2;

    @FindBy(name = "alaCartLn01")
    WebElement careGiverLastName2;





    public Membership_Fields(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void primaryMemberName()throws Exception{
        Thread.sleep(1000);
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
        if (test_site.equals("erie")){
            childCount = random.nextInt(10);
        }

        noOfChild.clear();
        noOfChild.sendKeys(Integer.toString(childCount));
        Log.info("Tested - No of Child selected: " + childCount);
    }

    public void extraCard(){
        Random random = new Random();
        int yes_no = random.nextInt(1);
        if (yes_no == 1) {
            extracard.click();
            String noOf_extra_card = Integer.toString(random.nextInt(2));
            extra_qty.sendKeys(noOf_extra_card);
            Log.info("Extra Card Selected is: " + noOf_extra_card);
        }
    }

    public void setCareGiver(){
        Random random = new Random();
        noOf_CareGivers = random.nextInt(2);
        System.out.println("noOf_CareGivers: " + noOf_CareGivers);
        Select giver = new Select(careGiver);
        giver.selectByValue(Integer.toString(noOf_CareGivers));
        Log.info("Tested: No of Care Giver Selected: " + noOf_CareGivers);

        if (noOf_CareGivers == 1){
            careGiverFirst();
        } else if (noOf_CareGivers == 2){
            careGiverFirst();
            careGiverSecond();
        }
    }

    public void careGiverFirst(){
        careGiverFirstName1.clear();
        careGiverLastName1.clear();

        driver.findElement(By.cssSelector(element.getString("buynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("careGiver_FirstName1_error"))).getText(), property.getString("MembershipFirstname_error"));
        } catch (Throwable t){
            Log.error("Care Giver First Name of CareGiver 1 is not match: " + t.getMessage());
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("careGiver_LastName1_error"))).getText(), property.getString("MembershipLastname_error"));
        } catch (Throwable t){
            Log.error("Care Giver Last Name of CareGiver 1 is not match: " + t.getMessage());
        }

        careGiverFirstName1.clear();
        careGiverFirstName1.sendKeys(property.getString("careGiver_FirstName1"));
        Log.info("Tested: Care Giver First Name of CareGiver 1 with value: " + property.getString("careGiver_FirstName1"));

        careGiverLastName1.clear();
        careGiverLastName1.sendKeys(property.getString("careGiver_LastName1"));

        Log.info("Tested: Care Giver Last Name of CareGiver 1 with value: " + property.getString("careGiver_LastName1"));
    }

    public void careGiverSecond(){
        careGiverFirstname2.clear();
        careGiverLastName2.clear();
        driver.findElement(By.cssSelector(element.getString("buynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("careGiver_FirstName2_error"))).getText(), property.getString("MembershipFirstname_error"));
        } catch (Throwable t){
            Log.error("Care Giver First Name of CareGiver 2 is not match: " + t.getMessage());
        }

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("careGiver_LastName2_error"))).getText(), property.getString("MembershipLastname_error"));
        } catch (Throwable t){
            Log.error("Care Giver Last Name of CareGiver 2 is not match: " + t.getMessage());
        }

        careGiverFirstname2.clear();
        careGiverFirstName1.sendKeys(property.getString("careGiver_FirstName2"));
        Log.info("Tested: Care Giver First Name of CareGiver 2 with value: " + property.getString("careGiver_FirstName2"));

        careGiverLastName2.clear();
        careGiverLastName2.sendKeys(property.getString("careGiver_LastName2"));
        Log.info("Tested: Care Giver First Name of CareGiver 2 with value: " + property.getString("careGiver_LastName2"));

        driver.findElement(By.cssSelector(element.getString("buynow"))).click();
    }

}
