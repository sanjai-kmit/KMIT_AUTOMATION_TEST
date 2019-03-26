package tests;

import base_test.Test_Base;
import functionality_fields.SignIn;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author Sanjai on 03/05/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Sign_In_Page extends Test_Base {

    public void signin() throws Exception{
        driver.navigate().to(base_url + element.getString("signin"));
        Log.info("Navigated: to signin page: " + driver.getCurrentUrl());

//        Sign up field functionality
        SignIn signIn = new SignIn(driver);
        signIn.login_validation();

        Log.info("Tested: Sign In page functionality");
    }

}
