package tests;

import entities.Education;
import helpers.AuthBase;
import org.junit.Test;

public class Test1 extends AuthBase {
    private Education education = new Education("12.11.2018", "13.11.2019", "КФУ");

    @Test
    public void test() throws Exception {
        applicationManager.getNavigationHelper().openProfilePage();

        applicationManager.getNavigationHelper().openEducation();

        applicationManager.getEducationHelper().addEducation(education);
    }
}
