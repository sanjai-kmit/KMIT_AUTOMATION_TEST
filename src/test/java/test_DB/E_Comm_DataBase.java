package test_DB;


import base_test.Test_Base;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sanjai on 03/05/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class E_Comm_DataBase extends Test_Base {


    public void aspNetUsers(){
        String qry_select = "SELECT * FROM AspNetUsers WHERE UserName = '" + emailId + "'";
        Log.info("Data Base Query: " + qry_select);

        try {
            Thread.sleep(5000);
            resultSet = statement.executeQuery(qry_select);
            while (resultSet.next()){
                try {
                    Assert.assertEquals(resultSet.getString("FirstName"), property.getString("firstName"));
                    Log.info("Data Base: FirstName -  Tested" );
                } catch (Throwable t){
                    Log.error("Data Base Exception on FirstName - with exception: " + t.getMessage());
                }

                try {
                    Assert.assertEquals(resultSet.getString("LastName"), property.getString("lastName"));
                    Log.info("Data Base: LastName -  Tested" );
                } catch (Throwable t){
                    Log.error("Data Base Exception on LastName: with exception: " + t.getMessage());
                }

                try {
                    if (site_with_timeStamp.contains(test_site)){
                        if (resultSet.getString("JoinDate").contains(getJoinDate())){
                            Log.info("Date Base: JoinDate - Tested");
                        } else {
                            Log.error("Exception on JoinDate of AspNetUsers");
                        }
                    } else {
                        Assert.assertEquals(resultSet.getString("JoinDate"), joinDate);
                        Log.info("Date Base: JoinDate - Tested");
                    }
                } catch (Throwable t){
                    Log.error("Data Base Exception on JoinDate: with exception: " + t.getMessage());
                }

                try {
                    Assert.assertEquals(resultSet.getString("PhoneNumber"), property.getString("phoneNumber"));
                    Log.info("Data Base: PhoneNumber - Tested");
                } catch (Throwable t){
                    Log.error("Data Base Exception on PhoneNumber: with exception: " + t.getMessage());
                }

                try {
                    Assert.assertEquals(resultSet.getString("Address1"), property.getString("addressLine_1"));
                    Log.info("Data Base: Address1 - Tested");
                } catch (Throwable t){
                    Log.error("Data Base Exception on Address1: with exception: " + t.getMessage());
                }

                try {
                    Assert.assertEquals(resultSet.getString("City"), property.getString("city"));
                    Log.info("Data Base: City - Tested");
                } catch (Throwable t){
                    Log.error("Data Base Exception on City: with exception: " + t.getMessage());
                }

                try {
                    Assert.assertEquals(resultSet.getString("PostalZipCode"), property.getString("zipcode"));
                    Log.info("Data Base: PostalZipCode - Tested");
                } catch (Throwable t){
                    Log.error("Data Base Exception on PostalZipCode: with exception: " + t.getMessage());
                }

            }

        } catch (Throwable t){
            Log.error("Data Base Exception on : " + qry_select + " with exception: " + t.getMessage());
        }
    }

    public String customerTypeCode(){
        String qry_select = null;
        if (user.equals("new")){
            qry_select = "SELECT * FROM AspNetUsers WHERE UserName = '" + emailId + "'";
        } else if (user.equals("exist")){
            qry_select = "SELECT * FROM AspNetUsers WHERE UserName = '" + exist_user + "'";
        }
//        Log.info("Data Base Querys: " + qry_select);

        String customerTypeCode = null;

        try {
            resultSet = statement.executeQuery(qry_select);

            while (resultSet.next()){
                customerTypeCode = resultSet.getString("CustomerTypeCode");
            }
        }catch (Throwable t){
            Log.error(t.getMessage());
        }

        return customerTypeCode;
    }

    public double memberPrice(String passType){
        String qry_select = "SELECT * FROM ec_PassTypeMemberPrice WHERE KMWarePassTypeCode = '" + passType + "'";
        double member_price = 0.00;
        try {
            resultSet = statement.executeQuery(qry_select);
            while (resultSet.next()){
                member_price = Double.parseDouble(resultSet.getString("Price"));
            }
        }catch (Throwable t){
            Log.error(t.getMessage());
        }

        return member_price;
    }
}
