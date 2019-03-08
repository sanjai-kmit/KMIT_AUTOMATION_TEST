package functionality_fields;

import base_test.Test_Base;
import membership_pages.Family;
import membership_pages.FamilyPlus;
import org.openqa.selenium.By;
import test_DB.E_Comm_DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Sanjai on 03/06/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Membership_Function extends Test_Base {

    private List<String> erie_memberhips;
//    private String get_membership;

    public void select_membership(String membership) throws Exception{

        E_Comm_DataBase e_comm_dataBase = new E_Comm_DataBase();

        if (e_comm_dataBase.customerTypeCode().equals("Member")){
            Log.info("The User: " + exist_user + " is already a Member. Kindly get Non-Member user for testing.");
        } else if (e_comm_dataBase.customerTypeCode().equals("RegularCustomers")) {
            if (test_site.equals("erie")){
                Log.info("Test: ERIE Membership");

                passTypeCode = erie_membership_list();

                if ((membership.toLowerCase()).equals("new")){

                    driver.navigate().to(base_url + "Membership/New/" + passTypeCode);
                    Log.info("Selected NEW Membership to test: " + passTypeCode);
                    Log.info("Page Navigated to : " + driver.getCurrentUrl());

                    if (passTypeCode.equals("FamilyPlus")){
                        FamilyPlus familyPlus = new FamilyPlus();
                        familyPlus.familyPlus_New();
                    } else if (passTypeCode.equals("Family")){
                        Family family = new Family();
                        family.family_new();
                    }

                    driver.findElement(By.cssSelector(element.getString("buynow"))).click();


                } else if ((membership.toLowerCase()).equals("gift")){
                    driver.navigate().to(base_url + "Membership/Gift/" + passTypeCode);
                    Log.info("Selected GIFT Membership to test: " + passTypeCode);
                } else if ((membership.toLowerCase()).equals("renew")){
                    driver.navigate().to(base_url + "Membership/Renew/" + passTypeCode);
                    Log.info("Selected Membership to Renew: " + passTypeCode);
                }
            }

            Shopping_Cart_Functions shopping_cart_functions = new Shopping_Cart_Functions(driver);
            shopping_cart_functions.shoppingCart(passTypeCode);
        }
    }



    String erie_membership_list(){

        Random random = new Random();

        erie_memberhips = new ArrayList<String>();
        erie_memberhips.add("FamilyPlus");
        erie_memberhips.add("Family");
/*        erie_memberhips.add("GrandparentPlus");
        erie_memberhips.add("Grandparent");
        erie_memberhips.add("SingleGrandparent");
        erie_memberhips.add("SingleParent");
        erie_memberhips.add("Individual");*/

        int test_member = random.nextInt(erie_memberhips.size());
        return erie_memberhips.get(test_member);
    }
}
