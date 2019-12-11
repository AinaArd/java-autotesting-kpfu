package tests;

import entities.Account;
import entities.Education;
import helpers.AuthBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test4 extends AuthBase {
    private Account account = new Account("ARArdashirova", "u2hkip8c");

    @BeforeTest
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test(dataProvider = "data-provider")
    public void testCollection(String dateStart, String dateEnd, String organization) throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(account);
        applicationManager.getNavigationHelper().openProfilePage();
        applicationManager.getDriver().findElement(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[3]")).click();

        Education education = new Education(dateStart, dateEnd, organization);

        applicationManager.getNavigationHelper().openEducation();
        applicationManager.getEducationHelper().addEducation(education);
        applicationManager.getLoginHelper().logout();
    }
}
