package helpers;

import app.ApplicationManager;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void openLoginPage() {
        driver.get("https://kpfu.ru/");
    }

    public void openProfilePage() {
        driver.findElement(By.xpath("(.//*[normalize-space(text())" +
                " and normalize-space(.)='Забыли пароль?'])[1]/following::input[1]")).click();
    }

    public void openEducation() {
        driver.get("https://shelly.kpfu.ru/e-ksu/new_stud_personal.stud_anketa");
    }

    public void openEducationForm() {
        driver.get("https://shelly.kpfu.ru/e-ksu/new_stud_personal.stud_anketa");
    }
}

