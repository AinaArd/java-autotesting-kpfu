package tests;

import entities.Account;
import org.junit.Assert;
import org.junit.Test;

public class Test2 extends TestBase {
    private Account account = new Account("ARArdashirova", "u2hkip8c");
    private final String editElement = "КФУ";
    private final static String newName = "УГАТУ";

    @Test
    public void editElement() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(account);
        applicationManager.getNavigationHelper().openProfilePage();

        applicationManager.getNavigationHelper().openEducation();

        applicationManager.getEducationHelper().editEducation(editElement);

        Assert.assertNotEquals(editElement, newName);

        applicationManager.getLoginHelper().logout();

    }
}
