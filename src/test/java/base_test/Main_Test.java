package base_test;

import functionality_fields.Billing_Info;
import functionality_fields.Payment;
import functionality_fields.Shopping_Cart_Functions;
import functionality_fields.SignIn;
import org.testng.annotations.Test;
import test_DB.E_Comm_DataBase;
import tests.Membership_Test;
import tests.Sign_In_Page;
import tests.Sign_Up_Page;

/**
 * @author Sanjai on 03/05/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Main_Test extends Test_Base{

    @Test(groups = "test.signup")
    public void test_SignUp() throws Exception{
        Sign_Up_Page signUpPage = new Sign_Up_Page();
        signUpPage.signUp();
    }

    @Test(dependsOnMethods = "test_SignUp", groups = "test.signup")
    public void test_aspNetUsers(){
        //        for DB
        Log.info("Test: Data Base");
        E_Comm_DataBase e_comm_dataBase = new E_Comm_DataBase();
        e_comm_dataBase.aspNetUsers();
    }

    @Test(groups = "test.signin", parameters = {"userName", "password"})
    public void test_SignIn(String userName, String password) throws Exception{
        Sign_In_Page signInPage = new Sign_In_Page();
        signInPage.signin(userName, password);
    }

    @Test(groups = "test.membership", parameters = {"userName", "password", "user", "membership"})
    public void test_Membership(String userName, String password, String user, String membership)throws Exception{

        if (user.equals("new")){
            test_SignUp();
            test_aspNetUsers();
        } else if (user.equals("exist")){
            test_SignIn(userName, password);
        }

        Membership_Test membership_test = new Membership_Test();
        membership_test.membership(membership);
    }
}
