package helpers;

import app.ApplicationManager;
import entities.Education;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertTrue;

public class EducationHelper extends HelperBase {
    private boolean acceptNextAlert = true;
    private final static String newName = "УГАТУ";

    public EducationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void addEducation(Education education) throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Меню'])[1]/following::i[3]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дополнительное образование'])[1]/following::div[1]")).click();
        driver.findElement(By.id("idForm")).click();
        driver.findElement(By.id("p_profdev_datestart")).clear();
        driver.findElement(By.id("p_profdev_datestart")).sendKeys(education.getDateStart());
        driver.findElement(By.id("p_profdev_dateend")).click();
        driver.findElement(By.id("p_profdev_dateend")).clear();
        driver.findElement(By.id("p_profdev_dateend")).sendKeys(education.getDateEnd());
        driver.findElement(By.name("p_language_portal")).click();
        new Select(driver.findElement(By.name("p_language_portal"))).selectByVisibleText("Русский");
        driver.findElement(By.name("p_language_portal")).click();
        driver.findElement(By.id("p_profdev_organization")).click();
        driver.findElement(By.id("p_profdev_organization")).clear();
        driver.findElement(By.id("p_profdev_organization")).sendKeys(education.getOrganization());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Язык портала для публикации'])[1]/following::i[1]")).click();

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::input[1]")).click();
    }

    public void deleteEducation(String deletedElement) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + deletedElement +
                "'])[1]/following::div[1]")).click();
        acceptNextAlert = true;
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::input[2]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Удалить запись[\\s\\S]$"));
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void editEducation(String education) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + education +
                "'])[1]/following::div[1]")).click();
        driver.findElement(By.id("p_profdev_organization")).click();
        driver.findElement(By.id("p_profdev_organization")).clear();
        driver.findElement(By.id("p_profdev_organization")).sendKeys(newName);

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::input[1]")).click();
    }
}
