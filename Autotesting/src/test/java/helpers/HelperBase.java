package helpers;

import app.ApplicationManager;
import org.openqa.selenium.*;


public class HelperBase {
    private ApplicationManager applicationManager;
    protected WebDriver driver;
    protected String profileUrl = "https://shelly.kpfu.ru/e-ksu/main_blocks.startpage?p2=10230777776503093793281482571729&p_h=13F3CCDB08F63F1467593F2AC9FA59DB";


    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public ApplicationManager getApplicationManager() {
        return applicationManager;
    }
}