package tests;

import org.junit.Assert;
import org.junit.Test;

public class Test2 extends TestBase {
    private final String editElement = "КФУ";
    private final static String newName = "УГАТУ";

    @Test
    public void editElement() throws Exception {
//        applicationManager.getNavigationHelper().openProfilePage();

        applicationManager.getNavigationHelper().openEducation();

        applicationManager.getEducationHelper().editEducation(editElement);

        Assert.assertNotEquals(editElement, newName);
    }
}
