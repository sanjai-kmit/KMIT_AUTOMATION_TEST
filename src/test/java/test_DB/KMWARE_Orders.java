package test_DB;

import base_test.Test_Base;
import org.testng.Assert;

import java.sql.SQLException;

/**
 * @author Sanjai on 03/14/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class KMWARE_Orders extends Test_Base {

    public void ec_Order() throws Exception{
        String qry_select = "SELECT * FROM ec_Order WHERE OrderId = '" + order_number + "'";
        Log.info("kmware_OrderDetails: Query Selected for: " + qry_select);

        try {
            Thread.sleep(5000);
            kmware_resultSet = kmware_statement.executeQuery(qry_select);

            while (kmware_resultSet.next()){

                try {
                    String act_UserName = kmware_resultSet.getString("UserName");
                    if (user.equals("new")){
                        Assert.assertEquals(act_UserName, emailId);
                    } else if (user.equals("exist")){
                        Assert.assertEquals(act_UserName, exist_user);
                    }
                    Log.info("[ec_Order] Tested UserName: " + act_UserName);
                }catch (SQLException e){
                    Log.error("[ec_Order] UserName Exception: " + e.getMessage());
                }

                try {
                    String act_paymentType = kmware_resultSet.getString("PaymentType");
                    Assert.assertEquals(act_paymentType, "Credit");
                    Log.info("[ec_Order] Tested PaymentType: " + act_paymentType);
                }catch (SQLException e){
                    Log.error("[ec_Order] PaymentType Exception: " + e.getMessage());
                }

            }
        } catch (SQLException e){
            Log.error(getClass().getEnclosingClass().getName() + ": Exception on ec_Order");
        }
    }

    public void ec_OrderAddress(){
        String billing_address = "SELECT * FROM ec_OrderAddress WHERE OrderId = '" + order_number + "'  and CustomerAddressType = 'Billing'";
        Log.info("[ec_OrderAddress] Query Selected for: " + billing_address);

        try {
            kmware_resultSet = kmware_statement.executeQuery(billing_address);

            while (kmware_resultSet.next()){

                try {
                    String act_billing_Address1 = kmware_resultSet.getString("Address1");
                    Assert.assertEquals(act_billing_Address1, property.getString("billing_addressLine_1"));
                    Log.info("[ec_OrderAddress] Tested Billing Address1: " + act_billing_Address1);
                }catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing Address1 Exception: " + e.getMessage());
                }

                try {
                    String act_billing_city = kmware_resultSet.getString("City");
                    Assert.assertEquals(act_billing_city, property.getString("billing_city"));
                    Log.info("[ec_OrderAddress] Tested Billing City: " + act_billing_city);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing City Exception: " + e.getMessage());
                }

                try {
                    String act_billing_state = kmware_resultSet.getString("State");
                    Assert.assertEquals(act_billing_state, property.getString("billing_state"));
                    Log.info("[ec_OrderAddress] Tested Billing State: " + act_billing_state);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing State Exception: " + e.getMessage());
                }

                try {
                    String act_billing_country = kmware_resultSet.getString("Country");
                    if (!kmware_resultSet.getString("Country").isEmpty()){
                        Log.info("[ec_OrderAddress] Tested Billing Country: " + act_billing_country);
                    }else {
                        Log.error("[ec_OrderAddress] Billing Country Is Empty.");
                    }
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing Country Exception: " + e.getMessage());
                }

                try {
                    String act_billing_zipCode = kmware_resultSet.getString("PostalZipcode");
                    Assert.assertEquals(act_billing_zipCode, property.getString("billing_zipcode"));
                    Log.info("[ec_OrderAddress] Tested Billing PostalZipcode: " + act_billing_zipCode);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing PostalZipcode Exception: " + e.getMessage());
                }

                try {
                    String act_billing_contactEmail = kmware_resultSet.getString("ContactEmail");
                    if (user.equals("new")){
                        Assert.assertEquals(act_billing_contactEmail, emailId);
                    } else if (user.equals("exist")){
                        Assert.assertEquals(act_billing_contactEmail, exist_user);
                    }
                    Log.info("[ec_OrderAddress] Tested Billing ContactEmail: " + act_billing_contactEmail);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing ContactEmail Exception: " + e.getMessage());
                }

                try {
                    String act_billing_firstName = kmware_resultSet.getString("FirstName");
                    Assert.assertEquals(act_billing_firstName, property.getString("billing_firstName"));
                    Log.info("[ec_OrderAddress] Tested Billing FirstName: " + act_billing_firstName);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing FirstName Exception: " + e.getMessage());
                }

                try {
                    String act_billing_lastName = kmware_resultSet.getString("LastName");
                    Assert.assertEquals(act_billing_lastName, property.getString("billing_lastName"));
                    Log.info("[ec_OrderAddress] Tested Billing LastName: " + act_billing_lastName);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Billing LastName Exception: " + e.getMessage());
                }
            }

        } catch (SQLException e){
            Log.error("[ec_OrderAddress]: Exception on getting details of ec_Order table: " + e.getMessage());
        }

        String mailing_address = "SELECT * FROM ec_OrderAddress WHERE OrderId = '" + order_number + "'  and CustomerAddressType = 'Mailing'";
        Log.info("[ec_OrderAddress] Query Selected for: " + mailing_address);

        try {
            kmware_resultSet = kmware_statement.executeQuery(mailing_address);

            while (kmware_resultSet.next()){
                try {
                    String act_mailing_Address1 = kmware_resultSet.getString("Address1");
                    Assert.assertEquals(act_mailing_Address1, property.getString("mailing_addressLine_1"));
                    Log.info("[ec_OrderAddress] Tested Mailing Address1: " + act_mailing_Address1);
                }catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing Address1 Exception: " + e.getMessage());
                }

                try {
                    String act_mailing_city = kmware_resultSet.getString("City");
                    Assert.assertEquals(act_mailing_city, property.getString("mailing_city"));
                    Log.info("[ec_OrderAddress] Tested Mailing City: " + act_mailing_city);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing City Exception: " + e.getMessage());
                }

                try {
                    String act_mailing_state = kmware_resultSet.getString("State");
                    Assert.assertEquals(act_mailing_state, property.getString("mailing_state"));
                    Log.info("[ec_OrderAddress] Tested Mailing State: " + act_mailing_state);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing State Exception: " + e.getMessage());
                }

                try {
                    String act_mailing_country = kmware_resultSet.getString("Country");
                    if (!kmware_resultSet.getString("Country").isEmpty()){
                        Log.info("[ec_OrderAddress] Tested Mailing Country: " + act_mailing_country);
                    }else {
                        Log.error("[ec_OrderAddress] Mailing Country Is Empty.");
                    }
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing Country Exception: " + e.getMessage());
                }

                try {
                    String act_mailing_zipCode = kmware_resultSet.getString("PostalZipcode");
                    Assert.assertEquals(act_mailing_zipCode, property.getString("mailing_zipcode"));
                    Log.info("[ec_OrderAddress] Tested Mailing PostalZipcode: " + act_mailing_zipCode);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing PostalZipcode Exception: " + e.getMessage());
                }

                try {
                    String act_mailing_contactEmail = kmware_resultSet.getString("ContactEmail");
                    if (user.equals("new")){
                        Assert.assertEquals(act_mailing_contactEmail, emailId);
                    } else if (user.equals("exist")){
                        Assert.assertEquals(act_mailing_contactEmail, exist_user);
                    }
                    Log.info("[ec_OrderAddress] Tested Mailing ContactEmail: " + act_mailing_contactEmail);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing ContactEmail Exception: " + e.getMessage());
                }

                try {
                    String act_mailing_firstName = kmware_resultSet.getString("FirstName");
                    Assert.assertEquals(act_mailing_firstName, property.getString("mailing_firstName"));
                    Log.info("[ec_OrderAddress] Tested Mailing FirstName: " + act_mailing_firstName);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing FirstName Exception: " + e.getMessage());
                }

                try {
                    String act_mailing_lastName = kmware_resultSet.getString("LastName");
                    Assert.assertEquals(act_mailing_lastName, property.getString("mailing_lastName"));
                    Log.info("[ec_OrderAddress] Tested Mailing LastName: " + act_mailing_lastName);
                } catch (SQLException e){
                    Log.error("[ec_OrderAddress] Mailing LastName Exception: " + e.getMessage());
                }

            }
        } catch (SQLException e){
            Log.error("[ec_OrderAddress]: Exception on getting details of ec_Order table: " + e.getMessage());
        }

    }
}
