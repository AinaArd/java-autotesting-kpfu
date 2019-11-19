package helpers;

import app.ApplicationManager;
import entities.Account;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(Account account) throws Exception {
        driver.findElement(By.linkText("Личный кабинет")).click();
        driver.findElement(By.name("p_login")).clear();
        driver.findElement(By.name("p_login")).sendKeys(account.getLogin());
        driver.findElement(By.name("p_pass")).clear();
        driver.findElement(By.name("p_pass")).sendKeys(account.getPassword());
    }

    public void logout() {
        driver.findElement(By.linkText("Выход")).click();
    }

}
