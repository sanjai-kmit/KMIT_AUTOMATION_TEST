package functionality_fields;

import base_test.Test_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Sanjai on 03/08/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Billing_Info extends Test_Base {

    Billing_Info_Fields billingInfoFields = new Billing_Info_Fields(driver);


    public void billingInfo(){
        billingInfoFields.setBillingFirstName();
        billingInfoFields.setBillingLastName();
        billingInfoFields.setBillingAddress1();
        billingInfoFields.setBillingCity();
        billingInfoFields.setBilling_state_country();
        billingInfoFields.setBillingZipCode();
        billingInfoFields.setBillingPhoneNO();
        billingInfoFields.setBillingEmailId();

        billingInfoFields.setSameBillingMailing();

        billingInfoFields.setMailingFirstName();
        billingInfoFields.setMailingLastName();
        billingInfoFields.setMailingAddress1();
        billingInfoFields.setMailingCity();
        billingInfoFields.setMailing_state_country();
        billingInfoFields.setMailingZipCode();
        billingInfoFields.setMailingPhoneNO();
        billingInfoFields.setMailingEmailId();


    }
}
