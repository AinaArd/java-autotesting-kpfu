package tests;

import org.junit.Test;

public class Test3 extends TestBase {
    private final String deleteElement = "УГАТУ";

    @Test
    public void deleteElem() throws Exception {
        applicationManager.getNavigationHelper().openEducation();
        applicationManager.getEducationHelper().deleteEducation(deleteElement);
        applicationManager.getLoginHelper().logout();
    }
}
