package membership_pages.erie;

import base_test.Test_Base;
import functionality_fields.Membership_Fields;

/**
 * @author Sanjai on 03/19/2019.
 * @project KMIT_AUTOMATION_TEST
 */
public class GrandParentPlus extends Test_Base {

    Membership_Fields membershipFields = new Membership_Fields(driver);

    public void grandParentPlus_new() throws Exception{
        membershipFields.primaryMemberName();
        membershipFields.secondaryMemberName();
        membershipFields.childCount();
        membershipFields.extraCard();
    }
}
