package tests;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static tests.TestBase.applicationManager;

@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class, Test2.class, Test3.class})
public class TestSuite {

    @AfterClass
    public static void tearDown() throws Exception {
        applicationManager.close();
    }
}
