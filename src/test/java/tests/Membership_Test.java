package tests;

import base_test.Test_Base;
import functionality_fields.Membership_Function;

/**
 * @author Sanjai on 03/05/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Membership_Test extends Test_Base {

    public void membership(String membership) throws Exception{
        Log.info("Test Page: Membership");
        driver.navigate().to(base_url + element.getString("membership"));
        Log.info("Page navigated to " + driver.getCurrentUrl());

        Membership_Function membership_function = new Membership_Function();
        membership_function.select_membership(membership);


    }



}
