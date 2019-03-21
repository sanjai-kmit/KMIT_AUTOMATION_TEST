package tests;

import base_test.Test_Base;
import functionality_fields.Donation_Fields;

/**
 * @author Sanjai on 03/21/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Donation extends Test_Base {

    public void donation() throws Exception{

        driver.navigate().to(base_url + element.getString("donation"));

        Donation_Fields donation_fields = new Donation_Fields(driver);
        donation_fields.select_Donation();
        donation_fields.select_donate_amount();
        donation_fields.inMemory();
    }
}
