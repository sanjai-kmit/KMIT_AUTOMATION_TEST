package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sanjai on 03/12/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Payment extends Test_Base {

    WebDriver driver;

    @FindBy(id = "txtCardNumber")
    WebElement CardNumber;

    @FindBy(id = "txtExpirationDate")
    WebElement ExpirationDate;

    @FindBy(id = "txtCSCValue")
    WebElement CSCValue;

    @FindBy(id = "btnPayment")
    WebElement btnPayment;

    public Payment (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void payment(){
        CardNumber.sendKeys("5499990123456781");
        Log.info("payment Method: Card Number with value: 5499990123456781");

        ExpirationDate.sendKeys("1219");
        Log.info("payment Method: Expiration Date value: 1219");

        CSCValue.sendKeys("123");
        Log.info("payment Method: CSV Value: 123");

        btnPayment.click();
        Log.info("payment Method: Pay Now button clicked");

        WebDriverWait wait = new WebDriverWait(driver, 60);
        try {
            WebElement orderNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element.getString("orderNo"))));
            order_number = orderNo.getText();
            Log.info("payment method: Payment Completed and the Order Number is: " + order_number);
        } catch (ElementNotVisibleException e){
            Log.error("payment Method: Order Number element locator not visible." + e.getMessage());
        } catch (Exception e){
            Log.error(e.getMessage());
        }

    }
}
