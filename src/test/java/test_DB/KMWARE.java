package test_DB;

import base_test.Test_Base;

/**
 * @author Sanjai on 03/13/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class KMWARE extends Test_Base {

    public void test_KMWare()throws Exception{
        KMWARE_Orders kmwareOrders = new KMWARE_Orders();
        kmwareOrders.ec_Order();
        kmwareOrders.ec_OrderAddress();
    }
}
