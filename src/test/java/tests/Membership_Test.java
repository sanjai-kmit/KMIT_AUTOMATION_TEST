package tests;

import base_test.Test_Base;
import functionality_fields.Membership_Function;
import functionality_fields.Shopping_Cart_Functions;
import membership_pages.OREO.Dual;
import membership_pages.OREO.FamilyDeluxe;
import membership_pages.OREO.ZooDirectorsClub;
import membership_pages.OREO.ZooKeepersClub;
import membership_pages.erie.*;
import org.openqa.selenium.By;
import test_DB.E_Comm_DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Sanjai on 03/05/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Membership_Test extends Test_Base {


    private List<String> erie_memberhips;
    private List<String> oreo_membership;

    public void membership(String membership) throws Exception{
        Log.info("Test Page: Membership");
        driver.navigate().to(base_url + element.getString("membership"));
        Log.info("Page navigated to " + driver.getCurrentUrl());

      /*  Membership_Function membership_function = new Membership_Function();
        membership_function.select_membership(membership);*/


        E_Comm_DataBase e_comm_dataBase = new E_Comm_DataBase();

        if (e_comm_dataBase.customerTypeCode().equals("Member")){
            Log.info("The User: " + exist_user + " is already a Member. You are able to renew your current Membership.");
        } else if (e_comm_dataBase.customerTypeCode().equals("RegularCustomers")) {
            if (test_site.equals("ERIE")){
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
                    } else if (passTypeCode.equals("GrandparentPlus")){
                        GrandParentPlus grandParentPlus = new GrandParentPlus();
                        grandParentPlus.grandParentPlus_new();
                    } else if (passTypeCode.equals("Grandparent")){
                        Grandparent grandparent = new Grandparent();
                        grandparent.grandParent_new();
                    } else if (passTypeCode.equals("SingleGrandparent")){
                        SingleGrandparent singleGrandparent = new SingleGrandparent();
                        singleGrandparent.singleGrandParent_new();
                    } else if (passTypeCode.equals("SingleParent")){
                        SingleParent singleParent = new SingleParent();
                        singleParent.singleParent_new();
                    } else if (passTypeCode.equals("Individual")){
                        Individual individual = new Individual();
                        individual.individual_new();
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

            if (test_site.equals("OREO")){
                Log.info("Test: OREO Membership");

                passTypeCode=  oreo_membership_list();

                if ((membership.toLowerCase()).equals("new")){
                    driver.navigate().to(base_url + "Membership/New/" + passTypeCode);
                    Log.info("Selected NEW Membership to test: " + passTypeCode);
                    Log.info("Page Navigated to: " + driver.getCurrentUrl());

                    if (passTypeCode.equals("Individual")){
                        membership_pages.OREO.Individual individual = new membership_pages.OREO.Individual();
                        individual.individual_new();
                    } else if (passTypeCode.equals("Dual")){
                        Dual dual = new Dual();
                        dual.dual_new();
                    } else if(passTypeCode.equals("Family")){
                        Family family = new Family();
                        family.family_new();
                    } else if (passTypeCode.equals("FamilyDeluxe")){
                        FamilyDeluxe familyDeluxe = new FamilyDeluxe();
                        familyDeluxe.familyDeluxe_new();
                    } else if (passTypeCode.equals("ZooDirectorsClub")){
                        ZooDirectorsClub zooDirectorsClub = new ZooDirectorsClub();
                        zooDirectorsClub.zooDirectorsClub_new();
                    } else if (passTypeCode.equals("ZooKeepersClub")){
                        ZooKeepersClub zooKeepersClub = new ZooKeepersClub();
                        zooKeepersClub.zooKeepersClub_new();
                    }

                    driver.findElement(By.cssSelector(element.getString("buynow"))).click();
                }
            }

            Shopping_Cart_Functions shopping_cart_functions = new Shopping_Cart_Functions(driver);
            shopping_cart_functions.shoppingCart();
        }


    }


    String erie_membership_list(){

        Random random = new Random();

        erie_memberhips = new ArrayList<String>();
        erie_memberhips.add("FamilyPlus");
        erie_memberhips.add("Family");
        erie_memberhips.add("GrandparentPlus");
        erie_memberhips.add("Grandparent");
        erie_memberhips.add("SingleGrandparent");
//        erie_memberhips.add("SingleParent");
        erie_memberhips.add("Individual");

        int test_member = random.nextInt(erie_memberhips.size());
        return erie_memberhips.get(test_member);
    }

    String oreo_membership_list(){
        Random random = new Random();

        oreo_membership = new ArrayList<>();
        oreo_membership.add("Individual");
        oreo_membership.add("Dual");
        oreo_membership.add("Family");
        oreo_membership.add("FamilyDeluxe");
        oreo_membership.add("ZooDirectorsClub");
        oreo_membership.add("ZooKeepersClub");

        int test_member = random.nextInt(oreo_membership.size());
        return oreo_membership.get(test_member);
    }


}
