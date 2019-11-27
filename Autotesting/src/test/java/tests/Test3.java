package tests;

import entities.Account;
import org.junit.Test;

public class Test3 extends TestBase {
    private Account account = new Account("ARArdashirova", "u2hkip8c");
    private final String deleteElement = "УГАТУ";

    @Test
    public void deleteElem() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(account);
        applicationManager.getNavigationHelper().openProfilePage();

        applicationManager.getNavigationHelper().openEducation();

        applicationManager.getEducationHelper().deleteEducation(deleteElement);

        applicationManager.getLoginHelper().logout();

    }
}
