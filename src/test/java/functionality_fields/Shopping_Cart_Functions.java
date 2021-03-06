package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test_DB.E_Comm_DataBase;
import test_DB.KMWARE;

/**
 * @author Sanjai on 03/06/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Shopping_Cart_Functions extends Test_Base {

    WebDriver driver;

    @FindBy(css = "div.eachrow:nth-child(1) > div:nth-child(2) > span:nth-child(1)")
    WebElement get_sub_total;

    @FindBy(css = "h3.pull-right")
    WebElement get_total;

    @FindBy(css = "div.eachrow:nth-child(2) > div:nth-child(2) > span:nth-child(1)")
    WebElement get_tax;

    public Shopping_Cart_Functions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    E_Comm_DataBase eCommDataBase = new E_Comm_DataBase();

    public void shoppingCart() throws Exception{

        itemTitle = driver.findElement(By.cssSelector(element.getString("itemTitle"))).getText();

        Log.info("itemTitle: " + itemTitle);

        Log.info("Qty: " + driver.findElement(By.cssSelector("div.margin-l-r-0:nth-child(3)")).getText());

        double sub_total = 0.00;
        double total = 0.00;
        double tax = 0.00;

        if (itemTitle.toUpperCase().equals("MEMBERSHIP")){
            sub_total = Double.parseDouble(get_sub_total.getText().trim().replace("$", ""));
//            System.out.println("subTotal: " + sub_total);

            total = Double.parseDouble(get_total.getText().trim().replace("$", ""));
//            System.out.println("total: " + total);

            tax = Double.parseDouble(get_tax.getText().trim().replace("$", ""));
            System.out.println("Tax: " + tax);

            try {
                if (test_site.equals("oreo")){
                    int careGiver_total = noOf_CareGivers * 49;
                    Assert.assertEquals((eCommDataBase.memberPrice(passTypeCode) + careGiver_total), sub_total);
                    Log.info("Tested: Shopping Card - SUB-TOTAL = "   + (eCommDataBase.memberPrice(passTypeCode) + careGiver_total));
                } else {
                    Assert.assertEquals((eCommDataBase.memberPrice(passTypeCode) + 10), sub_total);
                    Log.info("Tested: Shopping Card - SUB-TOTAL = "   + (eCommDataBase.memberPrice(passTypeCode) + 10));
                }
            } catch (Throwable t){
                Log.error("Test: Shopping Cart - SUB-TOTAL Amount is not matching" + t.getMessage());
            }

            try {
                if (test_site.equals("oreo")){
                    int careGiver_total = noOf_CareGivers * 49;
                    Assert.assertEquals((eCommDataBase.memberPrice(passTypeCode) + careGiver_total + tax), sub_total);
                    Log.info("Tested: Shopping Card - TOTAL = "   + (eCommDataBase.memberPrice(passTypeCode) + careGiver_total + tax));
                } else {
                    Assert.assertEquals((eCommDataBase.memberPrice(passTypeCode) + 10 + tax), total);
                    Log.info("Tested: Shopping Cart - TOTAL = " + (eCommDataBase.memberPrice(passTypeCode) + 10 + tax));
                }
            } catch (Throwable t){
                Log.error("Test: Shopping Cart - Total Amount is not matching" + t.getMessage());
            }


        }

        Thread.sleep(2000);
        driver.findElement(By.cssSelector(element.getString("checkout"))).click();

        Billing_Info billingInfo = new Billing_Info();
        billingInfo.billingInfo();

        Payment payment = new Payment(driver);
        payment.payment();

        KMWARE kmware = new KMWARE();
        kmware.test_KMWare();
    }
}
