package tests;

import entities.Account;
import entities.Education;
import org.junit.Test;

public class Test2 extends TestBase {
    private Account account = new Account("ARArdashirova", "u2hkip8c");
    private Education education = new Education("12.11.2018", "13.11.2019", "TEST");

    @Test
    public void deleteElem() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(account);
        applicationManager.getNavigationHelper().openProfilePage();

        applicationManager.getNavigationHelper().openEducation();
        applicationManager.getEducationHelper().addEducation(education);
//        applicationManager.getEducationHelper().testCheckExist();

        applicationManager.getEducationHelper().deleteEducation(education.getOrganization());

        applicationManager.getLoginHelper().logout();

    }
}
