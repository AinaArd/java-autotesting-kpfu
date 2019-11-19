package app;

import helpers.EducationHelper;
import helpers.LoginHelper;
import helpers.NavigationHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {
    private final static String DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final static String PATH_PROPERTY = "C:/Programming/chromedriver1.exe";

    private WebDriver driver;
    private String baseUrl;
    private StringBuilder verificationErrors;

    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private EducationHelper educationHelper;

    public ApplicationManager() {
        System.setProperty(DRIVER_PROPERTY, PATH_PROPERTY);
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        verificationErrors = new StringBuilder();
        navigationHelper = new NavigationHelper(this, baseUrl);
        loginHelper = new LoginHelper(this);
        educationHelper = new EducationHelper(this);
    }

    public void close() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public EducationHelper getEducationHelper() {
        return educationHelper;
    }

    public StringBuilder getVerificationErrors() {
        return verificationErrors;
    }
}
