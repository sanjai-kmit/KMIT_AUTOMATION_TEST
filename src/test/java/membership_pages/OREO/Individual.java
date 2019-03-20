package membership_pages.OREO;

import base_test.Test_Base;
import functionality_fields.Membership_Fields;

/**
 * @author Sanjai on 03/20/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class Individual extends Test_Base {

    Membership_Fields membershipFields = new Membership_Fields(driver);

    public void individual_new() throws Exception{
        membershipFields.primaryMemberName();
        membershipFields.setCareGiver();
    }
}
