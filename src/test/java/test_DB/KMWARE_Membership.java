package test_DB;

import org.testng.Assert;

import java.sql.SQLException;

/**
 * @author Sanjai on 03/14/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class KMWARE_Membership extends KMWARE_Orders{

    public void mp_Membership(){
        String qry_select = "SELECT * FROM mp_Membership WHERE MembershipCode = '" + membershipCode + "'";
        Log.info("[mp_Membership] Query Selected for: " + qry_select);

        try {
            kmware_resultSet = kmware_statement.executeQuery(qry_select);

            while (kmware_resultSet.next()){
                try {
                    String act_PassTypeCode = kmware_resultSet.getString("PassTypeCode");
                    Assert.assertEquals(act_PassTypeCode.trim().replace("              ", ""), passTypeCode);
                    Log.info("[mp_Membership] Tested PassTypeCode: " + act_PassTypeCode);
                } catch (Throwable t){
                    Log.error("[mp_Membership] Exception on PassTypeCode: " + t.getMessage());
                }

                try {
                    String act_ChildCount = kmware_resultSet.getString("ChildCount");
                    Assert.assertEquals(Integer.parseInt(act_ChildCount), childCount);
                    Log.info("[mp_Membership] Tested ChildCount: " + act_ChildCount);
                } catch (Throwable t){
                    Log.error("[mp_Membership] Exception on ChildCount: " + t.getMessage());
                }

                try {
                    String extraCard = kmware_resultSet.getString("ExtraCardPrintCount");
                    if (!extraCard.isEmpty()){
                        Log.info("[mp_Membership] Tested ExtraCardPrintCount: " + extraCard);
                    } else {
                        Log.error("[mp_Membership] ExtraCardPrintCount column is empty");
                    }
                } catch (Throwable t){
                    Log.error("[mp_Membership] Exception on ExtraCardPrintCount: " + t.getMessage());
                }

            }

        } catch (SQLException e){
            Log.error("[mp_Membership] Exception on getting details of mp_Membership table: " + e.getMessage());
        }
    }

    public void mp_MembershipCCDetail(){
        String qry_select = "SELECT * FROM mp_MembershipCCDetail WHERE MembershipCode = '" + membershipCode + "'";
        Log.info("[mp_MembershipCCDetail] Query Selected for: " + qry_select);

        try {
            kmware_resultSet = kmware_statement.executeQuery(qry_select);

            while (kmware_resultSet.next()){
                try {
                    String transactionId = kmware_resultSet.getString("TransactionId");
                    Assert.assertEquals(transactionId, salesTransactionId);
                    Log.info("[mp_MembershipCCDetail] Tested Membership TransactionId: " + transactionId);
                }catch (Throwable t){
                    Log.error("[mp_MembershipCCDetail] Exception on TransactionId: " + t.getMessage());
                }

                try {
                    String cardNumber = kmware_resultSet.getString("CardNumber");
                    Assert.assertEquals(cardNumber, "6781");
                    Log.info("[mp_MembershipCCDetail] Tested Membership CardNumber: " + cardNumber);
                } catch (Throwable t){
                    Log.error("[mp_MembershipCCDetail] Exception on CardNumber: " + t.getMessage());
                }

                try {
                    String amount = kmware_resultSet.getString("Amount");
                    if (!amount.isEmpty()){
                        Log.info("[mp_MembershipCCDetail] Tested Membership Amount: " + amount);
                    } else {
                        Log.error("[mp_Membership] Amount column is empty");
                    }
                } catch (Throwable t){
                    Log.error("[mp_MembershipCCDetail] Exception on Amount: " + t.getMessage());
                }
            }
        } catch (SQLException e){
            Log.error("[mp_MembershipCCDetail] Exception on getting details of mp_MembershipCCDetail table: " + e.getMessage());
        }
    }
}
