package tests;

import base_test.Test_Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Screen_Shot;

/**
 * @author Sanjai on 02/26/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class TestClass extends Test_Base {

    @Test
    public void test(){
       try {
           String qry_string = "SELECT * FROM AspNetUsers WHERE UserName = 'sanjaim@kmitsolutions.com'";
           resultSet = statement.executeQuery(qry_string);

           while (resultSet.next()){
               System.out.println("first Name: " + resultSet.getString("FirstName"));
           }

       } catch (Exception e){
           System.out.println("Title exception: " + e.getMessage());
       }
    }
}
