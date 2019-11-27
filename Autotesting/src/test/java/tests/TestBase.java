package tests;

import app.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {
//    protected static ThreadLocal<ApplicationManager> applicationManager = new ThreadLocal<ApplicationManager>();
    protected static ApplicationManager applicationManager;

//    @Before
//    public void setUp() throws Exception {
//        applicationManager = getInstance();
//    }


    @Before
    public void setUp() throws Exception {
        applicationManager = getInstance();
    }


    private ApplicationManager getInstance() {
        if(applicationManager == null){
            applicationManager = new ApplicationManager();
        }
        return applicationManager;
    }

}
