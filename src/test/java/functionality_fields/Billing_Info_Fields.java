package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

/**
 * @author Sanjai on 03/08/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Billing_Info_Fields  extends Test_Base {

    WebDriver driver;

    @FindBy(id = "checkTerms")
    WebElement checkTerms;

    @FindBy(name = "billingfirstname")
    WebElement billingfirstname;

    @FindBy(name = "billingmiddlename")
    WebElement billingmiddlename;

    @FindBy(name = "billinglastname")
    WebElement billinglastname;

    @FindBy(name = "billingaddress1")
    WebElement billingaddress1;

    @FindBy(name = "billingcity")
    WebElement billingcity;

    @FindBy(name = "billingstate")
    WebElement billingstate;

    @FindBy(css = "div.padding-r-0:nth-child(3) > div:nth-child(1) > input:nth-child(1)")
    WebElement oreo_billingState;

    @FindBy(name = "billingcountry")
    WebElement billingcountry;

    @FindBy(css = "div.padding-r-0:nth-child(3) > select:nth-child(2)")
    WebElement oreo_billingCountry;

    @FindBy(name = "billingzipcode1")
    WebElement billingzipcode1;

    @FindBy(name = "billingphoneno")
    WebElement billingphoneno;

    @FindBy(name = "billingemail")
    WebElement billingemail;

    @FindBy(id = "checkSameBillingAndMailing")
    WebElement checkSameBillingAndMailing;

    @FindBy(name = "firstname")
    WebElement mailing_firstname;

    @FindBy(name = "lastname")
    WebElement mailing_lastname;

    @FindBy(name = "address1")
    WebElement mailing_address1;

    @FindBy(name = "city")
    WebElement mailing_city;

    @FindBy(name = "mailingstate")
    WebElement mailingstate;

    @FindBy(css = "div.col-md-6:nth-child(4) > div:nth-child(1) > input:nth-child(1)")
    WebElement oreo_mailingState;

    @FindBy(name = "mailingCountry")
    WebElement mailingCountry;

    @FindBy(css = "select.ng-pristine:nth-child(2)")
    WebElement oreo_mailingCountry;

    @FindBy(name = "zipcode1")
    WebElement mailing_zipcode1;

    @FindBy(name = "phoneno")
    WebElement mailing_phoneno;

    @FindBy(name = "email")
    WebElement mailing_email;



    public Billing_Info_Fields(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        checkTerms.click();
    }


    public void setBillingFirstName(){
        billingfirstname.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingFirstname_error"))).getText(), property.getString("billingFirstname_error"));
        } catch (Throwable t){
            Log.error("Billing Info - First Name field error message is not proper: " + t.getMessage());
        }
        billingfirstname.sendKeys(property.getString("billing_firstName"));
        Log.info("Tested: Billing Info: First Name field, with value: " + property.getString("billing_firstName"));
    }

    public void setMailingFirstName(){
        mailing_firstname.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingFirstname_error"))).getText(), property.getString("billingFirstname_error"));
        } catch (Throwable t){
            Log.error("Mailing Info - First Name field error message is not proper: " + t.getMessage());
        }
        mailing_firstname.sendKeys(property.getString("mailing_firstName"));
        Log.info("Tested: Mailing Info: First Name field, with value: " + property.getString("mailing_firstName"));
    }

    public void setBillingLastName(){
        billinglastname.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingLastName_error"))).getText(), property.getString("billingLastName_error"));
        } catch (Throwable t){
            Log.error("Billing Info - Last Name field error message is not proper: " + t.getMessage());
        }
        billinglastname.sendKeys(property.getString("billing_lastName"));
        Log.info("Tested: Billing Info: Last Name field, with value: " + property.getString("billing_lastName"));
    }

    public void setMailingLastName(){
        mailing_lastname.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingLastName_error"))).getText(), property.getString("billingLastName_error"));
        } catch (Throwable t){
            Log.error("Mailing Info - Last Name field error message is not proper: " + t.getMessage());
        }
        mailing_lastname.sendKeys(property.getString("mailing_lastName"));
        Log.info("Tested: Mailing Info: Last Name field, with value: " + property.getString("mailing_lastName"));
    }

    public void setBillingAddress1(){
        billingaddress1.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingAddress_error"))).getText(), property.getString("billingAddress_error"));
        } catch (Throwable t){
            Log.error("Billing Info - Address field error message is not proper: " + t.getMessage());
        }
        billingaddress1.sendKeys(property.getString("billing_addressLine_1"));
        Log.info("Tested: Billing Info: Address field, with value: " + property.getString("billing_addressLine_1"));
    }

    public void setMailingAddress1(){
        mailing_address1.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingAddress_error"))).getText(), property.getString("billingAddress_error"));
        } catch (Throwable t){
            Log.error("Mailing Info - Address field error message is not proper: " + t.getMessage());
        }
        mailing_address1.sendKeys(property.getString("mailing_addressLine_1"));
        Log.info("Tested: Mailing Info: Address field, with value: " + property.getString("mailing_addressLine_1"));
    }

    public void setBillingCity(){
        billingcity.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingCity_error"))).getText(), property.getString("billingCity_error"));
        } catch (Throwable t){
            Log.error("Billing Info - City field error message is not proper: " + t.getMessage());
        }
        billingcity.sendKeys(property.getString("billing_city"));
        Log.info("Tested: Billing Info: City field, with value: " + property.getString("billing_city"));
    }

    public void setMailingCity(){
        mailing_city.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingCity_error"))).getText(), property.getString("billingCity_error"));
        } catch (Throwable t){
            Log.error("Mailing Info - City field error message is not proper: " + t.getMessage());
        }
        mailing_city.sendKeys(property.getString("mailing_city"));
        Log.info("Tested: Mailing Info: City field, with value: " + property.getString("mailing_city"));
    }

    public void setBilling_state_country(){
        Random random = new Random();

        Select country;
        if (test_site.equals("OREO")){
            country = new Select(oreo_billingCountry);
        } else {
             country = new Select(billingcountry);
        }
        country.selectByIndex(random.nextInt(33));
//        country.selectByValue("USA");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            if (test_site.equals("OREO")){
                oreo_billingState.clear();
            }else {
                billingstate.clear();
            }

            driver.findElement(By.cssSelector(element.getString("paynow"))).click();
            try {
                Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingState_error"))).getText(), property.getString("billingState_error"));
            } catch (Throwable t){
                Log.error("Billing Info - State field error message is not proper: " + t.getMessage());
            }
            if (test_site.equals("OREO")){
                oreo_billingState.sendKeys(property.getString("billing_state"));
            } else {
                billingstate.sendKeys(property.getString("billing_state"));
            }

            Log.info("Tested: Billing Info: State field, with value: " + property.getString("billing_state"));
        } catch (Exception e){
            Select state;
            if (test_site.equals("OREO")){
                state = new Select(oreo_billingState);
            } else {
                state = new Select(billingstate);
            }

            state.selectByIndex(1 + random.nextInt(53));
            Log.info("Tested: Billing Info - State Field");
        }
    }

    public void setMailing_state_country(){
        Random random = new Random();

        Select country;
        if (test_site.equals("OREO")){
            country = new Select(oreo_mailingCountry);
        }else {
            country = new Select(mailingCountry);
        }
        country.selectByIndex(random.nextInt(33));
//        country.selectByValue("USA");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            if (test_site.equals("OREO")){
                oreo_mailingState.clear();
            } else {
                mailingstate.clear();
            }

            driver.findElement(By.cssSelector(element.getString("paynow"))).click();

            try {
                Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingState_error"))).getText(), property.getString("billingState_error"));
            } catch (Throwable t){
                Log.error("Mailing Info - State field error message is not proper: " + t.getMessage());
            }

            if (test_site.equals("OREO")){
                oreo_mailingState.sendKeys(property.getString("mailing_state"));
            } else {
                mailingstate.sendKeys(property.getString("mailing_state"));
            }

            Log.info("Tested: Mailing Info: State field, with value: " + property.getString("mailing_state"));
        } catch (Exception e){
            Select state;
            if (test_site.equals("OREO")){
                state = new Select(oreo_mailingState);
            } else {
                state = new Select(mailingstate);
            }
            state.selectByIndex(1 + random.nextInt(53));
            Log.info("Tested: Mailing Info - State Field");
        }
    }

    public void setBillingZipCode(){
        billingzipcode1.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingZipCode_empty_error"))).getText(), property.getString("billingZipCode_empty_error"));
        }catch (Throwable t){
            Log.error("Billing Zip code validation message is not proper for Empty field: " + t.getMessage());
        }

        billingzipcode1.clear();
        billingzipcode1.sendKeys("1");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingZipCode_invalid_error"))).getText(), property.getString("billingZipCode_invalid_error"));
        }catch (Throwable t){
            Log.error("Billing Zip code validation message is not proper for Invalid data: " + t.getMessage());
        }

        billingzipcode1.clear();
        billingzipcode1.sendKeys(property.getString("billing_zipcode"));
        Log.info("Tested: Billing ZipCode field, with value = " + property.getString("billing_zipcode"));
    }

    public void setMailingZipCode(){
        mailing_zipcode1.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingZipCode_empty_error"))).getText(), property.getString("billingZipCode_empty_error"));
        }catch (Throwable t){
            Log.error("Mailing Zip code validation message is not proper for Empty field: " + t.getMessage());
        }

        mailing_zipcode1.clear();
        mailing_zipcode1.sendKeys("1");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingZipCode_invalid_error"))).getText(), property.getString("billingZipCode_invalid_error"));
        }catch (Throwable t){
            Log.error("Mailing Zip code validation message is not proper for Invalid data: " + t.getMessage());
        }

        mailing_zipcode1.clear();
        mailing_zipcode1.sendKeys(property.getString("mailing_zipcode"));
        Log.info("Tested: Mailing ZipCode field, with value = " + property.getString("mailing_zipcode"));
    }

    public void setBillingPhoneNO(){
        billingphoneno.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingPhoneNumber_empty_error"))).getText(), property.getString("billingPhoneNumber_empty_error"));
        }catch (Throwable t){
            Log.error("Billing Phone Number Field validation message is not proper for Empty field: " + t.getMessage());
        }

        billingphoneno.clear();
        billingphoneno.sendKeys("12345");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingPhoneNumber_invalid_error"))).getText(), property.getString("billingPhoneNumber_invalid_error"));
        }catch (Throwable t){
            Log.error("Billing Phone Number Field validation message is not proper for Invalid data: " + t.getMessage());
        }

        billingphoneno.clear();
        billingphoneno.sendKeys(property.getString("billing_phoneNumber"));
        Log.info("Tested: Billing Phone Number Field, with value: " + property.getString("billing_phoneNumber"));
    }

    public void setMailingPhoneNO(){
        mailing_phoneno.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingPhoneNumber_empty_error"))).getText(), property.getString("billingPhoneNumber_empty_error"));
        }catch (Throwable t){
            Log.error("Mailing Phone Number Field validation message is not proper for Empty field: " + t.getMessage());
        }

        mailing_phoneno.clear();
        mailing_phoneno.sendKeys("12345");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingPhoneNumber_invalid_error"))).getText(), property.getString("billingPhoneNumber_invalid_error"));
        }catch (Throwable t){
            Log.error("Mailing Phone Number Field validation message is not proper for Invalid data: " + t.getMessage());
        }

        mailing_phoneno.clear();
        mailing_phoneno.sendKeys(property.getString("mailing_phoneNumber"));
        Log.info("Tested: Mailing Phone Number Field, with value: " + property.getString("mailing_phoneNumber"));
    }

    public void setBillingEmailId(){
        billingemail.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingEmail_empty_error"))).getText(), property.getString("billingEmail_empty_error"));
        }catch (Throwable t){
            Log.error("Billing Email Field validation message is not proper for Empty field: " + t.getMessage());
        }

        billingemail.clear();
        billingemail.sendKeys("testtest");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("billingEmail_invalid_error"))).getText(), property.getString("billingEmail_invalid_error"));
        }catch (Throwable t){
            Log.error("Billing Email Field validation message is not proper for Invalid field: " + t.getMessage());
        }

        billingemail.clear();

        if (user.equals("new")){
            billingemail.sendKeys(emailId);
            Log.info("Tested: Billing Email Field Field, with value: " + emailId);
        } else {
            billingemail.sendKeys(exist_user);
            Log.info("Tested: Billing Email Field Field, with value: " + exist_user);
        }
    }

    public void setMailingEmailId(){
        mailing_email.clear();
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingEmail_empty_error"))).getText(), property.getString("billingEmail_empty_error"));
        }catch (Throwable t){
            Log.error("Mailing Email Field validation message is not proper for Empty field: " + t.getMessage());
        }

        mailing_email.clear();
        mailing_email.sendKeys("testtest");
        driver.findElement(By.cssSelector(element.getString("paynow"))).click();
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector(element.getString("mailingEmail_invalid_error"))).getText(), property.getString("billingEmail_invalid_error"));
        }catch (Throwable t){
            Log.error("Mailing Email Field validation message is not proper for Invalid field: " + t.getMessage());
        }

        mailing_email.clear();

        if (user.equals("new")){
            mailing_email.sendKeys(emailId);
            Log.info("Tested: Mailing Email Field Field, with value: " + emailId);
        } else {
            mailing_email.sendKeys(exist_user);
            Log.info("Tested: Mailing Email Field Field, with value: " + exist_user);
        }
    }

    public void setSameBillingMailing(){
        if (checkSameBillingAndMailing.isSelected()){
            checkSameBillingAndMailing.click();
        }
    }
}
