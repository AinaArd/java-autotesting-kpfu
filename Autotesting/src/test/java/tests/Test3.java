package tests;

import helpers.AuthBase;
import org.junit.Test;

public class Test3 extends AuthBase {
    private final String deleteElement = "УГАТУ";

    @Test
    public void deleteElem() throws Exception {
        applicationManager.getNavigationHelper().openEducation();
        applicationManager.getEducationHelper().deleteEducation(deleteElement);
//        applicationManager.getLoginHelper().logout();
    }
}
