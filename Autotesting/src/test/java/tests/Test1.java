package tests;

import entities.Account;
import entities.Education;
import org.junit.*;

public class Test1 extends TestBase {
    private Account account = new Account("ARArdashirova", "u2hkip8c");
    private Education education = new Education("12.11.2018", "13.11.2019", "КФУ");

    @Test
    public void test() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(account);
        applicationManager.getNavigationHelper().openProfilePage();

        applicationManager.getNavigationHelper().openEducation();
        applicationManager.getEducationHelper().addEducation(education);
        applicationManager.getEducationHelper().testCheckExist(education.getOrganization());

        applicationManager.getLoginHelper().logout();
    }
}
