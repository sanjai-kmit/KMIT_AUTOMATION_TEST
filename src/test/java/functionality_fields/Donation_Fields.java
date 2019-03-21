package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

/**
 * @author Sanjai on 03/21/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Donation_Fields extends Test_Base {

    WebDriver driver;

    @FindBy(css = ".donation-input")
    WebElement otherAmount;

    @FindBy(css = "form.ng-scope > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    WebElement tributeToSomeone_YES;

    @FindBy(css = "form.ng-scope > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    WebElement tributeToSomeone_NO;

    @FindBy(css = "form.ng-scope > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    WebElement memorial;

    @FindBy(css = "form.ng-scope > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    WebElement tribute;

    public Donation_Fields(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void select_Donation()throws Exception{
        WebElement donatebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".donatincategory h4")));
        List<WebElement> donate = driver.findElements(By.cssSelector(".donatincategory h4"));
        Random random = new Random();

        int donate_count = random.nextInt(donate.size());
        String donate_name = donate.get(donate_count).getText();
        Log.info("[select_Donation] Selected Donation is: " + donate_name);
        Thread.sleep(1000);
        donate.get(donate_count).click();
    }

    public void select_donate_amount() throws Exception{
        List<WebElement> donateAmt = driver.findElements(By.cssSelector(".donation-amount .btn"));
        int btnSize = donateAmt.size();
        int otherAmt = btnSize + 1;
        System.out.println("btnSize: " + btnSize);
        System.out.println("otherAmt: " + otherAmt);


        int btn_count = random.nextInt(btnSize);
        System.out.println("btn_count: " + btn_count);

        Thread.sleep(2000);
        if (btn_count == btnSize){
            otherAmount.sendKeys("300");

        } else {
            donateAmt.get(btn_count).click();
        }
    }

    public void inMemory(){
        int in_memory = random.nextInt(1);

        if (in_memory == 0){
            tributeToSomeone_YES.click();
        } else if (in_memory == 1){
            tributeToSomeone_NO.click();
        }
    }
}
