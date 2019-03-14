package test_DB;

import base_test.Test_Base;

/**
 * @author Sanjai on 03/13/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class KMWARE extends Test_Base {

    public void test_KMWare()throws Exception{
        KMWARE_Database kmware_database = new KMWARE_Database();
        kmware_database.ec_Order();
        kmware_database.ec_OrderAddress();
    }
}
