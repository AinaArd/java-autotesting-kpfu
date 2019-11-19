package tests;

import app.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {
    protected ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = new ApplicationManager();
    }

    @After
    public void tearDown() throws Exception {
      applicationManager.close();
    }

}
