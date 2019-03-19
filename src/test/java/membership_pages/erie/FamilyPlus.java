package membership_pages.erie;

import base_test.Test_Base;
import functionality_fields.Membership_Fields;
import functionality_fields.Shopping_Cart_Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test_DB.E_Comm_DataBase;

import java.lang.reflect.Method;

/**
 * @author Sanjai on 03/06/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class FamilyPlus extends Test_Base {


    Membership_Fields membershipFields = new Membership_Fields(driver);


    public void familyPlus_New() throws Exception{
        membershipFields.primaryMemberName();
        membershipFields.secondaryMemberName();
        membershipFields.childCount();
        membershipFields.extraCard();
    }


}
