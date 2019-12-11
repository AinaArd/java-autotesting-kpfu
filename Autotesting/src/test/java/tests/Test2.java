package tests;

import helpers.AuthBase;
import org.junit.Assert;
import org.junit.Test;

public class Test2 extends AuthBase {
    private final String editElement = "КФУ";
    private final static String newName = "УГАТУ";

    @Test
    public void editElement() throws Exception {
        applicationManager.getNavigationHelper().openProfilePage();

        applicationManager.getNavigationHelper().openEducation();

        applicationManager.getEducationHelper().editEducation(editElement);

        Assert.assertNotEquals(editElement, newName);
    }
}
