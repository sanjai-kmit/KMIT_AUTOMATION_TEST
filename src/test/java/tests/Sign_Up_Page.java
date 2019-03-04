package tests;

import base_test.Test_Base;
import functionality_fields.SignUp;
import org.testng.annotations.Test;

/**
 * @author Sanjai on 03/04/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Sign_Up_Page extends Test_Base {



    @Test
    public void signUp()throws Exception{
        driver.navigate().to(base_url + element.getString("signup"));
        SignUp signUp = new SignUp(driver);

        if (test_site.equals("erie")){
            signUp.firstName();
            signUp.lastName();
            signUp.phoneNumber();
            signUp.email();
            signUp.address();
            signUp.city();
            signUp.zipCode();
            signUp.password_confirmPassword();
        }

    }
}
