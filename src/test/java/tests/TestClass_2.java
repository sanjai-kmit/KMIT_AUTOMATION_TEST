package tests;

import base_test.Test_Base;
import org.testng.annotations.Test;

/**
 * @author Sanjai on 02/26/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class TestClass_2 extends Test_Base {

    @Test
    public void method_2() throws Exception{
        String qry_string = "SELECT * FROM ec_TicketPrice WHERE KMWareVisitorTypeCode = 'Adult' AND KMWareTicketCode LIKE '%Admission%'" ;

        resultSet = statement.executeQuery(qry_string);

        while (resultSet.next()){
            System.out.println("Non Member Price: " +  resultSet.getString("NonMemberPrice"));
        }
    }

}
