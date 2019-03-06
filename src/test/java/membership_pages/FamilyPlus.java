package membership_pages;

import base_test.Test_Base;
import functionality_fields.Membership_Fields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sanjai on 03/06/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class FamilyPlus extends Test_Base {


    Membership_Fields membershipFields = new Membership_Fields(driver);


    public void familyPlus_New(){
        membershipFields.primaryMemberName();
        membershipFields.secondaryMemberName();
        membershipFields.childCount();

        driver.findElement(By.cssSelector(element.getString("buynow"))).click();

    }
}
