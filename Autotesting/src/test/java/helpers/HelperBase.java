package helpers;

import app.ApplicationManager;
import org.openqa.selenium.*;


public class HelperBase {
    private ApplicationManager applicationManager;
    protected WebDriver driver;


    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public ApplicationManager getApplicationManager() {
        return applicationManager;
    }
}