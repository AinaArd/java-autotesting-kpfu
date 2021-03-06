package helpers;

import app.ApplicationManager;
import org.openqa.selenium.*;


public class HelperBase {
    private ApplicationManager applicationManager;
    protected WebDriver driver;
    protected String profileUrl = "https://shelly.kpfu.ru/e-ksu/main_blocks.startpage";


    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public ApplicationManager getApplicationManager() {
        return applicationManager;
    }
}