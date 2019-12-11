package helpers;

import entities.Account;
import org.junit.Before;
import tests.TestBase;

public class AuthBase extends TestBase {
    private Account account = new Account("ARArdashirova", "u2hkip8c");

    @Before
    public void login() throws Exception {
        applicationManager.getNavigationHelper().openLoginPage();
        if (!applicationManager.getLoginHelper().isLoggedIn()) {
            applicationManager.getLoginHelper().login(account);
        }
    }
}
